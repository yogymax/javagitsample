package com.api.exp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.exp.dao.EmpDao;
import com.api.exp.entities.EmpEn;

@Repository
public class EmpDaoImpl implements EmpDao {

	static {
		System.out.println("inside daoimpl..");
	}
	
	@Autowired
	private SessionFactory sfactory;

	public int addEmpEn(EmpEn emp) {
		Session session = null;
		Transaction tr = null;
		try {
			session = sfactory.openSession();
			tr = session.beginTransaction();
			Integer eid = (Integer) session.save(emp);
			return eid;
		} catch (Exception e) {
			System.out.println("Problem in save..!");
			return 0;
		} finally {
			closeResources(session, tr);
		}

	}

	private void closeResources(Session session, Transaction tr) {
		if(session!=null) {
			session.flush();
			if(tr!=null) {
					tr.commit();
				}
			session.close();
		}
		
	}

	public EmpEn getEmpEn(int empId) {
		Session session = null;
		Transaction tr = null;
		try {
			session = sfactory.openSession();
			tr = session.beginTransaction();
			return session.get(EmpEn.class, empId);
		} catch (Exception e) {
			System.out.println("Problem in get..!");
			return null;
		} finally {
			closeResources(session, tr);
		}

	}

	public List<EmpEn> getAllEmpEns() {
		Session session = null;
		Transaction tr = null;
		try {
			session = sfactory.openSession();
			tr = session.beginTransaction();
			return session.createCriteria(EmpEn.class).list();
		} catch (Exception e) {
			System.out.println("Problem in getall..!");
			return null;
		} finally {
			closeResources(session, tr);
		}

	}

	public String deleteEmpEn(EmpEn en) {
		Session session = null;
		Transaction tr = null;
		try {
			session = sfactory.openSession();
			tr = session.beginTransaction();
			session.delete(en);
			return "Emp record Removed";
		} catch (Exception e) {
			System.out.println("Problem in save..!");
			return "Problem in remove";
		} finally {
			closeResources(session, tr);
		}

	}

	public EmpEn updateEmpEn(EmpEn emp) {
		Session session = null;
		Transaction tr = null;
		try {
			session = sfactory.openSession();
			tr = session.beginTransaction();
			session.update(emp);
			return getEmpEn(emp.getEmpId());
		} catch (Exception e) {
			System.out.println("Problem in update..!");
			return null;
		} finally {
			closeResources(session, tr);
		}
	}
	
	
	
	
}
