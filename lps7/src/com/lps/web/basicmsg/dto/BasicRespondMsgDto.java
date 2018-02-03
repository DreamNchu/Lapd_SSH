package com.lps.web.basicmsg.dto;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lps.model.basic.Entity;
import com.lps.web.annotation.dto.DtoName;
import com.lps.web.annotation.dto.DtoNameNotInitException;
import com.lps.web.order.dto.MapNotInitForClassPathException;

/**
 * 响应数据流
 * 
 * @author 0001
 *
 */
public class BasicRespondMsgDto extends HashMap<String, Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6002570645302786244L;

	private transient Map<String, Object> mapUtil = new HashMap<String, Object>();

	public static final String ERROR_MSG = "errorMsg";
	public static final String SUCCESS_MSG = "successMsg";

	public BasicRespondMsgDto() {
		// System.out.println("construct");
	}

	public void setDefaultErrorMsg() {
		setErrorMsg("执行失败");
	}

	public void setDefaultSuccessMsg() {
		setSuccessMsg("执行成功");
	}

	public Map<String, Object> getMap() {
		return this;
	}

	/**
	 * 默认值为：执行失败
	 * 
	 * @param value
	 */
	public void setErrorMsg(Object value) {
		put(ERROR_MSG, value);
	}

	public void appendErrorMsg(String value) throws Exception {
		Object obj = getErrorMsg();

		if (obj instanceof String) {
			String str = (String) obj;
			str.concat(value);
		} else if (obj instanceof StringBuilder) {
			StringBuilder sb = (StringBuilder) obj;
			sb.append(value);
		} else {
			throw new Exception("getErrorMsg(),返回值不是字符串类型对象");
		}
		setErrorMsg(obj);
	}

	public void appendSuccessMsg(String value) throws Exception {
		Object obj = getSuccessMsg();
		setSuccessMsg(appendMsg(obj, value));
	}

	private Object appendMsg(Object obj, String value) throws Exception {
		if (obj instanceof String) {
			String str = (String) obj;
			str.concat(value);
		} else if (obj instanceof StringBuilder) {
			StringBuilder sb = (StringBuilder) obj;
			sb.append(value);
		} else {
			throw new Exception("getErrorMsg(),返回值不是字符串类型对象");
		}
		return obj;
	}

	/**
	 * 对Field进行map注册，方便对其值进行初始化
	 * 
	 * @throws DtoNameNotInitException
	 */
	public void initMap() {

		Class<?> cla = this.getClass();
		do {
			Field[] fs = cla.getDeclaredFields();

			for (Field field : fs) {
				
				int modefier = Modifier.FINAL | Modifier.TRANSIENT | Modifier.STATIC;

				if ((modefier & field.getModifiers()) != 0) {
					// 如果为transient修饰的变量那么不进行键初始化
					continue;
				}

				try {
					field.setAccessible(true);
					Object obj = field.get(this);

					// 放入map中初始化对象
					if (obj instanceof TableInitDto) {
//						System.out.println(((ParameterizedType) (obj.getClass().getGenericInterfaces()[0]))
//								.getActualTypeArguments()[0].getTypeName());
						mapUtil.put(((ParameterizedType) (obj.getClass().getGenericInterfaces()[0]))
								.getActualTypeArguments()[0].getTypeName(), obj);
					}

					if (obj == null) {
						put(field.getName(), obj);
					} else {

						// 设置返回数据名字
						DtoName dn = obj.getClass().getAnnotation(DtoName.class);
						if (dn != null) {
							put(dn.value(), obj);
						} else {
							put(field.getName(), obj);
						}

					}

				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				} finally {
					field.setAccessible(false);
				}
			}
		} while ((cla = cla.getSuperclass()) != null && cla != BasicRespondMsgDto.class);
	}

	/**
	 * 
	 * 
	 * @param mapL
	 * @throws DtoInitException
	 * @throws MapNotInitForClassPathException
	 */
	@SuppressWarnings("unchecked")
	public void initTable(List<? extends Entity>... listEntities)
			throws DtoInitException, MapNotInitForClassPathException {

		for (List<? extends Entity> entities : listEntities) {
			Class<?> c =  null;
			
			for(int i = 0; i < entities.size(); i ++){
				if(entities.get(i) != null){
					c =  entities.get(i).getClass();
					break;
				}
				
			}
			if(c == null) continue;
			while( c.getName().contains("$")){
				c = c.getSuperclass();
			}
			Object obj = mapUtil.get(c.getName());
			if (obj == null) {
				throw new MapNotInitForClassPathException();
			}
			TableInitDto<Entity> tid = (TableInitDto<Entity>) obj;
			tid.init((List<Entity>) entities);
		}
	}

	public Object getErrorMsg() {
		return get(ERROR_MSG);
	}

	/**
	 * 默认值为：执行成功
	 * 
	 * @param value
	 */
	public void setSuccessMsg(Object value) {
		put(SUCCESS_MSG, value);
	}

	public Object getSuccessMsg() {
		return get(SUCCESS_MSG);
	}

}
