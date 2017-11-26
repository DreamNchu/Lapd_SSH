package com.lps.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.lps.model.basic.BasicModel;

/**
 * ClassName:Admin Description:管理员类，用于处理管理员的账号，密码，注册时间，头像等
 * <p>
 * 
 * @author cyl
 * @version 1.0
 *
 */
@Entity
@Table(name = "t_admin")
@TableGenerator(name = "pk_generate", table = "tb_generator", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "admin_PK", allocationSize = 1)

public class Admin implements BasicModel<Integer>, java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -777592858788745544L;
	private Integer id;
	private String userName;
	private String password;
	private Date registerTime;
	private String avatar;

	// Constructors

	/** default constructor */
	/**
	 * 这是Admin类的无参构造函数
	 */
	public Admin() {
	}

	/** minimal constructor */
	/**
	 * Admin构造函数，获取管理员名称，密码，注册时间
	 * <p>
	 * 
	 * @param userName
	 *            管理员名称
	 * @param password
	 *            管理员密码
	 * @param registerTime
	 *            管理员注册时间
	 */
	public Admin(String userName, String password, Date registerTime) {
		this.userName = userName;
		this.password = password;
		this.registerTime = registerTime;
	}

	/** full constructor */
	/**
	 * Admin构造函数，获取管理员名称，密码，注册时间，管理员头像
	 * <p>
	 * 
	 * @param userName
	 *            管理员名称
	 * @param password
	 *            管理员密码
	 * @param registerTime
	 *            管理员注册时间
	 * @param avatar
	 *            管理员头像
	 */
	public Admin(String userName, String password, Date registerTime, String avatar) {
		this.userName = userName;
		this.password = password;
		this.registerTime = registerTime;
		this.avatar = avatar;
	}

	// Property accessors

	/**
	 * 获取id值
	 * <p>
	 * 
	 * @return 返回id,Interger类型
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pk_generate")

	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	/**
	 * 设置id值
	 * <p>
	 * 
	 * @param id
	 *            管理员id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取username
	 * <p>
	 * 
	 * @return 返回用户名username,String类型
	 */
	@Column(name = "userName", unique = true, nullable = false, length = 15)

	public String getUserName() {
		return this.userName;
	}

	/**
	 * 设置username值
	 * <p>
	 * 
	 * @param username
	 *            管理员账户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获取password
	 * <p>
	 * 
	 * @return 返回密码password,String类型
	 */
	@Column(name = "password", nullable = false, length = 15)

	public String getPassword() {
		return this.password;
	}

	/**
	 * 设置password值
	 * <p>
	 * 
	 * @param password
	 *            管理员密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取registerTime
	 * <p>
	 * 
	 * @return 返回注册时间,Date类型
	 * 
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "registerTime", nullable = false, length = 10)

	public Date getRegisterTime() {
		return this.registerTime;
	}

	/**
	 * 设置注册时间值
	 * <p>
	 * 
	 * @param registerTime
	 *            管理员注册时间
	 */
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	/**
	 * 获取头像Avatar
	 * <p>
	 * 
	 * @return 返回头像Avatar,String类型
	 */
	@Column(name = "avatar")

	public String getAvatar() {
		return this.avatar;
	}

	/**
	 * 设置头像
	 * <p>
	 * 
	 * @param avatar
	 *            管理员头像
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * ClassName:Builder
	 * Description:内部类，可以访问外部类里管理员的账号，密码，注册时间，头像等，也可以访问每个属性的set方法
	 * <p>
	 * 
	 * @see Admin
	 * @author cyl
	 * @version 1.0
	 *
	 */
	public static class Builder {

		private String userName;
		private String password;
		private Date registerTime;
		private String avatar;

		/**
		 * 设置管理员的账户名
		 * <p>
		 * 
		 * @param userName
		 *            管理员账户 String类型
		 * @return 管理员账户 String类型
		 */

		public Builder setUserName(String userName) {
			this.userName = userName;
			return this;
		}

		/**
		 * 设置管理员的密码
		 * <p>
		 * 
		 * @param password
		 *            管理员密码 String类型
		 * @return 管理员密码 String类型
		 */
		public Builder setPassword(String password) {
			this.password = password;
			return this;
		}

		/**
		 * 设置管理员的注册时间
		 * <p>
		 * 
		 * @param userName
		 *            管理员账户 String类型
		 * @return 管理员账户 String类型
		 */
		public Builder setRegisterTime(Date registerTime) {
			this.registerTime = registerTime;
			return this;
		}

		/**
		 * 设置管理员的头像
		 * <p>
		 * 
		 * @param avatar
		 *            管理员头像 String类型
		 * @return 管理员头像路径 String类型
		 */
		public Builder setAvatar(String avatar) {
			this.avatar = avatar;
			return this;
		}

		/**
		 * build方法，返回管理员名称，密码，注册时间，管理员头像
		 * 
		 * @return 返回Admin实例
		 */
		public Admin build() {
			return new Admin(userName, password, registerTime, avatar);
		}
	}
}
