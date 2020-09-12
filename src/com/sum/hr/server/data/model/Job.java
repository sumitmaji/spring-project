package com.sum.hr.server.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="job")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="JOBS")
public class Job implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6498512268326730668L;
	
	@XmlElement(name="id")
	@Id
	@Column(name = "JOB_ID")
	private String id;

	@Column(name="JOB_TITLE")
	private String jobTitle;
	
	@Column(name="MIN_SALARY")
	private int minSalary;
	
	@Column(name="MAX_SALARY")
	private int maxSalary;
	
	public Job(){
	}
	
	public Job(String jobTitle, int minSalary, int maxSalary){
		this.jobTitle = jobTitle;
		this.maxSalary = maxSalary;
		this.minSalary = minSalary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public int getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}

	public int getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}
	
	
}
