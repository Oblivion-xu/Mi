package org.crm.pojo;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CstService entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cst_service", catalog = "crm")

public class CstService implements java.io.Serializable {

	// Fields

	private Integer svrId;
	private SysUser sysUserBySvrDueUser;
	private SysUser sysUserBySvrCreateUser;
	private Customer customer;
	private String svrType;
	private String svrTitle;
	private String svrState;
	private String svrRequest;
	private Timestamp svrCreateDate;
	private Timestamp svrDueDate;
	private String svrDeal;
	private Timestamp svrDealDate;
	private String svrResult;
	private Integer svrSatisfy;

	// Constructors

	/** default constructor */
	public CstService() {
	}

	/** minimal constructor */
	public CstService(SysUser sysUserBySvrCreateUser, Customer customer, String svrType, String svrTitle,
			String svrState, String svrRequest, Timestamp svrCreateDate) {
		this.sysUserBySvrCreateUser = sysUserBySvrCreateUser;
		this.customer = customer;
		this.svrType = svrType;
		this.svrTitle = svrTitle;
		this.svrState = svrState;
		this.svrRequest = svrRequest;
		this.svrCreateDate = svrCreateDate;
	}

	/** full constructor */
	public CstService(SysUser sysUserBySvrDueUser, SysUser sysUserBySvrCreateUser, Customer customer, String svrType,
			String svrTitle, String svrState, String svrRequest, Timestamp svrCreateDate, Timestamp svrDueDate,
			String svrDeal, Timestamp svrDealDate, String svrResult, Integer svrSatisfy) {
		this.sysUserBySvrDueUser = sysUserBySvrDueUser;
		this.sysUserBySvrCreateUser = sysUserBySvrCreateUser;
		this.customer = customer;
		this.svrType = svrType;
		this.svrTitle = svrTitle;
		this.svrState = svrState;
		this.svrRequest = svrRequest;
		this.svrCreateDate = svrCreateDate;
		this.svrDueDate = svrDueDate;
		this.svrDeal = svrDeal;
		this.svrDealDate = svrDealDate;
		this.svrResult = svrResult;
		this.svrSatisfy = svrSatisfy;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "svr_id", unique = true, nullable = false)

	public Integer getSvrId() {
		return this.svrId;
	}

	public void setSvrId(Integer svrId) {
		this.svrId = svrId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "svr_due_user")

	public SysUser getSysUserBySvrDueUser() {
		return this.sysUserBySvrDueUser;
	}

	public void setSysUserBySvrDueUser(SysUser sysUserBySvrDueUser) {
		this.sysUserBySvrDueUser = sysUserBySvrDueUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "svr_create_user", nullable = false)

	public SysUser getSysUserBySvrCreateUser() {
		return this.sysUserBySvrCreateUser;
	}

	public void setSysUserBySvrCreateUser(SysUser sysUserBySvrCreateUser) {
		this.sysUserBySvrCreateUser = sysUserBySvrCreateUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "svr_cust_no", nullable = false)

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Column(name = "svr_type", nullable = false, length = 20)

	public String getSvrType() {
		return this.svrType;
	}

	public void setSvrType(String svrType) {
		this.svrType = svrType;
	}

	@Column(name = "svr_title", nullable = false, length = 500)

	public String getSvrTitle() {
		return this.svrTitle;
	}

	public void setSvrTitle(String svrTitle) {
		this.svrTitle = svrTitle;
	}

	@Column(name = "svr_state", nullable = false, length = 20)

	public String getSvrState() {
		return this.svrState;
	}

	public void setSvrState(String svrState) {
		this.svrState = svrState;
	}

	@Column(name = "svr_request", nullable = false, length = 3000)

	public String getSvrRequest() {
		return this.svrRequest;
	}

	public void setSvrRequest(String svrRequest) {
		this.svrRequest = svrRequest;
	}

	@Column(name = "svr_create_date", nullable = false, length = 19)

	public Timestamp getSvrCreateDate() {
		return this.svrCreateDate;
	}

	public void setSvrCreateDate(Timestamp svrCreateDate) {
		this.svrCreateDate = svrCreateDate;
	}

	@Column(name = "svr_due_date", length = 19)

	public Timestamp getSvrDueDate() {
		return this.svrDueDate;
	}

	public void setSvrDueDate(Timestamp svrDueDate) {
		this.svrDueDate = svrDueDate;
	}

	@Column(name = "svr_deal", length = 3000)

	public String getSvrDeal() {
		return this.svrDeal;
	}

	public void setSvrDeal(String svrDeal) {
		this.svrDeal = svrDeal;
	}

	@Column(name = "svr_deal_date", length = 19)

	public Timestamp getSvrDealDate() {
		return this.svrDealDate;
	}

	public void setSvrDealDate(Timestamp svrDealDate) {
		this.svrDealDate = svrDealDate;
	}

	@Column(name = "svr_result", length = 500)

	public String getSvrResult() {
		return this.svrResult;
	}

	public void setSvrResult(String svrResult) {
		this.svrResult = svrResult;
	}

	@Column(name = "svr_satisfy")

	public Integer getSvrSatisfy() {
		return this.svrSatisfy;
	}

	public void setSvrSatisfy(Integer svrSatisfy) {
		this.svrSatisfy = svrSatisfy;
	}

}