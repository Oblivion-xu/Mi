package org.crm.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SysMenu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_menu", catalog = "crm")

public class SysMenu implements java.io.Serializable {

	// Fields

	private Integer menuId;
	private Integer menuParentId;
	private String menuName;
	private Integer menuOrder;
	private String menuUrl;
	private String menuImg;
	private Integer menuLevel;
	private Integer menuState;
	private String menuDesc;

	// Constructors

	/** default constructor */
	public SysMenu() {
	}

	/** minimal constructor */
	public SysMenu(String menuName, String menuUrl, Integer menuLevel, Integer menuState) {
		this.menuName = menuName;
		this.menuUrl = menuUrl;
		this.menuLevel = menuLevel;
		this.menuState = menuState;
	}

	/** full constructor */
	public SysMenu(Integer menuParentId, String menuName, Integer menuOrder, String menuUrl, String menuImg,
			Integer menuLevel, Integer menuState, String menuDesc) {
		this.menuParentId = menuParentId;
		this.menuName = menuName;
		this.menuOrder = menuOrder;
		this.menuUrl = menuUrl;
		this.menuImg = menuImg;
		this.menuLevel = menuLevel;
		this.menuState = menuState;
		this.menuDesc = menuDesc;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "menu_id", unique = true, nullable = false)

	public Integer getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	@Column(name = "menu_parent_id")

	public Integer getMenuParentId() {
		return this.menuParentId;
	}

	public void setMenuParentId(Integer menuParentId) {
		this.menuParentId = menuParentId;
	}

	@Column(name = "menu_name", nullable = false, length = 50)

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@Column(name = "menu_order")

	public Integer getMenuOrder() {
		return this.menuOrder;
	}

	public void setMenuOrder(Integer menuOrder) {
		this.menuOrder = menuOrder;
	}

	@Column(name = "menu_url", nullable = false, length = 200)

	public String getMenuUrl() {
		return this.menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	@Column(name = "menu_img", length = 200)

	public String getMenuImg() {
		return this.menuImg;
	}

	public void setMenuImg(String menuImg) {
		this.menuImg = menuImg;
	}

	@Column(name = "menu_level", nullable = false)

	public Integer getMenuLevel() {
		return this.menuLevel;
	}

	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
	}

	@Column(name = "menu_state", nullable = false)

	public Integer getMenuState() {
		return this.menuState;
	}

	public void setMenuState(Integer menuState) {
		this.menuState = menuState;
	}

	@Column(name = "menu_desc", length = 200)

	public String getMenuDesc() {
		return this.menuDesc;
	}

	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}

}