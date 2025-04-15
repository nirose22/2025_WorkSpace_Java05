package com.example_EmployeeDAO.model;

public interface EmployeeDAO extends AutoCloseable {
    void add(Employee emp) throws DAOException;
    void delete(int id) throws DAOException;
    void update(Employee emp) throws DAOException;
    Employee[] getAllEmployees() throws DAOException;
    Employee findById(int id) throws DAOException;
}
