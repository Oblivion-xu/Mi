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
 * SysDept entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_dept", catalog = "crm")

public class SysDept implements java.io.Serializable {

	// Fields

	private Integer deptId;
	private String deptName;
	private Integer deptParentId;
	private Integer deptLevel;
	private Set<SysUser> sysUsers = new HashSet<SysUser>(0);

	// Constructors

	/** default constructor */
	public SysDept() {
	}

	/** minimal constructor */
	public SysDept(String deptName) {
		this.deptName = deptName;
	}

	/** full constructor */
	public SysDept(String deptName, Integer deptParentId, Integer deptLevel, Set<SysUser> sysUsers) {
		this.deptName = deptName;
		this.deptParentId = deptParentId;
		this.deptLevel = deptLevel;
		this.sysUsers = sysUsers;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "dept_id", unique = true, nullable = false)

	public Integer getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	@Column(name = "dept_name", nullable = false, length = 20)

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Column(name = "dept_parent_id")

	public Integer getDeptParentId() {
		return this.deptParentId;
	}

	public void setDeptParentId(Integer deptParentId) {
		this.deptParentId = deptParentId;
	}

	@Column(name = "dept_level")

	public Integer getDeptLevel() {
		return this.deptLevel;
	}

	public void setDeptLevel(Integer deptLevel) {
		this.deptLevel = deptLevel;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysDept")

	public Set<SysUser> getSysUsers() {
		return this.sysUsers;
	}

	public void setSysUsers(Set<SysUser> sysUsers) {
		this.sysUsers = sysUsers;
	}

}