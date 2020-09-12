package com.sum.hr.server.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.ForeignKey;

@XmlRootElement(name="department")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="DEPARTMENTS")
public class Department implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8579602405097069010L;

	@XmlElement(name="id")
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="department_seq")
	@SequenceGenerator(
		name="department_seq",
		sequenceName="DEPARTMENT_SQ",
		allocationSize=20
	)
	@Column(name = "DEPARTMENT_ID")
	private int id;
	
	@Column(name="DEPARTMENT_NAME")
	private String deptName;
	
	@Column(name="MANAGER_ID")
	private Long managerid;
	
	@ManyToOne
	@JoinColumn(name="LOCATION_ID")
	@ForeignKey(name="DEPT_LOC_FK")
	private Location locationId;
	public Department(){
	}
	public Department(int id, String deptName, Long managerid,
			Location locationId) {
		super();
		this.id = id;
		this.deptName = deptName;
		this.managerid = managerid;
		this.locationId = locationId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Long getManagerid() {
		return managerid;
	}
	public void setManagerid(Long managerid) {
		this.managerid = managerid;
	}
	public Location getLocationId() {
		return locationId;
	}
	public void setLocationId(Location locationId) {
		this.locationId = locationId;
	}
	
}
