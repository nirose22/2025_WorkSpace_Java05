package com.example_EmployeeDAO.test;

import com.example_EmployeeDAO.model.DAOException;
import com.example_EmployeeDAO.model.Employee;
import com.example_EmployeeDAO.model.EmployeeDAO;
import com.example_EmployeeDAO.model.EmployeeDAOFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EmployeeTestInteractive2 {

    public static void main(String[] args) {
        // 创建EmployeeDAOFactory对象
        EmployeeDAOFactory factory = new EmployeeDAOFactory();
        // 创建EmployeeDAO对象
        EmployeeDAO dao = factory.createEmployeeDAO();

        // 定义一个布尔变量，用于控制是否退出程序
        boolean timeToQuit = false;
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))){
            // 循环执行菜单
            do {
                try {
                    // 执行菜单
                    timeToQuit = executeMenu(in, dao);
                } catch(DAOException ex) {
                    // 捕获DAOException异常
                    System.err.println("發生例外:"+ex.getMessage());
                }
            } while (!timeToQuit);
        } catch(IOException ex) {
            // 捕获IOException异常
            System.err.println(ex.toString());
            System.err.println("程式結束!");
        }
    }

    public static boolean executeMenu(BufferedReader in, EmployeeDAO dao) throws IOException, DAOException {
        Employee emp;
        // 定义Employee对象
        String action;
        // 定义操作类型
        int id;
        // 定义员工ID

        System.out.println("\n\n[C]reate | [R]ead | [U]pdate | [D]elete | [L]ist | [Q]uit: ");
        // 打印菜单
        action = in.readLine();
        // 读取用户输入的操作类型
        if ((action.length() == 0) || action.toUpperCase().charAt(0) == 'Q') {
        // 如果用户输入为空或者输入的是Q，则退出程序
            return true;
        }

        switch (action.toUpperCase().charAt(0)) {
            // Create a new employee record
            case 'C':
                emp = inputEmployee(in);
                //emp.save();
                dao.add(emp);
                System.out.println("Successfully added Employee Record: " + emp.getId());
                System.out.println("\n\nCreated " + emp);
                break;

            // Display an employee record
            case 'R':
                System.out.println("Enter int value for employee id: ");
                id = Integer.valueOf(in.readLine().trim());

                // Find this Employee record
                emp = dao.findById(id);
                if (emp != null) {
                    System.out.println(emp + "\n");
                } else {
                    System.out.println("\n\nEmployee " + id + " not found");
                    break;
                }

                break;

            // Update an existing employee record
            case 'U':
                System.out.println("Enter int value for employee id: ");
                id = Integer.valueOf(in.readLine().trim());
                // Find this Employee record
                emp = dao.findById(id);
                if (emp == null) {
                    System.out.println("\n\nEmployee " + id + " not found");
                    break;
                }
                // Go through the record to allow changes

                emp = inputEmployee(in, emp);
                dao.update(emp);
                System.out.println("Successfully updated Employee Record: " + emp.getId());
                break;

            // Delete an employee record
            case 'D':
                System.out.println("Enter int value for employee id: ");
                id = Integer.valueOf(in.readLine().trim());

                // Find this Employee record
                emp = null;
                emp = dao.findById(id);
                if (emp == null) {
                    System.out.println("\n\nEmployee " + id + " not found");
                    break;
                }
                dao.delete(id);
                System.out.println("Deleted Employee " + id);
                break;

            // Display a list (Read the records) of Employees
            case 'L':
                Employee[] allEmps = dao.getAllEmployees();
                for (Employee employee : allEmps) {
                    System.out.println(employee + "\n");
                }
                break;
        }

        return false;
    }

    public static Employee inputEmployee(BufferedReader in) throws IOException {
        return inputEmployee(in, null, true);
    }

    public static Employee inputEmployee(BufferedReader in, Employee empDefaults) throws IOException {
        return inputEmployee(in, empDefaults, false);
    }

    public static Employee inputEmployee(BufferedReader in, Employee empDefaults, boolean newEmployee) throws IOException {
        SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy", Locale.US);
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        int id = -1;
        String firstName;
        String lastName;
        Date birthDate = null;
        Employee emp;
        float salary;

        if (newEmployee) {
            do {
                System.out.println("Enter int value for employee id: ");
                try {
                    id = Integer.valueOf(in.readLine().trim());
                    if (id < 0) {
                        System.out.println("Please retry with a valid positive integer id");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please retry with a valid positive integer id");
                }
            } while (id < 0);
        } else {
            id = empDefaults.getId();
            System.out.println("Modify the fields of Employee record: " + id
                    + ". Press return to accept current value.");
        }

        String prompt = "Enter value for employee first name" + ((empDefaults == null) ? "" : " [" + empDefaults.getFirstName() + "]");

        do {
            System.out.println(prompt + " : ");
            firstName = in.readLine().trim();
            if (firstName.equals("") && empDefaults != null) {
                firstName = empDefaults.getFirstName();
            }
            if (firstName.length() < 1) {
                System.out.println("Please retry with a valid first name");
            }
        } while (firstName.length() < 1);


        prompt = "Enter value for employee last name" + ((empDefaults == null) ? "" : " [" + empDefaults.getLastName() + "]");
        do {
            System.out.println(prompt + " : ");
            lastName = in.readLine().trim();
            if (lastName.equals("") && empDefaults != null) {
                lastName = empDefaults.getLastName();
            }
            if (lastName.length() < 1) {
                System.out.println("Please retry with a valid last name");
            }
        } while (lastName.length() < 1);


        prompt = "Enter value for employee birth date (" + df.toLocalizedPattern() + ")"
                + ((empDefaults == null) ? "" : " [" + df.format(empDefaults.getBirthDate()) + "]");
        do {
            System.out.println(prompt + " : ");
            String dateStr = in.readLine().trim();
            if (dateStr.equals("") && empDefaults != null) {
                birthDate = empDefaults.getBirthDate();
            } else {
                birthDate = null;
                try {
                    birthDate = new Date(df.parse(dateStr).getTime());
                } catch (ParseException e) {
                    System.out.println("Please retry with a valid birth date: " + e.getMessage());
                }
            }
        } while (birthDate == null);


        prompt = "Enter float value for employee salary"
                + ((empDefaults == null) ? "" : " [" + nf.format((double) empDefaults.getSalary()) + "]");
        do {
            System.out.println(prompt + " : ");
            salary = 0;
            try {
                String amt = in.readLine().trim();
                if (!amt.equals("")) {
                    salary = Float.parseFloat(amt);
                }
                if (salary == 0 && empDefaults != null) {
                    salary = empDefaults.getSalary();
                }
                if (salary < 0) {
                    System.out.println("Please retry with a positive salary");
                    salary = 0;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please retry with a valid float salary: " + e.getMessage());
            }
        } while (salary == 0);

        // Create an Employee object
        emp = new Employee(id, firstName, lastName, birthDate, salary);
        return emp;
    }
}
