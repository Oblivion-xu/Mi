package org.crm.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ProductType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "product_type", catalog = "crm")

public class ProductType implements java.io.Serializable {

	// Fields

	private Integer typeId;
	private String typeName;
	private String typePic;
	private Integer typeParentId;
	private Integer typeLevel;
	private Set<Product> products = new HashSet<Product>(0);

	// Constructors

	/** default constructor */
	public ProductType() {
	}

	/** minimal constructor */
	public ProductType(String typeName) {
		this.typeName = typeName;
	}

	/** full constructor */
	public ProductType(String typeName, String typePic, Integer typeParentId, Integer typeLevel,
			Set<Product> products) {
		this.typeName = typeName;
		this.typePic = typePic;
		this.typeParentId = typeParentId;
		this.typeLevel = typeLevel;
		this.products = products;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "type_id", unique = true, nullable = false)

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	@Column(name = "type_name", nullable = false, length = 50)

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Column(name = "type_pic", length = 50)

	public String getTypePic() {
		return this.typePic;
	}

	public void setTypePic(String typePic) {
		this.typePic = typePic;
	}

	@Column(name = "type_parent_id")

	public Integer getTypeParentId() {
		return this.typeParentId;
	}

	public void setTypeParentId(Integer typeParentId) {
		this.typeParentId = typeParentId;
	}

	@Column(name = "type_level")

	public Integer getTypeLevel() {
		return this.typeLevel;
	}

	public void setTypeLevel(Integer typeLevel) {
		this.typeLevel = typeLevel;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productType")

	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}