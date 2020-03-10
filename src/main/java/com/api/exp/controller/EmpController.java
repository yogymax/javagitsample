package com.api.exp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.exp.beans.Emp;
import com.api.exp.service.EmpService;
import com.api.exp.service.impl.EmpServiceImpl;

@RestController // = controller+responsebody
@RequestMapping("/employees")
public class EmpController {

	//List<Emp> employees = new ArrayList<Emp>();

	@Autowired
	EmpService service;
	
	
	@PostMapping("/")
	public int saveEmp(@RequestBody Emp bean) {
		return service.addEmp(bean);
		//return bean.getEmpId();
	}
	
	@GetMapping("/{eid}")
	public Emp getEmp(@PathVariable("eid") int empId) {
		/*
		 * for (Emp emp : employees) { if(emp.getEmpId() == empId) { return emp; } }
		 */
		return service.getEmp(empId);
	}
	
	@DeleteMapping("/{eid}")
	public String deleteEmp(@PathVariable("eid") int empId) {
		return service.deleteEmp(empId);
		/*
		 * for (Emp emp : employees) { if(emp.getEmpId() == empId) {
		 * employees.remove(emp); return "Emp record removed"; } }
		 * 
		 * return "No emp record with given Identifier,so cannot delete";
		 */
	}
	
	@GetMapping("/")
	public List<Emp> getAllEmps() {
		return service.getAllEmps();
	}
	
	@PutMapping("/{eid}")
	public Emp updateEmp(@PathVariable("eid") int eid, @RequestBody Emp bean) {
		return service.updateEmp(bean);
		
		/*
		 * for (Emp emp : employees) { if(emp.getEmpId() == eid) {
		 * emp.setEmpAge(bean.getEmpAge()); emp.setEmpDes(bean.getEmpDes());
		 * emp.setEmpName(bean.getEmpName()); emp.setEmpSalary(bean.getEmpSalary());
		 * return emp; } } return null;
		 */
	}
}


