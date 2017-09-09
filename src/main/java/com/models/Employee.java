package com.models;

import java.util.Date;

public class Employee{


	private int number;
	private int deptNumber;
	private Date DoJ;
	private Date DoB;
	private int salary;
	private int salGrade;

	public Employee() {

	}

	public Employee(int number, int deptNumber, Date doJ, Date doB, int salary, int salGrade) {
		super();
		this.number = number;
		this.deptNumber = deptNumber;
		DoJ = doJ;
		DoB = doB;
		this.salary = salary;
		this.salGrade = salGrade;
	}

	public Employee(int deptNumber, Date doJ, Date doB, int salary, int salGrade) {
		super();
		this.deptNumber = deptNumber;
		DoJ = doJ;
		DoB = doB;
		this.salary = salary;
		this.salGrade = salGrade;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getDeptNumber() {
		return deptNumber;
	}

	public void setDeptNumber(int deptNumber) {
		this.deptNumber = deptNumber;
	}

	public Date getDoJ() {
		return DoJ;
	}

	public void setDoJ(Date doJ) {
		DoJ = doJ;
	}

	public Date getDoB() {
		return DoB;
	}

	public void setDoB(Date doB) {
		DoB = doB;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getSalGrade() {
		return salGrade;
	}

	public void setSalGrade(int salGrade) {
		this.salGrade = salGrade;
	}

	@Override
	public String toString() {
		return "Employee [number=" + number + ", deptNumber=" + deptNumber + ", DoJ=" + DoJ + ", DoB=" + DoB
				+ ", salary=" + salary + ", salGrade=" + salGrade + "]";
	}

}
