package com.shamjith.bank.Bank.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.shamjith.bank.Bank.DO.Employee;


public interface EmployeeService {

	public void addNewEmployee(List <Employee>employeeList) throws Exception;
	public void removeEmployee(int employeeId) throws Exception;
	public List<Employee> getAllEmployees() throws Exception;
	public List<Employee> getEmployeeById(int id) throws Exception;
	default List<Employee> convertEmployeeMapToList(List<Map<String, Object>> employees)throws Exception{
		System.out.println(" in default method >>>>>>>>>>>>>>>>> ");
		Set<Employee> empSet = new HashSet<Employee>();
		for(int empCnt = 0; empCnt < employees.size(); empCnt++)
		{
			empSet.add(new Employee(
					Integer.parseInt(String.valueOf(employees.get(empCnt).get("empid"))), 
					String.valueOf(employees.get(empCnt).get("empname")),
					Integer.parseInt(String.valueOf(employees.get(empCnt).get("salary"))),
					String.valueOf(employees.get(empCnt).get("department"))));
		}
		
		empSet.stream().sorted(Comparator.comparing(Employee::getEmpId))
		  .forEach(e -> empSet.add(e));
		
		List<Employee> empList = new ArrayList<Employee>(empSet);
		
		return empList;
		
	}
}
