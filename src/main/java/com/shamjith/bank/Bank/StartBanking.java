package com.shamjith.bank.Bank;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shamjith.bank.Bank.DO.Employee;
import com.shamjith.bank.Bank.exception.BankExceptionHandler;
import com.shamjith.bank.Bank.service.EmployeeService;
import com.shamjith.bank.Bank.util.ModifyEmployeeDataSub;

@Component
public class StartBanking {

	@Autowired
	EmployeeService employeeService;
	
	public void bankAndEmployees()
	{
		try{
			List <Employee>employeeList = new ArrayList<Employee>();
			Employee employee = new Employee(10003,"Mark", 4500,"E1");
			employeeList.add(employee);
			employee = new Employee(10004,"Mark1", 6500,"E2");
			employeeList.add(employee);
			employee = new Employee(10005,"Mark2", 5600,"E4");
			employeeList.add(employee);
			employee = new Employee(10010,"Sunny", 3600,"E9");
			employeeList.add(employee);
			 
			employeeService.addNewEmployee(employeeList);
			employeeService.removeEmployee(10010);
			List <Employee> employees = employeeService.getAllEmployees();
			
			ModifyEmployeeDataSub modifyEmployeeDataSub = new ModifyEmployeeDataSub();
			
			String empName = modifyEmployeeDataSub.modifyEmpData(employees.get(0).getEmpName());
			System.out.println("empName >>>> "+empName);
			int salary = modifyEmployeeDataSub.modifyEmpData(employees.get(0).getSalary());
			System.out.println("Salary >>>> "+salary);
			
			String empNameDepartment = modifyEmployeeDataSub.modifyEmpData(employees.get(0).getEmpName(),employees.get(0).getDepartment());
			System.out.println("empNameDepartment >>>> "+empNameDepartment);
			int empIdsalary = modifyEmployeeDataSub.modifyEmpData(employees.get(0).getEmpId(),employees.get(0).getSalary());
			System.out.println("empIdsalary >>>> "+empIdsalary);
			
			
			List<Employee> emp = employeeService.getEmployeeById(10002);
			System.out.println("employee >>> "+emp.get(0).getEmpName());
			//throw new Exception("Testing exception >>>>>>> ");	
		}catch(Exception e){
			BankExceptionHandler.BankException(e);
		}
	}
	
}
