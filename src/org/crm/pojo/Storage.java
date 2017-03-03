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
 * Storage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "storage", catalog = "crm")

public class Storage implements java.io.Serializable {

	// Fields

	private Integer stId;
	private Product product;
	private String stWarehouse;
	private String stWare;
	private Integer stCount;
	private String stRemark;

	// Constructors

	/** default constructor */
	public Storage() {
	}

	/** minimal constructor */
	public Storage(Product product, String stWarehouse, String stWare, Integer stCount) {
		this.product = product;
		this.stWarehouse = stWarehouse;
		this.stWare = stWare;
		this.stCount = stCount;
	}

	/** full constructor */
	public Storage(Product product, String stWarehouse, String stWare, Integer stCount, String stRemark) {
		this.product = product;
		this.stWarehouse = stWarehouse;
		this.stWare = stWare;
		this.stCount = stCount;
		this.stRemark = stRemark;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "st_id", unique = true, nullable = false)

	public Integer getStId() {
		return this.stId;
	}

	public void setStId(Integer stId) {
		this.stId = stId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "st_prd_id", nullable = false)

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "st_warehouse", nullable = false, length = 500)

	public String getStWarehouse() {
		return this.stWarehouse;
	}

	public void setStWarehouse(String stWarehouse) {
		this.stWarehouse = stWarehouse;
	}

	@Column(name = "st_ware", nullable = false, length = 50)

	public String getStWare() {
		return this.stWare;
	}

	public void setStWare(String stWare) {
		this.stWare = stWare;
	}

	@Column(name = "st_count", nullable = false)

	public Integer getStCount() {
		return this.stCount;
	}

	public void setStCount(Integer stCount) {
		this.stCount = stCount;
	}

	@Column(name = "st_remark", length = 500)

	public String getStRemark() {
		return this.stRemark;
	}

	public void setStRemark(String stRemark) {
		this.stRemark = stRemark;
	}

}