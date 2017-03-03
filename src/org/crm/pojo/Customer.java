package org.crm.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Customer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "customer", catalog = "crm")

public class Customer implements java.io.Serializable {

	// Fields

	private Integer custNo;
	private SysUser sysUser;
	private City city;
	private Province province;
	private String custName;
	private String custSource;
	private String custType;
	private String custIndustry;
	private Integer custLevel;
	private String custLevelLabel;
	private Integer custSatisfy;
	private Integer custCredit;
	private String custAddress;
	private String custZip;
	private String custTel;
	private String custFax;
	private String custWebsite;
	private String custLicenceNo;
	private String custChieftain;
	private Integer custBankroll;
	private Integer custTurnover;
	private String custBank;
	private String custBankCard;
	private String custLocalTaxNo;
	private String custNationalTaxNo;
	private String custState;
	private Date custDate;
	private Set<CstLinkman> cstLinkmans = new HashSet<CstLinkman>(0);
	private Set<CstActity> cstActities = new HashSet<CstActity>(0);
	private Set<CstService> cstServices = new HashSet<CstService>(0);
	private Set<CstLost> cstLosts = new HashSet<CstLost>(0);
	private Set<Orders> orderses = new HashSet<Orders>(0);

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** minimal constructor */
	public Customer(SysUser sysUser, Province province, String custName, Integer custLevel, String custLevelLabel,
			Integer custSatisfy, Integer custCredit, String custAddress, String custZip, String custTel, String custFax,
			String custWebsite, String custChieftain, String custBank, String custBankCard, String custState) {
		this.sysUser = sysUser;
		this.province = province;
		this.custName = custName;
		this.custLevel = custLevel;
		this.custLevelLabel = custLevelLabel;
		this.custSatisfy = custSatisfy;
		this.custCredit = custCredit;
		this.custAddress = custAddress;
		this.custZip = custZip;
		this.custTel = custTel;
		this.custFax = custFax;
		this.custWebsite = custWebsite;
		this.custChieftain = custChieftain;
		this.custBank = custBank;
		this.custBankCard = custBankCard;
		this.custState = custState;
	}

	/** full constructor */
	public Customer(SysUser sysUser, City city, Province province, String custName, String custSource, String custType,
			String custIndustry, Integer custLevel, String custLevelLabel, Integer custSatisfy, Integer custCredit,
			String custAddress, String custZip, String custTel, String custFax, String custWebsite,
			String custLicenceNo, String custChieftain, Integer custBankroll, Integer custTurnover, String custBank,
			String custBankCard, String custLocalTaxNo, String custNationalTaxNo, String custState, Date custDate,
			Set<CstLinkman> cstLinkmans, Set<CstActity> cstActities, Set<CstService> cstServices, Set<CstLost> cstLosts,
			Set<Orders> orderses) {
		this.sysUser = sysUser;
		this.city = city;
		this.province = province;
		this.custName = custName;
		this.custSource = custSource;
		this.custType = custType;
		this.custIndustry = custIndustry;
		this.custLevel = custLevel;
		this.custLevelLabel = custLevelLabel;
		this.custSatisfy = custSatisfy;
		this.custCredit = custCredit;
		this.custAddress = custAddress;
		this.custZip = custZip;
		this.custTel = custTel;
		this.custFax = custFax;
		this.custWebsite = custWebsite;
		this.custLicenceNo = custLicenceNo;
		this.custChieftain = custChieftain;
		this.custBankroll = custBankroll;
		this.custTurnover = custTurnover;
		this.custBank = custBank;
		this.custBankCard = custBankCard;
		this.custLocalTaxNo = custLocalTaxNo;
		this.custNationalTaxNo = custNationalTaxNo;
		this.custState = custState;
		this.custDate = custDate;
		this.cstLinkmans = cstLinkmans;
		this.cstActities = cstActities;
		this.cstServices = cstServices;
		this.cstLosts = cstLosts;
		this.orderses = orderses;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "cust_no", unique = true, nullable = false)

	public Integer getCustNo() {
		return this.custNo;
	}

	public void setCustNo(Integer custNo) {
		this.custNo = custNo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cust_manager_id", nullable = false)

	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cust_region")

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cust_province", nullable = false)

	public Province getProvince() {
		return this.province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	@Column(name = "cust_name", nullable = false, length = 100)

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	@Column(name = "cust_source", length = 20)

	public String getCustSource() {
		return this.custSource;
	}

	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}

	@Column(name = "cust_type", length = 20)

	public String getCustType() {
		return this.custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	@Column(name = "cust_industry", length = 20)

	public String getCustIndustry() {
		return this.custIndustry;
	}

	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}

	@Column(name = "cust_level", nullable = false)

	public Integer getCustLevel() {
		return this.custLevel;
	}

	public void setCustLevel(Integer custLevel) {
		this.custLevel = custLevel;
	}

	@Column(name = "cust_level_label", nullable = false, length = 50)

	public String getCustLevelLabel() {
		return this.custLevelLabel;
	}

	public void setCustLevelLabel(String custLevelLabel) {
		this.custLevelLabel = custLevelLabel;
	}

	@Column(name = "cust_satisfy", nullable = false)

	public Integer getCustSatisfy() {
		return this.custSatisfy;
	}

	public void setCustSatisfy(Integer custSatisfy) {
		this.custSatisfy = custSatisfy;
	}

	@Column(name = "cust_credit", nullable = false)

	public Integer getCustCredit() {
		return this.custCredit;
	}

	public void setCustCredit(Integer custCredit) {
		this.custCredit = custCredit;
	}

	@Column(name = "cust_address", nullable = false, length = 200)

	public String getCustAddress() {
		return this.custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	@Column(name = "cust_zip", nullable = false, length = 10)

	public String getCustZip() {
		return this.custZip;
	}

	public void setCustZip(String custZip) {
		this.custZip = custZip;
	}

	@Column(name = "cust_tel", nullable = false, length = 50)

	public String getCustTel() {
		return this.custTel;
	}

	public void setCustTel(String custTel) {
		this.custTel = custTel;
	}

	@Column(name = "cust_fax", nullable = false, length = 50)

	public String getCustFax() {
		return this.custFax;
	}

	public void setCustFax(String custFax) {
		this.custFax = custFax;
	}

	@Column(name = "cust_website", nullable = false, length = 100)

	public String getCustWebsite() {
		return this.custWebsite;
	}

	public void setCustWebsite(String custWebsite) {
		this.custWebsite = custWebsite;
	}

	@Column(name = "cust_licence_no", length = 50)

	public String getCustLicenceNo() {
		return this.custLicenceNo;
	}

	public void setCustLicenceNo(String custLicenceNo) {
		this.custLicenceNo = custLicenceNo;
	}

	@Column(name = "cust_chieftain", nullable = false, length = 20)

	public String getCustChieftain() {
		return this.custChieftain;
	}

	public void setCustChieftain(String custChieftain) {
		this.custChieftain = custChieftain;
	}

	@Column(name = "cust_bankroll")

	public Integer getCustBankroll() {
		return this.custBankroll;
	}

	public void setCustBankroll(Integer custBankroll) {
		this.custBankroll = custBankroll;
	}

	@Column(name = "cust_turnover")

	public Integer getCustTurnover() {
		return this.custTurnover;
	}

	public void setCustTurnover(Integer custTurnover) {
		this.custTurnover = custTurnover;
	}

	@Column(name = "cust_bank", nullable = false, length = 200)

	public String getCustBank() {
		return this.custBank;
	}

	public void setCustBank(String custBank) {
		this.custBank = custBank;
	}

	@Column(name = "cust_bank_card", nullable = false, length = 50)

	public String getCustBankCard() {
		return this.custBankCard;
	}

	public void setCustBankCard(String custBankCard) {
		this.custBankCard = custBankCard;
	}

	@Column(name = "cust_local_tax_no", length = 50)

	public String getCustLocalTaxNo() {
		return this.custLocalTaxNo;
	}

	public void setCustLocalTaxNo(String custLocalTaxNo) {
		this.custLocalTaxNo = custLocalTaxNo;
	}

	@Column(name = "cust_national_tax_no", length = 50)

	public String getCustNationalTaxNo() {
		return this.custNationalTaxNo;
	}

	public void setCustNationalTaxNo(String custNationalTaxNo) {
		this.custNationalTaxNo = custNationalTaxNo;
	}

	@Column(name = "cust_state", nullable = false, length = 10)

	public String getCustState() {
		return this.custState;
	}

	public void setCustState(String custState) {
		this.custState = custState;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "cust_date", length = 10)

	public Date getCustDate() {
		return this.custDate;
	}

	public void setCustDate(Date custDate) {
		this.custDate = custDate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")

	public Set<CstLinkman> getCstLinkmans() {
		return this.cstLinkmans;
	}

	public void setCstLinkmans(Set<CstLinkman> cstLinkmans) {
		this.cstLinkmans = cstLinkmans;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")

	public Set<CstActity> getCstActities() {
		return this.cstActities;
	}

	public void setCstActities(Set<CstActity> cstActities) {
		this.cstActities = cstActities;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")

	public Set<CstService> getCstServices() {
		return this.cstServices;
	}

	public void setCstServices(Set<CstService> cstServices) {
		this.cstServices = cstServices;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")

	public Set<CstLost> getCstLosts() {
		return this.cstLosts;
	}

	public void setCstLosts(Set<CstLost> cstLosts) {
		this.cstLosts = cstLosts;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")

	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

}