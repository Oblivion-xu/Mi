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
 * CstLost entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cst_lost", catalog = "crm")

public class CstLost implements java.io.Serializable {

	// Fields

	private Integer lstId;
	private SysUser sysUser;
	private Customer customer;
	private Timestamp lstLastOrderDate;
	private Timestamp lasLostDate;
	private String lstReason;
	private String lstState;
	private Set<LostMeasure> lostMeasures = new HashSet<LostMeasure>(0);

	// Constructors

	/** default constructor */
	public CstLost() {
	}

	/** minimal constructor */
	public CstLost(SysUser sysUser, Customer customer, String lstState) {
		this.sysUser = sysUser;
		this.customer = customer;
		this.lstState = lstState;
	}

	/** full constructor */
	public CstLost(SysUser sysUser, Customer customer, Timestamp lstLastOrderDate, Timestamp lasLostDate,
			String lstReason, String lstState, Set<LostMeasure> lostMeasures) {
		this.sysUser = sysUser;
		this.customer = customer;
		this.lstLastOrderDate = lstLastOrderDate;
		this.lasLostDate = lasLostDate;
		this.lstReason = lstReason;
		this.lstState = lstState;
		this.lostMeasures = lostMeasures;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "lst_id", unique = true, nullable = false)

	public Integer getLstId() {
		return this.lstId;
	}

	public void setLstId(Integer lstId) {
		this.lstId = lstId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lst_manager_id", nullable = false)

	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lst_cust_no", nullable = false)

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Column(name = "lst_last_order_date", length = 19)

	public Timestamp getLstLastOrderDate() {
		return this.lstLastOrderDate;
	}

	public void setLstLastOrderDate(Timestamp lstLastOrderDate) {
		this.lstLastOrderDate = lstLastOrderDate;
	}

	@Column(name = "las_lost_date", length = 19)

	public Timestamp getLasLostDate() {
		return this.lasLostDate;
	}

	public void setLasLostDate(Timestamp lasLostDate) {
		this.lasLostDate = lasLostDate;
	}

	@Column(name = "lst_reason", length = 2000)

	public String getLstReason() {
		return this.lstReason;
	}

	public void setLstReason(String lstReason) {
		this.lstReason = lstReason;
	}

	@Column(name = "lst_state", nullable = false, length = 10)

	public String getLstState() {
		return this.lstState;
	}

	public void setLstState(String lstState) {
		this.lstState = lstState;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cstLost")

	public Set<LostMeasure> getLostMeasures() {
		return this.lostMeasures;
	}

	public void setLostMeasures(Set<LostMeasure> lostMeasures) {
		this.lostMeasures = lostMeasures;
	}

}