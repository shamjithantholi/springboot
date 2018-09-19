package com.shamjith.bank.Bank.repository;

import java.util.List;
import java.util.Map;

import com.shamjith.bank.Bank.DO.Employee;

public interface EmployeeRepository {

	public void addNewEmployee(List<Employee> employees) throws Exception;
	public void removeEmployee(int employeeId) throws Exception;
	public List<Map<String,Object>> getAllEmployees() throws Exception;
	public List<Map<String, Object>> getEmployeeById(int id) throws Exception;	
	
}
