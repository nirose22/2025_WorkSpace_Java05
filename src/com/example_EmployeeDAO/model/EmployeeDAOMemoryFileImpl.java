package com.example_EmployeeDAO.model;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class EmployeeDAOMemoryFileImpl implements EmployeeDAO {
    private SortedMap<Integer, Employee> employees = new TreeMap<>();
    SimpleDateFormat df = new SimpleDateFormat("MMMM d, yyyy", Locale.US);
    private String fileName;

    public EmployeeDAOMemoryFileImpl(String fileName) {
        this.fileName = fileName;
    }

    public void syncData() {
        try (
                BufferedReader br = new BufferedReader(new FileReader(fileName));
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split("\\|");
                Employee emp = new Employee(Integer.parseInt(fields[0]), fields[1], fields[2], df.parse(fields[3]), Float.parseFloat(fields[4]));
                employees.put(emp.getId(), emp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void commit() {
        try (
                PrintWriter pw = new PrintWriter(new FileWriter(fileName));
        ) {
            for (Employee emp : employees.values()) {
                pw.printf("""
                        %d|%s|%s|%s|%.2f
                        """, emp.getId(), emp.getFirstName(), emp.getLastName(), df.format(emp.getBirthDate()), emp.getSalary());
            }
            pw.flush();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void add(Employee emp) throws DAOException {
        if (employees.containsKey(emp.getId())) {
            throw new DAOException("ID 無效或已存在");
        }
        employees.put(emp.getId(), emp);
        commit();
    }

    @Override
    public void delete(int id) throws DAOException {
        if (!employees.containsKey(id)) {
            throw new DAOException("ID 無效無法刪除");
        }
        employees.remove(id);
        commit();
    }

    @Override
    public void update(Employee emp) throws DAOException {
        if (!employees.containsKey(emp.getId())) {
            throw new DAOException("ID 無效無法更新");
        }
        employees.put(emp.getId(), emp);
        commit();
    }

    @Override
    public Employee[] getAllEmployees() {
        syncData();
        return employees.values().toArray(new Employee[0]);
    }

    @Override
    public Employee findById(int id) throws DAOException {
        syncData();
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
