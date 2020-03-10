package com.api.exp.dao;

import java.util.List;

import com.api.exp.entities.EmpEn;

public interface EmpDao {

	public int addEmpEn(EmpEn emp);

	public EmpEn getEmpEn(int empId);

	public List<EmpEn> getAllEmpEns();

	public String deleteEmpEn(EmpEn en);

	public EmpEn updateEmpEn(EmpEn emp);
	
}
