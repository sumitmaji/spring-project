package com.sum.hr.server.data.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.ForeignKey;
@XmlRootElement(name="location")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="LOCATIONS")
public class Location implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8555680321042947826L;

	@XmlElement(name="id")
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="location_seq")
	@SequenceGenerator(
		name="location_seq",
		sequenceName="LOCATION_SQ",
		allocationSize=20
	)
	@Column(name = "LOCATION_ID")
	private int id;
	
	@Column(name="STREET_ADDRESS")
	private String streetAddress;
	
	@Column(name = "POSTAL_CODE")
	private String postalCode;
	
	@Column(name ="CITY")
	private String city;
	
	@Column(name="STATE_PROVINCE")
	private String stateProvince;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@ForeignKey(name="LOC_C_ID_FK")
	@JoinColumn(name="COUNTRY_ID")
	private Country country;

	public Location(){
	}
	public Location(int id, String streetAddress, String postalCode,
			String city, String stateProvince, Country country) {
		super();
		this.id = id;
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.city = city;
		this.stateProvince = stateProvince;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
}
