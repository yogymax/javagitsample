package com.api.exp.service;

import java.util.List;

import com.api.exp.beans.Emp;

public interface EmpService {
	public int addEmp(Emp emp);
	public Emp getEmp(int empId);
	public List<Emp> getAllEmps();
	public String deleteEmp(int empId);
	public Emp updateEmp(Emp emp);
}
