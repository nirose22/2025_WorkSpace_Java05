package com.solution_Employee_JDBC.dao;

public class EmployeeDAOFactory {
	
	public EmployeeDAO createEmployeeDAO() {
		return new EmployeeDAOJDBCImpl();
	}
	
}
