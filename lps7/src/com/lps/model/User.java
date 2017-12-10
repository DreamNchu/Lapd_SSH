package com.lps.model;
// default package

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.lps.model.basic.ModelLinkServerOrder;

/**
 * ClassName:User
 * Description:User类继承自java.io.Serializable接口，用户类，包含用户的一些基本属性，包含这些属性的get set方法
 * <p>
 * 
 * @author cyl
 * @version 1.0
 *
 */
@Entity
@Table(name = "t_user")
@TableGenerator(name = "pk_generate", table = "tb_generator", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "user_PK", allocationSize = 1)
public class User implements java.io.Serializable, ModelLinkServerOrder<Integer> {

	/**
	 * ClassName:Builder Description:内部类，可以访问外部类里的属性，也可以访问属性的set方法
	 * <p>
	 * 
	 * @see User
	 * @author cyl
	 * @version 1.0
	 *
	 */
	public static class Builder {
		private int id;
		private WorkStatus workStatus;
		private String userName;
		private String password;
		private Integer workId;
		private Date birthday;
		private String telephonePhone;
		private String email;
		private String address;
		private String avatar;
		private String question;
		private String answer;
		private Date registerTime;
		private WorkRank workRank;
		private String realName;
		private String IDCardNo;

		/**
		 * build方法，返回用户信息
		 * <p>
		 * 
		 * @return User实例
		 */
		public User build() {
			return new User(id ,workStatus, userName, password, workId, birthday, telephonePhone, email, address, avatar,
					question, answer, registerTime, workRank,realName, IDCardNo);
		}

		/**
		 * 这个方法用于设置地址
		 * <p>
		 * 
		 * @param address
		 *            地址
		 * @return 地址
		 */
		public Builder setAddress(String address) {
			this.address = address;
			return this;
		}
		/**
		 * 真实姓名
		 * @param realName
		 * @return
		 */
		public Builder setRealName(String realName) {
			this.realName = realName;
			return this;
		}
		
		public Builder setIDCardNo(String IDCardNo){
			this.IDCardNo = IDCardNo;
			return this;
		}
		
		public Builder setId(int id){
			this.id = id;
			return this;
		}

		/**
		 * 这个方法用于设置问题答案
		 * <p>
		 * 
		 * @param answer
		 *            答案
		 * @return 答案
		 */
		public Builder setAnswer(String answer) {
			this.answer = answer;
			return this;
		}

		/**
		 * 这个方法用于设置头像
		 * <p>
		 * 
		 * @param avatar
		 *            头像
		 * @return 头像
		 */
		public Builder setAvatar(String avatar) {
			this.avatar = avatar;
			return this;
		}

		/**
		 * 这个方法用于设置生日
		 * <p>
		 * 
		 * @param birthday
		 *            生日
		 * @return 生日
		 */
		public Builder setBirthday(Date birthday) {
			this.birthday = birthday;
			return this;
		}

		/**
		 * 这个方法用于设置email
		 * <p>
		 * 
		 * @param email
		 *            邮箱
		 * @return 邮箱
		 */
		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}

		/**
		 * 这个方法用于设置用户密码
		 * <p>
		 * 
		 * @param password
		 *            用户密码
		 * @return 用户密码
		 */
		public Builder setPassword(String password) {
			this.password = password;
			return this;
		}

		/**
		 * 这个方法用于设置密码找回问题
		 * <p>
		 * 
		 * @param question
		 *            密码找回问题
		 * @return 密码找回问题
		 */
		public Builder setQuestion(String question) {
			this.question = question;
			return this;
		}

		/**
		 * 这个方法用于设置注册时间
		 * <p>
		 * 
		 * @param registerTime
		 *            注册时间
		 * @return 注册时间
		 */
		public Builder setRegisterTime(Date registerTime) {
			this.registerTime = registerTime;
			return this;
		}

		/**
		 * 这个方法用于设置电话号
		 * <p>
		 * 
		 * @param telephonePhone
		 *            电话号
		 * @return 电话号
		 */
		public Builder setTelephonePhone(String telephonePhone) {
			this.telephonePhone = telephonePhone;
			return this;
		}

		/**
		 * 这个方法用于设置用户名
		 * <p>
		 * 
		 * @param userName
		 *            用户名
		 * @return 用户名
		 */
		public Builder setUserName(String userName) {
			this.userName = userName;
			return this;
		}

		/**
		 * 这个方法用于设置工号
		 * <p>
		 * 
		 * @param workId
		 * @return 工号
		 */
		public Builder setWorkId(Integer workId) {
			this.workId = workId;
			return this;
		}

		/**
		 * 这个方法用于设置工作排序
		 * <p>
		 * 
		 * @param workRank
		 *            工作排序
		 * @return 工作排序
		 */
		public Builder setWorkRank(WorkRank workRank) {
			this.workRank = workRank;
			return this;
		}

		/**
		 * 这个方法用于设置工作状态
		 * <p>
		 * 
		 * @param workStatus
		 *            工作状态
		 * @return 工作状态
		 */
		public Builder setWorkStatus(WorkStatus workStatus) {
			this.workStatus = workStatus;
			return this;
		}
	}

	/**
	* 
	*/
	private static final long serialVersionUID = -8076582509975805828L;
	private Integer id;
	private WorkStatus workStatus;
	private String userName;
	private String password;
	private Integer workId;
	private Date birthday;
	private String telephonePhone;
	private String email;
	private String address;
	private String avatar;
	private String question;
	private String answer;
	private Date registerTime;
	private WorkRank workRank;
	private String realName;
	private String IDCardNo;
	private Set<ServerOrder> serverOrders = new TreeSet<ServerOrder>();

	/** default constructor */
	/**
	 * 这是User类的无参构造函数
	 */
	public User() {
	}

	/** minimal constructor */
	/**
	 * 这是User类的构造函数
	 * <p>
	 * 
	 * @param userName
	 *            员工名 String类型
	 * @param password
	 *            密码 String类型
	 * @param question
	 *            找回密码问题 String类型
	 * @param answer
	 *            找回密码答案 String类型
	 * @param registerTime
	 *            注册时间 Date类型
	 * @param workStatus
	 *            工作状态
	 */
	public User(String userName, String password, String question, String answer, Date registerTime,
			WorkStatus workStatus) {
		this.userName = userName;
		this.password = password;
		this.question = question;
		this.workStatus = workStatus;
		this.answer = answer;
		this.registerTime = registerTime;
	}

	/** full constructor */
	/**
	 * 这是User类的构造函数
	 * <p>
	 * 
	 * @param workStatus
	 *            工作状态
	 * @param userName
	 *            员工名 String类型
	 * @param password
	 *            密码 String类型
	 * @param workId
	 *            员工工号 Integer类型
	 * @param birthday
	 *            生日 Date类型
	 * @param telephonePhone
	 *            电话号 String类型
	 * @param email
	 *            邮箱 String类型
	 * @param address
	 *            地址 String类型
	 * @param avatar
	 *            头像 String类型
	 * @param question
	 *            问题 String类型
	 * @param answer
	 *            答案 String类型
	 * @param registerTime
	 *            注册时间 Date类型
	 * @param workRank
	 *            工作排序
	 */
	public User(WorkStatus workStatus, String userName, String password, Integer workId, Date birthday,
			String telephonePhone, String email, String address, String avatar, String question, String answer,
			Date registerTime, WorkRank workRank) {
		this.workStatus = workStatus;
		this.userName = userName;
		this.password = password;
		this.workId = workId;
		this.birthday = birthday;
		this.telephonePhone = telephonePhone;
		this.email = email;
		this.address = address;
		this.avatar = avatar;
		this.question = question;
		this.answer = answer;
		this.registerTime = registerTime;
	
		this.workRank = workRank;
	}

	public User(int id2, WorkStatus workStatus2, String userName2, String password2, Integer workId2, Date birthday2,
			String telephonePhone2, String email2, String address2, String avatar2, String question2, String answer2,
			Date registerTime2, WorkRank workRank2,String realName, String IDCardNo) {
		this(workStatus2, userName2, password2, workId2, birthday2, telephonePhone2, email2, address2, avatar2, question2, answer2, registerTime2, workRank2);
		this.id = id2;
		this.realName = realName;
		this.IDCardNo = IDCardNo;
	}

	/**
	 * 获取地址
	 * <p>
	 * 
	 * @return 返回地址,String类型
	 */
	@Column(name = "address", length = 200)

	public String getAddress() {
		return this.address;
	}

	/**
	 * 获取问题答案
	 * <p>
	 * 
	 * @return 返回问题答案,String类型
	 */
	@Column(name = "answer", nullable = false, length = 100)

	public String getAnswer() {
		return this.answer;
	}

	// Constructors

	/**
	 * 获取头像
	 * <p>
	 * 
	 * @return 返回头像,String类型
	 */
	@Column(name = "avatar")

	public String getAvatar() {
		return this.avatar;
	}

	/**
	 * 获取生日
	 * <p>
	 * 
	 * @return 返回生日,Date类型
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "birthday", length = 10)

	public Date getBirthday() {
		return this.birthday;
	}

	/**
	 * 获取email
	 * <p>
	 * 
	 * @return 返回email,String类型
	 */
	@Column(name = "email", length = 20)

	public String getEmail() {
		return this.email;
	}

	/**
	 * 获取id值
	 * <p>
	 * 
	 * @return 返回id,Interger类型
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pk_generate")
	@Column(name = "id", unique = true, nullable = false)
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * 返回用户的身份证号码
	 * 
	 * @return 返回用户的身份证号码
	 */
	@Column(name = "IDCardNo")
	public String getIDCardNo() {
		return IDCardNo;
	}

	/**
	 * 获取密码
	 * <p>
	 * 
	 * @return 返回密码,String类型
	 */
	@Column(name = "password", nullable = false, length = 45)

	public String getPassword() {
		return this.password;
	}

	/**
	 * 获取密码找回问题
	 * <p>
	 * 
	 * @return 返回问题,String类型
	 */
	@Column(name = "question", nullable = false, length = 20)

	public String getQuestion() {
		return this.question;
	}

	/**
	 * 返回用户的真实姓名
	 * 
	 * @return 返回用户的真实姓名
	 */
	@Column(name = "realName")
	public String getRealName() {
		return realName;
	}

	/**
	 * 获取id值
	 * <p>
	 * 
	 * @return 返回注册时间,Date类型
	 */
	@Column(name = "registerTime", nullable = false, length = 19)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getRegisterTime() {
		return this.registerTime;
	}

	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY, 
			mappedBy = "user")
	public Set<ServerOrder> getServerOrders() {
		return this.serverOrders;
	}

	/**
	 * 获取电话号
	 * <p>
	 * 
	 * @return 返回电话号,String类型
	 */
	@Column(name = "telephonePhone", length = 15)

	public String getTelephonePhone() {
		return this.telephonePhone;
	}

	/**
	 * 获取用户名
	 * <p>
	 * 
	 * @return 返回用户名,String类型
	 */
	@Column(name = "userName", unique = true, nullable = false, length = 45)

	public String getUserName() {
		return this.userName;
	}

	/**
	 * 获取员工工号
	 * <p>
	 * 
	 * @return 返回员工工号,Interger类型
	 */
	@Column(name = "workId", unique = true)

	public Integer getWorkId() {
		return this.workId;
	}

	/**
	 * 获取工作排序
	 * <p>
	 * 
	 * @see WorkRank
	 * @return 返回工作排序
	 */
	@OneToOne(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)

	public WorkRank getWorkRank() {
		return workRank;
	}

	/**
	 * 获取工作状态
	 * <p>
	 * 
	 * @see WorkStatus
	 * @return 返回工作状态
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "workStatus")
	public WorkStatus getWorkStatus() {
		return this.workStatus;
	}

	/**
	 * 设置地址
	 * <p>
	 * 
	 * @param address
	 *            设置地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 设置答案
	 * <p>
	 * 
	 * @param answer
	 *            设置答案
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * 设置头像
	 * <p>
	 * 
	 * @param avatar
	 *            设置头像
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * 设置生日
	 * <p>
	 * 
	 * @param birthday
	 *            设置生日
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * 设置email
	 * <p>
	 * 
	 * @param email
	 *            设置email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 设置id值
	 * <p>
	 * 
	 * @param id
	 *            设置id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 设置用户的身份证号码
	 * 
	 * @param iDCardNo
	 *            用户的身份证号码
	 */
	public void setIDCardNo(String iDCardNo) {
		IDCardNo = iDCardNo;
	}

	/**
	 * 设置密码
	 * <p>
	 * 
	 * @param password
	 *            设置密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 设置密码找回问题
	 * <p>
	 * 
	 * @param question
	 *            设置问题
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * 设置用户的真实姓名
	 * 
	 * @param realName
	 *            用户的真实姓名
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * 设置注册时间
	 * <p>
	 * 
	 * @param registerTime
	 *            设置注册时间
	 */
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public void setServerOrders(Set<ServerOrder> serverOrders) {
		this.serverOrders = serverOrders;
	}

	/**
	 * 设置电话号
	 * <p>
	 * 
	 * @param telephonePhone
	 *            设置电话号
	 */
	public void setTelephonePhone(String telephonePhone) {
		this.telephonePhone = telephonePhone;
	}

	/**
	 * 设置用户名
	 * <p>
	 * 
	 * @param userName
	 *            设置用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 设置员工工号
	 * <p>
	 * 
	 * @param workId
	 *            设置员工工号
	 */
	public void setWorkId(Integer workId) {
		this.workId = workId;
	}

	/**
	 * 设置工作排序
	 * <p>
	 * 
	 * @param workRank
	 *            设置工作排序
	 */
	public void setWorkRank(WorkRank workRank) {
		this.workRank = workRank;
	}

	/**
	 * 设置工作状态
	 * <p>
	 * 
	 * @param workStatus
	 *            设置工作状态
	 */
	public void setWorkStatus(WorkStatus workStatus) {
		this.workStatus = workStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}