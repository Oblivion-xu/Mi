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
 * LostMeasure entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "lost_measure", catalog = "crm")

public class LostMeasure implements java.io.Serializable {

	// Fields

	private Integer mid;
	private CstLost cstLost;
	private String mcontent;
	private Timestamp mdate;
	private String mresult;

	// Constructors

	/** default constructor */
	public LostMeasure() {
	}

	/** minimal constructor */
	public LostMeasure(CstLost cstLost, String mcontent) {
		this.cstLost = cstLost;
		this.mcontent = mcontent;
	}

	/** full constructor */
	public LostMeasure(CstLost cstLost, String mcontent, Timestamp mdate, String mresult) {
		this.cstLost = cstLost;
		this.mcontent = mcontent;
		this.mdate = mdate;
		this.mresult = mresult;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "mid", unique = true, nullable = false)

	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lst_id", nullable = false)

	public CstLost getCstLost() {
		return this.cstLost;
	}

	public void setCstLost(CstLost cstLost) {
		this.cstLost = cstLost;
	}

	@Column(name = "mcontent", nullable = false, length = 1000)

	public String getMcontent() {
		return this.mcontent;
	}

	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}

	@Column(name = "mdate", length = 19)

	public Timestamp getMdate() {
		return this.mdate;
	}

	public void setMdate(Timestamp mdate) {
		this.mdate = mdate;
	}

	@Column(name = "mresult", length = 1000)

	public String getMresult() {
		return this.mresult;
	}

	public void setMresult(String mresult) {
		this.mresult = mresult;
	}

}