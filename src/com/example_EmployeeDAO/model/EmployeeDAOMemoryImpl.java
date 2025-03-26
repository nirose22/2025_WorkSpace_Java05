package com.example_EmployeeDAO.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOMemoryImpl implements EmployeeDAO {
    private final Employee[] employeeArray = new Employee[10];
    @Override
    public void add(Employee emp) {
        employeeArray[emp.getId()] = emp;
    }

    @Override
    public void delete(int id) {
        employeeArray[id] = null;
    }

    @Override
    public void update(Employee emp) {
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
    public Employee findById(int id) {
        return employeeArray[id];
    }
}
