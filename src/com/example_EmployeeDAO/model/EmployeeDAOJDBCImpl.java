package com.example_EmployeeDAO.model;

import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class EmployeeDAOJDBCImpl implements EmployeeDAO {
    Connection conn;

    public EmployeeDAOJDBCImpl() {
        String url = "jdbc:mysql://localhost:3306/EmployeeDB";
        String username = "root";
        String pwd = "password";
        try {
            conn = DriverManager.getConnection(url, username, pwd);
        } catch (SQLException ex) {
            System.out.println("Error connecting to the database: " + ex.getMessage());
        }
    }


    @Override
    public void add(Employee emp) throws DAOException {
        try (PreparedStatement pStmt = conn.prepareStatement("INSERT INTO EMPLOYEE VALUES (?, ?, ?, ?, ?)");) {
            pStmt.setInt(1, emp.getId());
            pStmt.setString(2, emp.getFirstName());
            pStmt.setString(3, emp.getLastName());
            pStmt.setDate(4, new java.sql.Date(emp.getBirthDate().getTime()));
            pStmt.setDouble(5, emp.getSalary());
            if (pStmt.executeUpdate() != 1) {
                throw new DAOException("新增資料失敗！");
            }
        } catch (SQLException ex) {
            throw new DAOException("新增資料發生錯誤", ex);
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        try (PreparedStatement pStmt = conn.prepareStatement("DELETE FROM EMPLOYEE WHERE ID = ?");) {
            pStmt.setInt(1, id);
            pStmt.executeUpdate();
            if (pStmt.executeUpdate() != 1) {
                throw new DAOException("刪除資料失敗！");
            }
        } catch (SQLException ex) {
            throw new DAOException("新增資料發生錯誤", ex);
        }
    }

    @Override
    public void update(Employee emp) throws DAOException {
        try (PreparedStatement pStmt = conn.prepareStatement("UPDATE EMPLOYEE SET FIRSTNAME = ?, LASTNAME = ?, BIRTHDATE = ?, SALARY = ? WHERE ID = ?");) {
            pStmt.setString(1, emp.getFirstName());
            pStmt.setString(2, emp.getLastName());
            pStmt.setDate(3, new java.sql.Date(emp.getBirthDate().getTime()));
            pStmt.setFloat(4, emp.getSalary());
            if (pStmt.executeUpdate() != 1) {
                throw new DAOException("新增資料失敗！");
            }
        } catch (SQLException ex) {
            throw new DAOException("新增資料發生錯誤", ex);
        }
    }

    //@Override
    //public Employee[] getAllEmployees() throws DAOException {
    //    String query = "SELECT * FROM EMPLOYEE";
    //    Employee[] emps = null;
    //    try (Statement stmt = conn.createStatement()) {
    //        ResultSet rs = stmt.executeQuery(query);
    //        while (rs.next()) {
    //            emps = new Employee[rs.getInt("COUNT(*)")];
    //            System.out.println(rs.getInt("COUNT(*)"));
    //            for (int i = 0; i < emps.length; i++) {
    //                emps[i] = new Employee(rs.getInt("ID"),
    //                        rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),
    //                        rs.getDate("BIRTHDATE"), rs.getFloat("SALARY"));
    //                System.out.println(emps[i]);
    //            }
    //        }
    //        return emps;
    //    } catch (SQLException ex) {
    //        throw new DAOException("？？？", ex);
    //    }
    //}

    public Employee[] getAllEmployees() throws DAOException {
        //SELECT * FROM EMPLOYEE
        String query = "SELECT * FROM EMPLOYEE";
        ArrayList<Employee> emps = new ArrayList<>();;
        try(Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(query);
            System.out.println(rs.getInt("COUNT(*)"));

            while(rs.next())
                emps.add(new Employee(rs.getInt("ID"),
                        rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),
                        rs.getDate("BIRTHDATE"), rs.getFloat("SALARY")));
            return emps.toArray(new Employee[0]);
        } catch(SQLException ex) {
            throw new DAOException("資料庫查詢發生錯誤:", ex);
        }
    }

    @Override
    public Employee findById(int id) throws DAOException {
        Employee emp = null;
        try (PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE ID = ?");) {
            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();
            if (rs.next()) {
                emp = new Employee(rs.getInt("ID"),
                        rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),
                        rs.getDate("BIRTHDATE"), rs.getFloat("SALARY"));
            }
            return emp;
        } catch (SQLException ex) {
            throw new DAOException("查詢資料發生錯誤", ex);
        }
    }

    @Override
    public void close() throws DAOException {
        System.out.println("Closing.....");
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            throw new DAOException("關閉資料庫連線發生錯誤", ex);
        }

    }
}
