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
 * SysNews entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_news", catalog = "crm")

public class SysNews implements java.io.Serializable {

	// Fields

	private Integer newsId;
	private String newsTitle;
	private String newsContent;
	private Date ndate;

	// Constructors

	/** default constructor */
	public SysNews() {
	}

	/** full constructor */
	public SysNews(String newsTitle, String newsContent, Date ndate) {
		this.newsTitle = newsTitle;
		this.newsContent = newsContent;
		this.ndate = ndate;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "news_id", unique = true, nullable = false)

	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	@Column(name = "news_title", nullable = false, length = 100)

	public String getNewsTitle() {
		return this.newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	@Column(name = "news_content", nullable = false, length = 4000)

	public String getNewsContent() {
		return this.newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
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