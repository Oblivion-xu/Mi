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
 * Orders entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orders", catalog = "crm")

public class Orders implements java.io.Serializable {

	// Fields

	private Integer odrId;
	private Customer customer;
	private String odrNumber;
	private Timestamp odrDate;
	private String odrAddress;
	private Double odrTotal;
	private String odrPay;
	private String odrState;
	private Set<OrderItem> orderItems = new HashSet<OrderItem>(0);

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** minimal constructor */
	public Orders(Customer customer, String odrNumber, Timestamp odrDate, Double odrTotal, String odrPay) {
		this.customer = customer;
		this.odrNumber = odrNumber;
		this.odrDate = odrDate;
		this.odrTotal = odrTotal;
		this.odrPay = odrPay;
	}

	/** full constructor */
	public Orders(Customer customer, String odrNumber, Timestamp odrDate, String odrAddress, Double odrTotal,
			String odrPay, String odrState, Set<OrderItem> orderItems) {
		this.customer = customer;
		this.odrNumber = odrNumber;
		this.odrDate = odrDate;
		this.odrAddress = odrAddress;
		this.odrTotal = odrTotal;
		this.odrPay = odrPay;
		this.odrState = odrState;
		this.orderItems = orderItems;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "odr_id", unique = true, nullable = false)

	public Integer getOdrId() {
		return this.odrId;
	}

	public void setOdrId(Integer odrId) {
		this.odrId = odrId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "odr_customer", nullable = false)

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Column(name = "odr_number", nullable = false, length = 18)

	public String getOdrNumber() {
		return this.odrNumber;
	}

	public void setOdrNumber(String odrNumber) {
		this.odrNumber = odrNumber;
	}

	@Column(name = "odr_date", nullable = false, length = 19)

	public Timestamp getOdrDate() {
		return this.odrDate;
	}

	public void setOdrDate(Timestamp odrDate) {
		this.odrDate = odrDate;
	}

	@Column(name = "odr_address", length = 200)

	public String getOdrAddress() {
		return this.odrAddress;
	}

	public void setOdrAddress(String odrAddress) {
		this.odrAddress = odrAddress;
	}

	@Column(name = "odr_total", nullable = false, precision = 22, scale = 0)

	public Double getOdrTotal() {
		return this.odrTotal;
	}

	public void setOdrTotal(Double odrTotal) {
		this.odrTotal = odrTotal;
	}

	@Column(name = "odr_pay", nullable = false, length = 10)

	public String getOdrPay() {
		return this.odrPay;
	}

	public void setOdrPay(String odrPay) {
		this.odrPay = odrPay;
	}

	@Column(name = "odr_state", length = 10)

	public String getOdrState() {
		return this.odrState;
	}

	public void setOdrState(String odrState) {
		this.odrState = odrState;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orders")

	public Set<OrderItem> getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}