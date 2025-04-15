package com.example_EmployeeDAO.model;

public class EmployeeDAOFactory  {
    public EmployeeDAO createEmployeeDAO()
    {
        return new EmployeeDAOJDBCImpl();
        //return new EmployeeDAOMemoryFileImpl(fileName);
        //return new EmployeeDAOMemoryMapImpl();
        //return new EmployeeDAOMemoryImpl();
    }
}
