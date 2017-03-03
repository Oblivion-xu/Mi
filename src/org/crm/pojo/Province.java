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
 * Province entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "province", catalog = "crm")

public class Province implements java.io.Serializable {

	// Fields

	private Integer pid;
	private String pname;
	private Set<City> cities = new HashSet<City>(0);
	private Set<Customer> customers = new HashSet<Customer>(0);

	// Constructors

	/** default constructor */
	public Province() {
	}

	/** minimal constructor */
	public Province(String pname) {
		this.pname = pname;
	}

	/** full constructor */
	public Province(String pname, Set<City> cities, Set<Customer> customers) {
		this.pname = pname;
		this.cities = cities;
		this.customers = customers;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "pid", unique = true, nullable = false)

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Column(name = "pname", nullable = false, length = 20)

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "province")

	public Set<City> getCities() {
		return this.cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "province")

	public Set<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

}