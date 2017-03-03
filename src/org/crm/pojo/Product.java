package org.crm.pojo;

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
 * Product entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "product", catalog = "crm")

public class Product implements java.io.Serializable {

	// Fields

	private Integer prdId;
	private ProductType productType;
	private String prdName;
	private String prdBatch;
	private String prdUnit;
	private Double prdPrice;
	private String prdRemark;
	private Set<Storage> storages = new HashSet<Storage>(0);
	private Set<OrderItem> orderItems = new HashSet<OrderItem>(0);

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
	public Product(ProductType productType, String prdName) {
		this.productType = productType;
		this.prdName = prdName;
	}

	/** full constructor */
	public Product(ProductType productType, String prdName, String prdBatch, String prdUnit, Double prdPrice,
			String prdRemark, Set<Storage> storages, Set<OrderItem> orderItems) {
		this.productType = productType;
		this.prdName = prdName;
		this.prdBatch = prdBatch;
		this.prdUnit = prdUnit;
		this.prdPrice = prdPrice;
		this.prdRemark = prdRemark;
		this.storages = storages;
		this.orderItems = orderItems;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "prd_id", unique = true, nullable = false)

	public Integer getPrdId() {
		return this.prdId;
	}

	public void setPrdId(Integer prdId) {
		this.prdId = prdId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prd_type", nullable = false)

	public ProductType getProductType() {
		return this.productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	@Column(name = "prd_name", nullable = false, length = 200)

	public String getPrdName() {
		return this.prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}

	@Column(name = "prd_batch", length = 100)

	public String getPrdBatch() {
		return this.prdBatch;
	}

	public void setPrdBatch(String prdBatch) {
		this.prdBatch = prdBatch;
	}

	@Column(name = "prd_unit", length = 10)

	public String getPrdUnit() {
		return this.prdUnit;
	}

	public void setPrdUnit(String prdUnit) {
		this.prdUnit = prdUnit;
	}

	@Column(name = "prd_price", precision = 22, scale = 0)

	public Double getPrdPrice() {
		return this.prdPrice;
	}

	public void setPrdPrice(Double prdPrice) {
		this.prdPrice = prdPrice;
	}

	@Column(name = "prd_remark", length = 200)

	public String getPrdRemark() {
		return this.prdRemark;
	}

	public void setPrdRemark(String prdRemark) {
		this.prdRemark = prdRemark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")

	public Set<Storage> getStorages() {
		return this.storages;
	}

	public void setStorages(Set<Storage> storages) {
		this.storages = storages;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")

	public Set<OrderItem> getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}