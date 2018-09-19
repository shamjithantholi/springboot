package com.shamjith.bank.Bank;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.shamjith.bank.Bank.DO.Employee;
import com.shamjith.bank.Bank.repository.EmployeeRepository;
import com.shamjith.bank.Bank.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

	@Autowired
	EmployeeService employeeService;
	
	@MockBean
	private EmployeeRepository employeeRepository;
	
	 
	@Test
	public void test() throws Exception{
		List<Map<String,Object>> lstAll = getAllEmployeeObjectFromDb();
		when(employeeRepository.getAllEmployees()).thenReturn(lstAll);
		List<Employee> lstEmp = employeeService.convertEmployeeMapToList(lstAll);
		assertEquals(lstEmp.get(0).getEmpId(),10);
		
	}

	
	public List<Map<String,Object>> getAllEmployeeObjectFromDb(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("empname", "Mark");
		map.put("empid", 10);
		map.put("salary", 100);
		map.put("department", "E2");
		List<Map<String,Object>> lst = new ArrayList<Map<String,Object>>();
		lst.add(map);
		return lst;
		
	}
	
	
	
	
	
}
