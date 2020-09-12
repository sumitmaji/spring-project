package com.sum.hr.server.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="region")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "REGIONS")
public class Region implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3334329440373670504L;
	@Column(name = "REGION_NAME")
	private String regionName;
	@XmlElement(name="id")
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="region_seq")
	@SequenceGenerator(
		name="region_seq",
		sequenceName="REGION_SQ",
		allocationSize=20
	)
	@Column(name = "REGION_ID")
	private int id;

	public Region() {
	}

	public Region(String regionName) {
		this.regionName = regionName;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Region other = (Region) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
