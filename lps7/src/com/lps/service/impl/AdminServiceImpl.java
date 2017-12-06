package com.lps.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lps.dao.AdminDAO;
import com.lps.dao.impl.AdminDAOImpl;
import com.lps.model.Admin;
import com.lps.model.ClockCategory;
import com.lps.model.ServerOrder;
import com.lps.model.basic.BasicModel;
import com.lps.service.AdminService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;

//@Component("adminServiceImpl")
//@Aspect
public class AdminServiceImpl implements AdminService {

	private AdminDAO dao;

	private PageBean<Admin> pageAdminBean;

	public PageBean<Admin> getPageAdminBean() {
		return pageAdminBean;
	}

	public void setPageAdminBean(PageBean<Admin> pageAdminBean) {
		this.pageAdminBean = pageAdminBean;
	}

	public AdminDAO getAdminDao() {
		return dao;
	}

	// @Resource(name="adminDAOImpl")
	public void setAdminDao(AdminDAO adminDao) {
		this.dao = adminDao;
	}

	@Override
	public void save(Admin admin) {
		dao.save(admin);
	}

	@Override
	public void delete(Admin admin) {
		dao.delete(admin);
	}

	@Override
	public Admin findByUserName(String name) {
		return dao.getByUserName(name);
	}

	@Override
	public Admin findById(int id) {
		return dao.findById(id);
	}

	@Override
	public boolean isExists(Admin admin) {
		return dao.isExists(admin);
	}

	@Override
	public Date findRegisterTime(Admin admin) {
		return findById(admin.getId()).getRegisterTime();
	}

	@Override
	public String getAvatar(Admin admin) {
		return findById(admin.getId()).getAvatar();
	}

	@Override
	public List<Admin> findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}
	/*
	 * @Override public List<Admin> findByRegisterTime(Timestamp value){ return
	 * adminDao.getByRegisterTime(value); }
	 */

	@Override
	public List<Admin> findAll() {
		return dao.findAll();
	}

	@Override
	public long findAllCount() {
		return dao.findAllCount();
	}

	@Override
	public PageBean<Admin> findByPage(int page) throws PagePropertyNotInitException {
		
		
		long begin = pageAdminBean.init(findAllCount(), page);

		List<Admin> list = dao.findListByLimit(begin, pageAdminBean.getLimit());

		pageAdminBean.setList(list);

		return pageAdminBean;
		
	}

	@Override
	public void update(Admin t) {
		dao.update(t);
	}

	@Override
	public String findPasswordByUserName(String userName) {
		int id;
		id = findIdByUserName(userName);
		if(id == NOT_EXISTS){
			throw new UserNotExistsException("用户名不存在");
		}
		Admin admin = new Admin.Builder().setId(id).build();
		return findPassword(admin);
	}

	@Override
	public <T> String findPassword(BasicModel<T> admin) {
		Map<String, Class<?>> map = new HashMap<String, Class<?>>();
		map.put(AdminDAOImpl.PASSWORD, String.class);
		Admin ad = dao.findFields(admin, map);
		if (ad != null) {
			return ad.getPassword();
		}
		return null;
	}

	/**
	 * 不存在返回-1
	 * 
	 */
	@Override
	public int findIdByUserName(String name) {
		Map<String, Object> map = new HashMap<>();
		map.put(AdminDAOImpl.USER_NAME, name);
		List<Object> list = dao.findIdByProperty(map);
		 if(list != null && list.size() > 0){
			return (int) dao.findIdByProperty(map).get(0);
		 }
		 return NOT_EXISTS;
	}
	
	@Override
	public <K> Admin findFields(BasicModel<K> t, Map<String, Class<?>> fields) {
		return dao.findFields(t, fields);
	}

	@Override
	public <K> List<K> findIdByProperty(Map<String, Object> map) {
		return dao.findIdByProperty(map);
	}

}
