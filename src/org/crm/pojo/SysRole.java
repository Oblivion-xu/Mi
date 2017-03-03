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
 * SysRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_role", catalog = "crm")

public class SysRole implements java.io.Serializable {

	// Fields

	private Integer roleId;
	private String roleName;
	private String roleDesc;
	private Integer roleState;
	private Integer roleOrder;
	private Set<SysUser> sysUsers = new HashSet<SysUser>(0);

	// Constructors

	/** default constructor */
	public SysRole() {
	}

	/** minimal constructor */
	public SysRole(String roleName) {
		this.roleName = roleName;
	}

	/** full constructor */
	public SysRole(String roleName, String roleDesc, Integer roleState, Integer roleOrder, Set<SysUser> sysUsers) {
		this.roleName = roleName;
		this.roleDesc = roleDesc;
		this.roleState = roleState;
		this.roleOrder = roleOrder;
		this.sysUsers = sysUsers;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "role_id", unique = true, nullable = false)

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "role_name", nullable = false, length = 50)

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "role_desc", length = 50)

	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	@Column(name = "role_state")

	public Integer getRoleState() {
		return this.roleState;
	}

	public void setRoleState(Integer roleState) {
		this.roleState = roleState;
	}

	@Column(name = "role_order")

	public Integer getRoleOrder() {
		return this.roleOrder;
	}

	public void setRoleOrder(Integer roleOrder) {
		this.roleOrder = roleOrder;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysRole")
	
	public Set<SysUser> getSysUsers() {
		return this.sysUsers;
	}

	public void setSysUsers(Set<SysUser> sysUsers) {
		this.sysUsers = sysUsers;
	}

}