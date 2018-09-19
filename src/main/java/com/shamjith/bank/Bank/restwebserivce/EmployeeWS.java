package com.shamjith.bank.Bank.restwebserivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shamjith.bank.Bank.DO.Employee;
import com.shamjith.bank.Bank.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeWS {
	
	@Autowired
	EmployeeService employeeService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/getallemployees/", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = null;
		try{
			employees = employeeService.getAllEmployees();
			
			if (employees.isEmpty()) {
	            return new ResponseEntity(HttpStatus.NO_CONTENT);
	        }
			
		}catch(Exception e){
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
        
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }

}
