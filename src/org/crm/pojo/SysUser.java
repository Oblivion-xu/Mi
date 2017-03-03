package org.crm.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_user", catalog = "crm", uniqueConstraints = @UniqueConstraint(columnNames = "user_idcard"))

public class SysUser implements java.io.Serializable {

	// Fields

	private Integer userId;
	private SysRole sysRole;
	private SysDept sysDept;
	private String userName;
	private String userPassword;
	private Integer userState;
	private Integer userSex;
	private String userTel;
	private String userEmail;
	private Date userBirth;
	private String userIdcard;
	private String userAddress;
	private String userSchool;
	private String userEducation;
	private String userMajor;
	private String userPic;
	private Date userWorkday;
	private String userRemark;
	private Integer isLogin;
	private Set<SalChance> salChancesForChcDueUser = new HashSet<SalChance>(0);
	private Set<SalChance> salChancesForChcCreateUser = new HashSet<SalChance>(0);
	private Set<CstService> cstServicesForSvrCreateUser = new HashSet<CstService>(0);
	private Set<Customer> customers = new HashSet<Customer>(0);
	private Set<SysUsermsg> sysUsermsgs = new HashSet<SysUsermsg>(0);
	private Set<CstService> cstServicesForSvrDueUser = new HashSet<CstService>(0);
	private Set<SysLogger> sysLoggers = new HashSet<SysLogger>(0);
	private Set<CstLost> cstLosts = new HashSet<CstLost>(0);

	// Constructors

	/** default constructor */
	public SysUser() {
	}

	/** minimal constructor */
	public SysUser(SysRole sysRole, String userName, String userPassword, Integer userState) {
		this.sysRole = sysRole;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userState = userState;
	}

	/** full constructor */
	public SysUser(SysRole sysRole, SysDept sysDept, String userName, String userPassword, Integer userState,
			Integer userSex, String userTel, String userEmail, Date userBirth, String userIdcard, String userAddress,
			String userSchool, String userEducation, String userMajor, String userPic, Date userWorkday,
			String userRemark, Integer isLogin, Set<SalChance> salChancesForChcDueUser,
			Set<SalChance> salChancesForChcCreateUser, Set<CstService> cstServicesForSvrCreateUser,
			Set<Customer> customers, Set<SysUsermsg> sysUsermsgs, Set<CstService> cstServicesForSvrDueUser,
			Set<SysLogger> sysLoggers, Set<CstLost> cstLosts) {
		this.sysRole = sysRole;
		this.sysDept = sysDept;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userState = userState;
		this.userSex = userSex;
		this.userTel = userTel;
		this.userEmail = userEmail;
		this.userBirth = userBirth;
		this.userIdcard = userIdcard;
		this.userAddress = userAddress;
		this.userSchool = userSchool;
		this.userEducation = userEducation;
		this.userMajor = userMajor;
		this.userPic = userPic;
		this.userWorkday = userWorkday;
		this.userRemark = userRemark;
		this.isLogin = isLogin;
		this.salChancesForChcDueUser = salChancesForChcDueUser;
		this.salChancesForChcCreateUser = salChancesForChcCreateUser;
		this.cstServicesForSvrCreateUser = cstServicesForSvrCreateUser;
		this.customers = customers;
		this.sysUsermsgs = sysUsermsgs;
		this.cstServicesForSvrDueUser = cstServicesForSvrDueUser;
		this.sysLoggers = sysLoggers;
		this.cstLosts = cstLosts;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "user_id", unique = true, nullable = false)

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_role_id", nullable = false)

	public SysRole getSysRole() {
		return this.sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_id")

	public SysDept getSysDept() {
		return this.sysDept;
	}

	public void setSysDept(SysDept sysDept) {
		this.sysDept = sysDept;
	}

	@Column(name = "user_name", nullable = false, length = 50)

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_password", nullable = false, length = 50)

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "user_state", nullable = false)

	public Integer getUserState() {
		return this.userState;
	}

	public void setUserState(Integer userState) {
		this.userState = userState;
	}

	@Column(name = "user_sex")

	public Integer getUserSex() {
		return this.userSex;
	}

	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}

	@Column(name = "user_tel", length = 18)

	public String getUserTel() {
		return this.userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	@Column(name = "user_email", length = 50)

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "user_birth", length = 10)

	public Date getUserBirth() {
		return this.userBirth;
	}

	public void setUserBirth(Date userBirth) {
		this.userBirth = userBirth;
	}

	@Column(name = "user_idcard", unique = true, length = 18)

	public String getUserIdcard() {
		return this.userIdcard;
	}

	public void setUserIdcard(String userIdcard) {
		this.userIdcard = userIdcard;
	}

	@Column(name = "user_address", length = 200)

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	@Column(name = "user_school", length = 50)

	public String getUserSchool() {
		return this.userSchool;
	}

	public void setUserSchool(String userSchool) {
		this.userSchool = userSchool;
	}

	@Column(name = "user_education", length = 20)

	public String getUserEducation() {
		return this.userEducation;
	}

	public void setUserEducation(String userEducation) {
		this.userEducation = userEducation;
	}

	@Column(name = "user_major", length = 50)

	public String getUserMajor() {
		return this.userMajor;
	}

	public void setUserMajor(String userMajor) {
		this.userMajor = userMajor;
	}

	@Column(name = "user_pic", length = 50)

	public String getUserPic() {
		return this.userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "user_workday", length = 10)

	public Date getUserWorkday() {
		return this.userWorkday;
	}

	public void setUserWorkday(Date userWorkday) {
		this.userWorkday = userWorkday;
	}

	@Column(name = "user_remark", length = 100)

	public String getUserRemark() {
		return this.userRemark;
	}

	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
	}

	@Column(name = "isLogin")

	public Integer getIsLogin() {
		return this.isLogin;
	}

	public void setIsLogin(Integer isLogin) {
		this.isLogin = isLogin;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysUserByChcDueUser")

	public Set<SalChance> getSalChancesForChcDueUser() {
		return this.salChancesForChcDueUser;
	}

	public void setSalChancesForChcDueUser(Set<SalChance> salChancesForChcDueUser) {
		this.salChancesForChcDueUser = salChancesForChcDueUser;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysUserByChcCreateUser")

	public Set<SalChance> getSalChancesForChcCreateUser() {
		return this.salChancesForChcCreateUser;
	}

	public void setSalChancesForChcCreateUser(Set<SalChance> salChancesForChcCreateUser) {
		this.salChancesForChcCreateUser = salChancesForChcCreateUser;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysUserBySvrCreateUser")

	public Set<CstService> getCstServicesForSvrCreateUser() {
		return this.cstServicesForSvrCreateUser;
	}

	public void setCstServicesForSvrCreateUser(Set<CstService> cstServicesForSvrCreateUser) {
		this.cstServicesForSvrCreateUser = cstServicesForSvrCreateUser;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysUser")

	public Set<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysUser")

	public Set<SysUsermsg> getSysUsermsgs() {
		return this.sysUsermsgs;
	}

	public void setSysUsermsgs(Set<SysUsermsg> sysUsermsgs) {
		this.sysUsermsgs = sysUsermsgs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysUserBySvrDueUser")

	public Set<CstService> getCstServicesForSvrDueUser() {
		return this.cstServicesForSvrDueUser;
	}

	public void setCstServicesForSvrDueUser(Set<CstService> cstServicesForSvrDueUser) {
		this.cstServicesForSvrDueUser = cstServicesForSvrDueUser;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysUser")

	public Set<SysLogger> getSysLoggers() {
		return this.sysLoggers;
	}

	public void setSysLoggers(Set<SysLogger> sysLoggers) {
		this.sysLoggers = sysLoggers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysUser")

	public Set<CstLost> getCstLosts() {
		return this.cstLosts;
	}

	public void setCstLosts(Set<CstLost> cstLosts) {
		this.cstLosts = cstLosts;
	}

}