package com.api.exp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp_info")
public class EmpEn {

	@Id
	private int empId;
	private String empName;
	private double empSalary;
	private int empAge;
	private String empDes;
	public EmpEn() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpEn(int empId, String empName, double empSalary, int empAge, String empDes) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empAge = empAge;
		this.empDes = empDes;
	}
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", empAge=" + empAge
				+ ", empDes=" + empDes + "]";
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public String getEmpDes() {
		return empDes;
	}
	public void setEmpDes(String empDes) {
		this.empDes = empDes;
	}
	
	
	



}
