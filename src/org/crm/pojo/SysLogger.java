package org.crm.pojo;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * SysLogger entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_logger", catalog = "crm")

public class SysLogger implements java.io.Serializable {

	// Fields

	private Integer logId;
	private SysUser sysUser;
	private String logRole;
	private String logDept;
	private String logDesc;
	private Timestamp logDate;
	private String logIp;

	// Constructors

	/** default constructor */
	public SysLogger() {
	}

	/** minimal constructor */
	public SysLogger(SysUser sysUser, String logDesc, Timestamp logDate) {
		this.sysUser = sysUser;
		this.logDesc = logDesc;
		this.logDate = logDate;
	}

	/** full constructor */
	public SysLogger(SysUser sysUser, String logRole, String logDept, String logDesc, Timestamp logDate, String logIp) {
		this.sysUser = sysUser;
		this.logRole = logRole;
		this.logDept = logDept;
		this.logDesc = logDesc;
		this.logDate = logDate;
		this.logIp = logIp;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "log_id", unique = true, nullable = false)

	public Integer getLogId() {
		return this.logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "log_user", nullable = false)

	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	@Column(name = "log_role", length = 20)

	public String getLogRole() {
		return this.logRole;
	}

	public void setLogRole(String logRole) {
		this.logRole = logRole;
	}

	@Column(name = "log_dept", length = 20)

	public String getLogDept() {
		return this.logDept;
	}

	public void setLogDept(String logDept) {
		this.logDept = logDept;
	}

	@Column(name = "log_desc", nullable = false, length = 50)

	public String getLogDesc() {
		return this.logDesc;
	}

	public void setLogDesc(String logDesc) {
		this.logDesc = logDesc;
	}

	@Column(name = "log_date", nullable = false, length = 19)

	public Timestamp getLogDate() {
		return this.logDate;
	}

	public void setLogDate(Timestamp logDate) {
		this.logDate = logDate;
	}

	@Column(name = "log_ip", length = 50)

	public String getLogIp() {
		return this.logIp;
	}

	public void setLogIp(String logIp) {
		this.logIp = logIp;
	}

}