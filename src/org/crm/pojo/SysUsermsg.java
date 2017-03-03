package org.crm.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SysUsermsg entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_usermsg", catalog = "crm")

public class SysUsermsg implements java.io.Serializable {

	// Fields

	private Integer id;
	private SysUser sysUser;
	private String content;
	private String postition;
	private String color;
	private Date mdate;

	// Constructors

	/** default constructor */
	public SysUsermsg() {
	}

	/** minimal constructor */
	public SysUsermsg(SysUser sysUser, String content) {
		this.sysUser = sysUser;
		this.content = content;
	}

	/** full constructor */
	public SysUsermsg(SysUser sysUser, String content, String postition, String color, Date mdate) {
		this.sysUser = sysUser;
		this.content = content;
		this.postition = postition;
		this.color = color;
		this.mdate = mdate;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)

	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	@Column(name = "content", nullable = false, length = 200)

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "postition", length = 50)

	public String getPostition() {
		return this.postition;
	}

	public void setPostition(String postition) {
		this.postition = postition;
	}

	@Column(name = "color", length = 50)

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "mdate", length = 10)

	public Date getMdate() {
		return this.mdate;
	}

	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}

}