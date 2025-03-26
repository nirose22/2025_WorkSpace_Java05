package com.example_EmployeeDAO.model;

public class EmployeeDAOFactory  {
    public EmployeeDAO createEmployeeDAO() {
        return new EmployeeDAOMemoryImpl();
    }
}
