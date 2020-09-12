package com.sum.hr.server.data.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RowCount implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3269140659466062167L;
	@XmlElement
	int totalCount;
	
	public RowCount(){
	}
	
	public RowCount(int totalCount){
		this.totalCount = totalCount;
	}

	public int gettotalCount() {
		return totalCount;
	}

	public void settotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	
}
