package com.solution_Employee_JDBC.dao;

import com.solution_Employee_JDBC.model.Employee;

public interface EmployeeDAO extends AutoCloseable{
	
	public void add(Employee emp) throws DAOException;
	
	public void update(Employee emp) throws DAOException;
	
	public void delete(int id) throws DAOException;
	
	public Employee findById(int id) throws DAOException;
	
	public Employee[] getAllEmployees() throws DAOException;
	
}
