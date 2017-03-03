package org.crm.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CstLinkman entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cst_linkman", catalog = "crm")

public class CstLinkman implements java.io.Serializable {

	// Fields

	private Integer lkmId;
	private Customer customer;
	private String lkmName;
	private Date lkmBirth;
	private String lkmAddress;
	private String lkmQq;
	private String lkmEmail;
	private Integer lkmSex;
	private String lkmPostion;
	private String lkmTel;
	private String lkmPhone;
	private String lkmInterest;
	private String lkmRemark;

	// Constructors

	/** default constructor */
	public CstLinkman() {
	}

	/** minimal constructor */
	public CstLinkman(Customer customer, String lkmName, String lkmTel) {
		this.customer = customer;
		this.lkmName = lkmName;
		this.lkmTel = lkmTel;
	}

	/** full constructor */
	public CstLinkman(Customer customer, String lkmName, Date lkmBirth, String lkmAddress, String lkmQq,
			String lkmEmail, Integer lkmSex, String lkmPostion, String lkmTel, String lkmPhone, String lkmInterest,
			String lkmRemark) {
		this.customer = customer;
		this.lkmName = lkmName;
		this.lkmBirth = lkmBirth;
		this.lkmAddress = lkmAddress;
		this.lkmQq = lkmQq;
		this.lkmEmail = lkmEmail;
		this.lkmSex = lkmSex;
		this.lkmPostion = lkmPostion;
		this.lkmTel = lkmTel;
		this.lkmPhone = lkmPhone;
		this.lkmInterest = lkmInterest;
		this.lkmRemark = lkmRemark;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "lkm_id", unique = true, nullable = false)

	public Integer getLkmId() {
		return this.lkmId;
	}

	public void setLkmId(Integer lkmId) {
		this.lkmId = lkmId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lkm_cust_no", nullable = false)

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Column(name = "lkm_name", nullable = false, length = 50)

	public String getLkmName() {
		return this.lkmName;
	}

	public void setLkmName(String lkmName) {
		this.lkmName = lkmName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "lkm_birth", length = 10)

	public Date getLkmBirth() {
		return this.lkmBirth;
	}

	public void setLkmBirth(Date lkmBirth) {
		this.lkmBirth = lkmBirth;
	}

	@Column(name = "lkm_address", length = 200)

	public String getLkmAddress() {
		return this.lkmAddress;
	}

	public void setLkmAddress(String lkmAddress) {
		this.lkmAddress = lkmAddress;
	}

	@Column(name = "lkm_qq", length = 20)

	public String getLkmQq() {
		return this.lkmQq;
	}

	public void setLkmQq(String lkmQq) {
		this.lkmQq = lkmQq;
	}

	@Column(name = "lkm_email", length = 50)

	public String getLkmEmail() {
		return this.lkmEmail;
	}

	public void setLkmEmail(String lkmEmail) {
		this.lkmEmail = lkmEmail;
	}

	@Column(name = "lkm_sex")

	public Integer getLkmSex() {
		return this.lkmSex;
	}

	public void setLkmSex(Integer lkmSex) {
		this.lkmSex = lkmSex;
	}

	@Column(name = "lkm_postion", length = 50)

	public String getLkmPostion() {
		return this.lkmPostion;
	}

	public void setLkmPostion(String lkmPostion) {
		this.lkmPostion = lkmPostion;
	}

	@Column(name = "lkm_tel", nullable = false, length = 50)

	public String getLkmTel() {
		return this.lkmTel;
	}

	public void setLkmTel(String lkmTel) {
		this.lkmTel = lkmTel;
	}

	@Column(name = "lkm_phone", length = 20)

	public String getLkmPhone() {
		return this.lkmPhone;
	}

	public void setLkmPhone(String lkmPhone) {
		this.lkmPhone = lkmPhone;
	}

	@Column(name = "lkm_interest", length = 200)

	public String getLkmInterest() {
		return this.lkmInterest;
	}

	public void setLkmInterest(String lkmInterest) {
		this.lkmInterest = lkmInterest;
	}

	@Column(name = "lkm_remark", length = 200)

	public String getLkmRemark() {
		return this.lkmRemark;
	}

	public void setLkmRemark(String lkmRemark) {
		this.lkmRemark = lkmRemark;
	}

}