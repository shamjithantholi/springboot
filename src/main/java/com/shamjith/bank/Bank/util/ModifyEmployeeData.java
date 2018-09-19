package com.shamjith.bank.Bank.util;

public class ModifyEmployeeData {

	public Integer modifyEmpData(Integer empId)
	{
		System.out.println("In base int >>>>>>>>>> ");
		return empId+100;
	}
	
	public String modifyEmpData(String empName)
	{
		System.out.println("In base string >>>>>>>>>> ");
		return empName+" Test";
	}
}
