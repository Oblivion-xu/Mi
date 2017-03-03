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
 * CstActity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cst_actity", catalog = "crm")

public class CstActity implements java.io.Serializable {

	// Fields

	private Integer atvId;
	private Customer customer;
	private Timestamp atvDate;
	private String atvPlace;
	private String atvTitle;
	private String atvDesc;
	private String atvRemark;

	// Constructors

	/** default constructor */
	public CstActity() {
	}

	/** minimal constructor */
	public CstActity(Customer customer, Timestamp atvDate) {
		this.customer = customer;
		this.atvDate = atvDate;
	}

	/** full constructor */
	public CstActity(Customer customer, Timestamp atvDate, String atvPlace, String atvTitle, String atvDesc,
			String atvRemark) {
		this.customer = customer;
		this.atvDate = atvDate;
		this.atvPlace = atvPlace;
		this.atvTitle = atvTitle;
		this.atvDesc = atvDesc;
		this.atvRemark = atvRemark;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "atv_id", unique = true, nullable = false)

	public Integer getAtvId() {
		return this.atvId;
	}

	public void setAtvId(Integer atvId) {
		this.atvId = atvId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "atv_cust_no", nullable = false)

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Column(name = "atv_date", nullable = false, length = 19)

	public Timestamp getAtvDate() {
		return this.atvDate;
	}

	public void setAtvDate(Timestamp atvDate) {
		this.atvDate = atvDate;
	}

	@Column(name = "atv_place", length = 200)

	public String getAtvPlace() {
		return this.atvPlace;
	}

	public void setAtvPlace(String atvPlace) {
		this.atvPlace = atvPlace;
	}

	@Column(name = "atv_title", length = 200)

	public String getAtvTitle() {
		return this.atvTitle;
	}

	public void setAtvTitle(String atvTitle) {
		this.atvTitle = atvTitle;
	}

	@Column(name = "atv_desc", length = 2000)

	public String getAtvDesc() {
		return this.atvDesc;
	}

	public void setAtvDesc(String atvDesc) {
		this.atvDesc = atvDesc;
	}

	@Column(name = "atv_remark", length = 200)

	public String getAtvRemark() {
		return this.atvRemark;
	}

	public void setAtvRemark(String atvRemark) {
		this.atvRemark = atvRemark;
	}

}