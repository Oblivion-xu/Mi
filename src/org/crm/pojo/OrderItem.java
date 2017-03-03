package org.crm.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * OrderItem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "order_item", catalog = "crm")

public class OrderItem implements java.io.Serializable {

	// Fields

	private Integer itemId;
	private Orders orders;
	private Product product;
	private Integer prdCount;

	// Constructors

	/** default constructor */
	public OrderItem() {
	}

	/** full constructor */
	public OrderItem(Orders orders, Product product, Integer prdCount) {
		this.orders = orders;
		this.product = product;
		this.prdCount = prdCount;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "item_id", unique = true, nullable = false)

	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_order_id", nullable = false)

	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_prd_id", nullable = false)

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "prd_count", nullable = false)

	public Integer getPrdCount() {
		return this.prdCount;
	}

	public void setPrdCount(Integer prdCount) {
		this.prdCount = prdCount;
	}

}