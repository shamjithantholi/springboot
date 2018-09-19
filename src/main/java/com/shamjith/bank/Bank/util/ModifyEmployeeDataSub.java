package com.shamjith.bank.Bank.util;

public class ModifyEmployeeDataSub extends ModifyEmployeeData {

	public Integer modifyEmpData(Integer empId, Integer salary)
	{
		System.out.println("In sub int >>>>>>>>>> ");
		return empId+salary+1000;
	}
	
	public String modifyEmpData(String empName, String department)
	{
		System.out.println("In sub string >>>>>>>>>> ");
		return empName + " > "+department+" > Test1";
	}
	
}
