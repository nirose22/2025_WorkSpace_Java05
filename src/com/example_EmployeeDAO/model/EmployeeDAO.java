package com.example_EmployeeDAO.model;

public interface EmployeeDAO {
    void add(Employee emp);
    void delete(int id);
    void update(Employee emp);
    Employee[] getAllEmployees();
    Employee findById(int id);
}
