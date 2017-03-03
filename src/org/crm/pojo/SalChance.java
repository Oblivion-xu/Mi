package org.crm.pojo;

import java.sql.Timestamp;
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

/**
 * SalChance entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sal_chance", catalog = "crm")

public class SalChance implements java.io.Serializable {

	// Fields

	private Integer chcId;
	private SysUser sysUserByChcCreateUser;
	private SysUser sysUserByChcDueUser;
	private String chcSource;
	private String chcCustname;
	private String chcTitle;
	private Integer chcRate;
	private String chcLinkman;
	private String chcTel;
	private String chcDesc;
	private Timestamp chcCreateDate;
	private Timestamp chcDueDate;
	private String chcDueState;
	private String chcPriority;
	private Set<SalPlan> salPlans = new HashSet<SalPlan>(0);

	// Constructors

	/** default constructor */
	public SalChance() {
	}

	/** minimal constructor */
	public SalChance(SysUser sysUserByChcCreateUser, String chcCustname, String chcTitle, Integer chcRate,
			String chcDesc, Timestamp chcCreateDate) {
		this.sysUserByChcCreateUser = sysUserByChcCreateUser;
		this.chcCustname = chcCustname;
		this.chcTitle = chcTitle;
		this.chcRate = chcRate;
		this.chcDesc = chcDesc;
		this.chcCreateDate = chcCreateDate;
	}

	/** full constructor */
	public SalChance(SysUser sysUserByChcCreateUser, SysUser sysUserByChcDueUser, String chcSource, String chcCustname,
			String chcTitle, Integer chcRate, String chcLinkman, String chcTel, String chcDesc, Timestamp chcCreateDate,
			Timestamp chcDueDate, String chcDueState, String chcPriority, Set<SalPlan> salPlans) {
		this.sysUserByChcCreateUser = sysUserByChcCreateUser;
		this.sysUserByChcDueUser = sysUserByChcDueUser;
		this.chcSource = chcSource;
		this.chcCustname = chcCustname;
		this.chcTitle = chcTitle;
		this.chcRate = chcRate;
		this.chcLinkman = chcLinkman;
		this.chcTel = chcTel;
		this.chcDesc = chcDesc;
		this.chcCreateDate = chcCreateDate;
		this.chcDueDate = chcDueDate;
		this.chcDueState = chcDueState;
		this.chcPriority = chcPriority;
		this.salPlans = salPlans;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "chc_id", unique = true, nullable = false)

	public Integer getChcId() {
		return this.chcId;
	}

	public void setChcId(Integer chcId) {
		this.chcId = chcId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chc_create_user", nullable = false)

	public SysUser getSysUserByChcCreateUser() {
		return this.sysUserByChcCreateUser;
	}

	public void setSysUserByChcCreateUser(SysUser sysUserByChcCreateUser) {
		this.sysUserByChcCreateUser = sysUserByChcCreateUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chc_due_user")

	public SysUser getSysUserByChcDueUser() {
		return this.sysUserByChcDueUser;
	}

	public void setSysUserByChcDueUser(SysUser sysUserByChcDueUser) {
		this.sysUserByChcDueUser = sysUserByChcDueUser;
	}

	@Column(name = "chc_source", length = 50)

	public String getChcSource() {
		return this.chcSource;
	}

	public void setChcSource(String chcSource) {
		this.chcSource = chcSource;
	}

	@Column(name = "chc_custname", nullable = false, length = 100)

	public String getChcCustname() {
		return this.chcCustname;
	}

	public void setChcCustname(String chcCustname) {
		this.chcCustname = chcCustname;
	}

	@Column(name = "chc_title", nullable = false, length = 200)

	public String getChcTitle() {
		return this.chcTitle;
	}

	public void setChcTitle(String chcTitle) {
		this.chcTitle = chcTitle;
	}

	@Column(name = "chc_rate", nullable = false)

	public Integer getChcRate() {
		return this.chcRate;
	}

	public void setChcRate(Integer chcRate) {
		this.chcRate = chcRate;
	}

	@Column(name = "chc_linkman", length = 50)

	public String getChcLinkman() {
		return this.chcLinkman;
	}

	public void setChcLinkman(String chcLinkman) {
		this.chcLinkman = chcLinkman;
	}

	@Column(name = "chc_tel", length = 20)

	public String getChcTel() {
		return this.chcTel;
	}

	public void setChcTel(String chcTel) {
		this.chcTel = chcTel;
	}

	@Column(name = "chc_desc", nullable = false, length = 2000)

	public String getChcDesc() {
		return this.chcDesc;
	}

	public void setChcDesc(String chcDesc) {
		this.chcDesc = chcDesc;
	}

	@Column(name = "chc_create_date", nullable = false, length = 19)

	public Timestamp getChcCreateDate() {
		return this.chcCreateDate;
	}

	public void setChcCreateDate(Timestamp chcCreateDate) {
		this.chcCreateDate = chcCreateDate;
	}

	@Column(name = "chc_due_date", length = 19)

	public Timestamp getChcDueDate() {
		return this.chcDueDate;
	}

	public void setChcDueDate(Timestamp chcDueDate) {
		this.chcDueDate = chcDueDate;
	}

	@Column(name = "chc_due_state", length = 10)

	public String getChcDueState() {
		return this.chcDueState;
	}

	public void setChcDueState(String chcDueState) {
		this.chcDueState = chcDueState;
	}

	@Column(name = "chc_priority", length = 2)

	public String getChcPriority() {
		return this.chcPriority;
	}

	public void setChcPriority(String chcPriority) {
		this.chcPriority = chcPriority;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "salChance")

	public Set<SalPlan> getSalPlans() {
		return this.salPlans;
	}

	public void setSalPlans(Set<SalPlan> salPlans) {
		this.salPlans = salPlans;
	}

}