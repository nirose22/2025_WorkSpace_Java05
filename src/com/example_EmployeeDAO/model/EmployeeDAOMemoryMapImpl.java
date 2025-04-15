package com.example_EmployeeDAO.model;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class EmployeeDAOMemoryMapImpl implements EmployeeDAO {
    //private final Employee[] employeeArray = new Employee[10];
    private SortedMap<Integer, Employee> employees = new TreeMap<>();
    @Override
    public void add(Employee emp) throws DAOException {
        if (employees.containsKey(emp.getId())) {
            throw new DAOException("ID 無效或已存在");
        }
        employees.put(emp.getId(), emp);
    }

    @Override
    public void delete(int id) throws DAOException {
        if (!employees.containsKey(id)) {
            throw new DAOException("ID 無效無法刪除");
        }
        employees.remove(id);
    }

    @Override
    public void update(Employee emp) throws DAOException {
        if (!employees.containsKey(emp.getId())) {
            throw new DAOException("ID 無效無法更新");
        }
        employees.put(emp.getId(), emp);
    }

    @Override
    public Employee[] getAllEmployees() {
        return employees.values().toArray(new Employee[0]);
    }

    @Override
    public Employee findById(int id) throws DAOException {
        if (!employees.containsKey(id)) {
            throw new DAOException("ID 無效無法查詢");
        }
        return employees.get(id);
    }

    @Override
    public void close() {
        System.out.println("Closing.....");
    }
}
