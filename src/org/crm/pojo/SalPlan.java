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
 * SalPlan entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sal_plan", catalog = "crm")

public class SalPlan implements java.io.Serializable {

	// Fields

	private Integer plaId;
	private SalChance salChance;
	private Timestamp plaDate;
	private String plaDesc;
	private String plaResult;

	// Constructors

	/** default constructor */
	public SalPlan() {
	}

	/** minimal constructor */
	public SalPlan(SalChance salChance, Timestamp plaDate, String plaDesc) {
		this.salChance = salChance;
		this.plaDate = plaDate;
		this.plaDesc = plaDesc;
	}

	/** full constructor */
	public SalPlan(SalChance salChance, Timestamp plaDate, String plaDesc, String plaResult) {
		this.salChance = salChance;
		this.plaDate = plaDate;
		this.plaDesc = plaDesc;
		this.plaResult = plaResult;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "pla_id", unique = true, nullable = false)

	public Integer getPlaId() {
		return this.plaId;
	}

	public void setPlaId(Integer plaId) {
		this.plaId = plaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pla_chc_id", nullable = false)

	public SalChance getSalChance() {
		return this.salChance;
	}

	public void setSalChance(SalChance salChance) {
		this.salChance = salChance;
	}

	@Column(name = "pla_date", nullable = false, length = 19)

	public Timestamp getPlaDate() {
		return this.plaDate;
	}

	public void setPlaDate(Timestamp plaDate) {
		this.plaDate = plaDate;
	}

	@Column(name = "pla_desc", nullable = false, length = 500)

	public String getPlaDesc() {
		return this.plaDesc;
	}

	public void setPlaDesc(String plaDesc) {
		this.plaDesc = plaDesc;
	}

	@Column(name = "pla_result", length = 500)

	public String getPlaResult() {
		return this.plaResult;
	}

	public void setPlaResult(String plaResult) {
		this.plaResult = plaResult;
	}

}