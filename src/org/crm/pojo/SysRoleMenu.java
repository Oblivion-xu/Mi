package org.crm.pojo;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * SysRoleMenu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_role_menu", catalog = "crm")

public class SysRoleMenu implements java.io.Serializable {

	// Fields

	private SysRoleMenuId id;

	// Constructors

	/** default constructor */
	public SysRoleMenu() {
	}

	/** full constructor */
	public SysRoleMenu(SysRoleMenuId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "roleId", column = @Column(name = "role_id")),
			@AttributeOverride(name = "menuId", column = @Column(name = "menu_id")) })

	public SysRoleMenuId getId() {
		return this.id;
	}

	public void setId(SysRoleMenuId id) {
		this.id = id;
	}

}