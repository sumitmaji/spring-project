package com.sum.hr.server.data.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Null;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.google.gwt.user.cellview.client.DataGrid;
import com.sum.hr.server.adapters.DateAdapter;

@XmlRootElement(name="employee")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="EMPLOYEES")
@org.hibernate.annotations.Entity(dynamicUpdate=true)
public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4497448093312689210L;

	@XmlElement(name="id")
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employee_seq")
	@SequenceGenerator(
		name="employee_seq",
		sequenceName="EMPLOYEE_SQ",
		allocationSize=20
	)
	@Column(name = "EMPLOYEE_ID")
	private int id;
	
	@Column(name="FIRST_NAME")
	@NotBlank(message="First Name can not be balck")
	@Length(max=20, message="First Name can not be more than 20 character")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;
	
	@XmlJavaTypeAdapter(DateAdapter.class)
	@Column(name="HIRE_DATE")
	private Date hireDate;
	
	@Column(name="SALARY")
	private int salary;
	
	@ManyToOne
	@ForeignKey(name="EMP_JOB_FK")
	@JoinColumn(name="JOB_ID")
	private Job job;
	
	@Column(name="COMMISSION_PCT")
	private Float commisionPct;
	
	@Column(name="MANAGER_ID")
	private Long managerId;
	
	@ManyToOne
	@ForeignKey(name="EMP_DEPT_FK")
	@JoinColumn(name="DEPARTMENT_ID")
	private Department deptId;
	public Employee() {
	}

	public Employee(String fname, String lname, Job job, String email, Date hireDate, int salary, Float commisionPct, Long managerId, Department deptid) {
		this.firstName = fname;
		this.lastName = lname;
		this.job = job;
		this.email = email;
		this.hireDate = hireDate;
		this.salary = salary;
		this.commisionPct = commisionPct;
		this.deptId = deptid;
		this.managerId = managerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
	
	public Float getCommisionPct() {
		return commisionPct;
	}

	public void setCommisionPct(Float commisionPct) {
		this.commisionPct = commisionPct;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public Department getDeptId() {
		return deptId;
	}

	public void setDeptId(Department deptId) {
		this.deptId = deptId;
	}


	public static class EmployeeBuilder{
		private String firstName;
		private String lastName;
		private String email;
		private Date hireDate;
		private int salary;
		private Job job;
		private Float commisionPct;
		private Long managerId;
		private Department deptId;
			
		public EmployeeBuilder(String firstName, String lastName){
			this.firstName = firstName;
			this.lastName = lastName;
		}

		

		public EmployeeBuilder FirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		
		public EmployeeBuilder LastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		

		public EmployeeBuilder Email(String email) {
			this.email = email;
			return this;
		}


		public EmployeeBuilder HireDate(Date hireDate) {
			this.hireDate = hireDate;
			return this;
		}


		public EmployeeBuilder Salary(int salary) {
			this.salary = salary;
			return this;
		}


		public EmployeeBuilder Job(Job job) {
			this.job = job;
			return this;
		}
		
		public EmployeeBuilder CommisiontPct(Float commisionPct) {
			this.commisionPct = commisionPct;
			return this;
		}
		
		public EmployeeBuilder ManagerId(Long managerId) {
			this.managerId = managerId;
			return this;
		}
		
		public EmployeeBuilder DeptId(Department deptId) {
			this.deptId = deptId;
			return this;
		}
		
		public Employee createEMployee(){
			return new Employee(firstName, lastName, job, email, hireDate, salary, commisionPct, managerId, deptId);
		}
		
		
	}

	/**
	 * @wbp.factory
	 */
	public static DataGrid createDataGrid() {
		DataGrid dataGrid = new DataGrid<Object>();
		dataGrid.setSize("412px", "200px");
		return dataGrid;
	}
	/**
	 * @wbp.factory
	 */
	public static DataGrid generateEmployee() {
		DataGrid dataGrid = new DataGrid<Object>();
		dataGrid.setSize("412px", "200px");
		return dataGrid;
	}
}