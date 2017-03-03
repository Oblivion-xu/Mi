package org.crm.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * BasDict entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bas_dict", catalog = "crm")

public class BasDict implements java.io.Serializable {

	// Fields

	private Integer dictId;
	private String dictType;
	private String dictItem;
	private Integer dictValue;
	private Integer dictIsEdit;
	private Integer dictOrder;

	// Constructors

	/** default constructor */
	public BasDict() {
	}

	/** minimal constructor */
	public BasDict(String dictType, String dictItem, Integer dictValue, Integer dictIsEdit) {
		this.dictType = dictType;
		this.dictItem = dictItem;
		this.dictValue = dictValue;
		this.dictIsEdit = dictIsEdit;
	}

	/** full constructor */
	public BasDict(String dictType, String dictItem, Integer dictValue, Integer dictIsEdit, Integer dictOrder) {
		this.dictType = dictType;
		this.dictItem = dictItem;
		this.dictValue = dictValue;
		this.dictIsEdit = dictIsEdit;
		this.dictOrder = dictOrder;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "dict_id", unique = true, nullable = false)

	public Integer getDictId() {
		return this.dictId;
	}

	public void setDictId(Integer dictId) {
		this.dictId = dictId;
	}

	@Column(name = "dict_type", nullable = false, length = 50)

	public String getDictType() {
		return this.dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	@Column(name = "dict_item", nullable = false, length = 50)

	public String getDictItem() {
		return this.dictItem;
	}

	public void setDictItem(String dictItem) {
		this.dictItem = dictItem;
	}

	@Column(name = "dict_value", nullable = false)

	public Integer getDictValue() {
		return this.dictValue;
	}

	public void setDictValue(Integer dictValue) {
		this.dictValue = dictValue;
	}

	@Column(name = "dict_is_edit", nullable = false)

	public Integer getDictIsEdit() {
		return this.dictIsEdit;
	}

	public void setDictIsEdit(Integer dictIsEdit) {
		this.dictIsEdit = dictIsEdit;
	}

	@Column(name = "dict_order")

	public Integer getDictOrder() {
		return this.dictOrder;
	}

	public void setDictOrder(Integer dictOrder) {
		this.dictOrder = dictOrder;
	}

}