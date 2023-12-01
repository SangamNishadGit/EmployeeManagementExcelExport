package com.sangam.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name = "empid")
	private Integer empId;
	
	@Column(name = "empname")
	private String empName;
	
	@Column(name = "empfee")
	private Double empFee;
	
	@Column(name = "empcourse")
	private String empCourse;
	
	@Column(name="empFeedisc")
	private Double empFeeDisc;
	
	@Column(name="empfeegst")
	private Double empFeeGst;

}
