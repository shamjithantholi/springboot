package com.shamjith.bank.Bank.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shamjith.bank.Bank.DO.Employee;

@Repository
@ComponentScan(basePackages = {"com.shamjith.bank"})
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@Override
	public void addNewEmployee(List<Employee> employees) throws Exception {
		// TODO Auto-generated method stub
		//removeAllEmployees();
		insertBatch(employees);

	}

	@Override
	public void removeEmployee(int employeeId) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from Employee where empid=?";
		Object[] params = { employeeId };
	    jdbcTemplate.update(sql, params);
	}

	@Override
	public List<Map<String,Object>> getAllEmployees() throws Exception {
		return jdbcTemplate.queryForList("select * from Employee");
		
	}

	@Override
	public List<Map<String, Object>> getEmployeeById(int id) throws Exception {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForList("select * from Employee where empid=?", id);
	}
	
	

	private void insertBatch(final List<Employee> employees) throws Exception{
		
		  String sql = "INSERT INTO Employee " +
			"(empid,empname, salary, department) VALUES (?,?, ?, ?)";
					
		  jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
					
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Employee employee = employees.get(i);
				ps.setInt(1, employee.getEmpId());
				ps.setString(2, employee.getEmpName());
				ps.setInt(3, employee.getSalary());
				ps.setString(4, employee.getDepartment());
			}
					
			@Override
			public int getBatchSize() {
				return employees.size();
			}
		  });
		}
	
	
}
