package com.example_EmployeeDAO.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOMemoryImpl implements EmployeeDAO {
    private final Employee[] employeeArray = new Employee[10];
    @Override
    public void add(Employee emp) throws DAOException {
        if (emp.getId() < 0 || emp.getId() >= employeeArray.length || employeeArray[emp.getId()] != null) {
            throw new DAOException("ID 無效或已存在");
        }
        employeeArray[emp.getId()] = emp;
    }

    @Override
    public void delete(int id) throws DAOException {
        if (id < 0 || id >= employeeArray.length || employeeArray[id] == null) {
            throw new DAOException("ID 無效無法刪除");
        }
        employeeArray[id] = null;
    }

    @Override
    public void update(Employee emp) throws DAOException {
        if (emp.getId() < 0 || emp.getId() >= employeeArray.length || employeeArray[emp.getId()] == null) {
            throw new DAOException("ID 無效無法更新");
        }
        employeeArray[emp.getId()] = emp;
    }

    @Override
    public Employee[] getAllEmployees() {
        List<Employee> emps = new ArrayList<>();
        // Iterate through the memory array and find Employee objects
        for (Employee e : employeeArray) {
            if (e != null) {
                emps.add(e);
            }
        }
        return emps.toArray(new Employee[0]);
    }

    @Override
    public Employee findById(int id) throws DAOException {
        if (id < 0 || id >= employeeArray.length || employeeArray[id] == null) {
            throw new DAOException("ID 無效無法查詢");
        }
        return employeeArray[id];
    }

    @Override
    public void close() {
        System.out.println("Closing.....");
    }
}
