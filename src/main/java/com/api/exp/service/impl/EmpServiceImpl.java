package com.api.exp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.exp.beans.Emp;
import com.api.exp.dao.EmpDao;
import com.api.exp.entities.EmpEn;
import com.api.exp.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpDao empDaoImpl;

	public int addEmp(Emp emp) {
		return empDaoImpl.addEmpEn(beanToEntity(emp));
	}

	private EmpEn beanToEntity(Emp bean) {
		EmpEn entity = new EmpEn();
		entity.setEmpAge(bean.getEmpAge());
		entity.setEmpDes(bean.getEmpDes());
		entity.setEmpId(bean.getEmpId());
		entity.setEmpName(bean.getEmpName());
		entity.setEmpSalary(bean.getEmpSalary());
		return entity;
	}

	public Emp getEmp(int empId) {
		return entityToBean(empDaoImpl.getEmpEn(empId));
	}

	private Emp entityToBean(EmpEn empEn) {
		Emp bean = new Emp();
		bean.setEmpAge(empEn.getEmpAge());
		bean.setEmpDes(empEn.getEmpDes());
		bean.setEmpId(empEn.getEmpId());
		bean.setEmpName(empEn.getEmpName());
		bean.setEmpSalary(empEn.getEmpSalary());
		return bean;
	}

	public List<Emp> getAllEmps() {
		return entitiesToBeans(empDaoImpl.getAllEmpEns());
	}

	private List<Emp> entitiesToBeans(List<EmpEn> allEmpEns) {
		List<Emp> emps = new ArrayList<Emp>();
		for (EmpEn entity : allEmpEns) {
			emps.add(entityToBean(entity));
		}
		return emps;
	}

	public String deleteEmp(int empId) {
		EmpEn en = empDaoImpl.getEmpEn(empId);
		if(en!=null)
				return empDaoImpl.deleteEmpEn(en);
		return "No record for delete";
	}

	public Emp updateEmp(Emp emp) {
		return entityToBean(empDaoImpl.updateEmpEn(beanToEntity(emp)));
	}
	
	
	
	
	
}
