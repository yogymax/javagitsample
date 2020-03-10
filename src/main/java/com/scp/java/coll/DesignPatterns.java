package com.scp.java.coll;

import java.util.Arrays;
import java.util.HashMap;

public class DesignPatterns {
	
		public static void main(String[] args) {
			String facilities []= {"TA","DA","HRA"};
			
			HashMap<AllAttributes,Object> hmap = new HashMap<AllAttributes, Object>();
			hmap.put(AllAttributes.id, 101);
			hmap.put(AllAttributes.age, -10);
			hmap.put(AllAttributes.age, 24);
			hmap.put(AllAttributes.adr, "Pune");
			hmap.put(AllAttributes.fees, 293.31);
			hmap.put(AllAttributes.des, "SE");
			hmap.put(AllAttributes.fac, facilities);
			hmap.put(AllAttributes.name, "AAAA");
			
			StudentFactory factory =new StudentFactory();
			Person person = PersonFactory.getPersonInstance(factory, hmap);
			
			System.out.println((person instanceof Person)+"Person");
			System.out.println((person instanceof Student)+"Student");
			System.out.println((person instanceof Employee)+"EMp");
			System.out.println((person instanceof Officer)+"Officer");
			
			
			System.out.println("----------------------");
			if (person instanceof Student) {
				System.out.println((Student)person);
			}else if (person instanceof Employee) {
				System.out.println((Employee)person);
			}else if (person instanceof Officer) {
				System.out.println((Officer)person);
			}
			
		
		}

}

//Factory pattern --> create n instance

abstract class Person{
		public int personId;
		public String personName;
		public int personAge;
		public String personAddress;
		public Person(int personId, String personName, int personAge, String personAddress) {
			super();
			this.personId = personId;
			this.personName = personName;
			this.personAge = personAge;
			this.personAddress = personAddress;
		}
		@Override
		public String toString() {
			return "Person [personId=" + personId + ", personName=" + personName + ", personAge=" + personAge
					+ ", personAddress=" + personAddress + "]";
		}
		public int getPersonId() {
			return personId;
		}
		public void setPersonId(int personId) {
			this.personId = personId;
		}
		public String getPersonName() {
			return personName;
		}
		public void setPersonName(String personName) {
			this.personName = personName;
		}
		public int getPersonAge() {
			return personAge;
		}
		public void setPersonAge(int personAge) {
			this.personAge = personAge;
		}
		public String getPersonAddress() {
			return personAddress;
		}
		public void setPersonAddress(String personAddress) {
			this.personAddress = personAddress;
		}
	
		
		
		
		
		
}

class Student extends Person{
	private double studFees;
	public Student(int personId, String personName, int personAge, String personAddress,double fees) {
		super(personId, personName, personAge, personAddress);
		this.studFees=fees;
	}
	@Override
	public String toString() {
		return "Student "+super.toString()+",studFees=" + studFees + "]";
	}
	public double getStudFees() {
		return studFees;
	}
	public void setStudFees(double studFees) {
		this.studFees = studFees;
	}
	
	

	
	
}


class Employee extends Person{
	private double empSalary;
	private String empDesi;
	public Employee(int personId, String personName, int personAge, String personAddress, double empSalary,
			String empDesi) {
		super(personId, personName, personAge, personAddress);
		this.empSalary = empSalary;
		this.empDesi = empDesi;
	}
	@Override
	public String toString() {
		return "Employee"+super.toString()+", [empSalary=" + empSalary + ", empDesi=" + empDesi + "]";
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public String getEmpDesi() {
		return empDesi;
	}
	public void setEmpDesi(String empDesi) {
		this.empDesi = empDesi;
	}
	
	
	
}


class Officer extends Person{
	private String[] govtFacilities;

	public Officer(int personId, String personName, int personAge, String personAddress, String[] govtFacilities) {
		super(personId, personName, personAge, personAddress);
		this.govtFacilities = govtFacilities;
	}

	@Override
	public String toString() {
		return "Officer "+super.toString()+",[govtFacilities=" + Arrays.toString(govtFacilities) + "]";
	}

	public String[] getGovtFacilities() {
		return govtFacilities;
	}

	public void setGovtFacilities(String[] govtFacilities) {
		this.govtFacilities = govtFacilities;
	}
	
	
}

enum WhatTypes{
	emp,
	stud,
	ofcr;
}

enum AllAttributes{
		id,
		name,
		age,
		adr,
		fees,
		sal,
		des,
		fac,
}



abstract class MainFactory{
	abstract public Person getPerson(int perId,String perNam,int perAge,String peradr,HashMap<AllAttributes,Object> values);
}

class OfficerFactory extends MainFactory{

	@Override
	public Person getPerson(int perId, String perNam, int perAge, String peradr,
			HashMap<AllAttributes, Object> values) {
		if(values.containsKey(AllAttributes.fac)) {
			String []govtFacilities = (String[]) values.get(AllAttributes.fac);
			return new Officer(perId, perNam, perAge, peradr, govtFacilities);
		}else {
			System.out.println("Officer Object cannot be created..no facitites provided..");
		}
		return null;
	}
	
}

class StudentFactory extends MainFactory{

	@Override
	public Person getPerson(int perId, String perNam, int perAge, String peradr,
			HashMap<AllAttributes, Object> values) {
		
		if(values.containsKey(AllAttributes.fees)) {
			double fees = (Double) values.get(AllAttributes.fees);
			return new Student(perId, perNam, perAge, peradr, fees);
		}else {
			System.out.println("Student Object cannot be created..as no fees provided..");
		}
		
	
		
		return null;
	}
	
}

class EmpFactory extends MainFactory{

	@Override
	public Person getPerson(int perId, String perNam, int perAge, String peradr,
			HashMap<AllAttributes, Object> values) {

		if(values.containsKey(AllAttributes.des) && values.containsKey(AllAttributes.sal)) {
			double sal = (Double) values.get(AllAttributes.sal);
			String desi = (String) values.get(AllAttributes.des);
			return new Employee(perId, perNam, perAge, peradr, sal, desi);	
		}else {
			System.out.println("Emp Instance Cannot be created as either des/sal not given..");
		}

		return null;
	}
	
}


class PersonFactory{
	public static Person getPersonInstance(MainFactory factory,HashMap<AllAttributes,Object> values) {
		int perId = 0;
		String pername = null;
		String perAdr=null;
		int perAge = 0;
		if(values.containsKey(AllAttributes.id) && 
				values.containsKey(AllAttributes.name) && 
				values.containsKey(AllAttributes.age) &&
				values.containsKey(AllAttributes.adr)){

			perId = (Integer) values.get(AllAttributes.id);
			 perAge= (Integer) values.get(AllAttributes.age);
			 pername = (String) values.get(AllAttributes.name);
			perAdr = (String) values.get(AllAttributes.adr);
			if(factory!=null)
				return factory.getPerson(perId, pername, perAge, perAdr, values);
			else {
				return null;
			}
		}else {
			System.out.println("Person cannot be created as no values for mandatory Properties..");
			return null;
		}
	}
	
}


