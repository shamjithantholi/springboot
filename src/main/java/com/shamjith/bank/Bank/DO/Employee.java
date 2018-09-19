package com.shamjith.bank.Bank.DO;

public class Employee {
	
	private int empId;
	private String empName;
	private int salary;
	private String department;
	
	public Employee(int empId, String empName, int salary, String department)
	{
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.department = department;
		
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) return false;
	    if (!(obj instanceof Employee))
	        return false;
	    if (obj == this)
	        return true;
	    return (this.getEmpId() == ((Employee) obj).getEmpId() && this.getEmpName() == ((Employee) obj).getEmpName() && this.getSalary() == ((Employee) obj).getSalary()
	    		&& this.getDepartment() == ((Employee) obj).getDepartment());
	}
	
	@Override
	public int hashCode() {
	    return empId+empName.hashCode()+salary+department.hashCode();
	}
	

}
