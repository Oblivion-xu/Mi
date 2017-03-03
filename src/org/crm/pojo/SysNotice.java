package org.crm.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SysNotice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_notice", catalog = "crm")

public class SysNotice implements java.io.Serializable {

	// Fields

	private Integer noticeId;
	private String noticeTitle;
	private String noticeContent;
	private Date ndate;

	// Constructors

	/** default constructor */
	public SysNotice() {
	}

	/** full constructor */
	public SysNotice(String noticeTitle, String noticeContent, Date ndate) {
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.ndate = ndate;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "notice_id", unique = true, nullable = false)

	public Integer getNoticeId() {
		return this.noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	@Column(name = "notice_title", nullable = false, length = 100)

	public String getNoticeTitle() {
		return this.noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	@Column(name = "notice_content", nullable = false, length = 4000)

	public String getNoticeContent() {
		return this.noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ndate", nullable = false, length = 10)

	public Date getNdate() {
		return this.ndate;
	}

	public void setNdate(Date ndate) {
		this.ndate = ndate;
	}

}