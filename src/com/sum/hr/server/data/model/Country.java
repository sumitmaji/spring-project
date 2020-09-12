package com.sum.hr.server.data.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.ForeignKey;

@XmlRootElement(name="country")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="COUNTRIES")
public class Country implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5666700866537603422L;
	
	@XmlElement(name="id")
	@Id
	@Column(name="COUNTRY_ID")
	private String id;
	@Column(name="COUNTRY_NAME")
	private String countryName;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@ForeignKey(name="COUNTR_REG_FK")
	@JoinColumn(name="REGION_ID")
	private Region region;
	public Country(){
	}
	
	public Country(String id, String countryName, Region region){
		this.id = id;
		this.countryName = countryName;
		this.region = region;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
}