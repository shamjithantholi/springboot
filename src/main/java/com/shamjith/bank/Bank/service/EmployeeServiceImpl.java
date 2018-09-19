package com.shamjith.bank.Bank.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shamjith.bank.Bank.DO.Employee;
import com.shamjith.bank.Bank.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public void addNewEmployee(List <Employee>employeeList) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("IN add new employee.....");
		employeeRepository.addNewEmployee(employeeList);
	}

	@Override
	public void removeEmployee(int employeeId) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("IN remove employee.....");
		employeeRepository.removeEmployee(employeeId);
	}

	@Override
	public List<Employee> getAllEmployees() throws Exception{
		// TODO Auto-generated method stub
		List<Map<String,Object>> employees = employeeRepository.getAllEmployees();
		List<Employee> empList = convertEmployeeMapToList(employees);
		System.out.println("IN all employees....."+empList.size());
		return empList;
	}

	@Override
	public List<Employee> getEmployeeById(int id) throws Exception{
		// TODO Auto-generated method stub
		List<Employee> empList = convertEmployeeMapToList(employeeRepository.getEmployeeById(id));
		System.out.println("IN get employee by id....."+empList.size());
		return empList;
	}
	
	
	
	

}
