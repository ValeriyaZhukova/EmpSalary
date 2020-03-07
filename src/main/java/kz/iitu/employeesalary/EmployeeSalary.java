package kz.iitu.employeesalary;

import kz.iitu.employeesalary.dao.JdbcTemplateEmployeeDaoImpl;
import kz.iitu.employeesalary.dao.JdbcTemplateSalaryDaoImpl;
import kz.iitu.employeesalary.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class EmployeeSalary {

    int userInput;

    Scanner scanner = new Scanner(System.in);

    StringBuilder stringBuilder = new StringBuilder();

    private List<Employee> employees = new ArrayList<>();
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplateEmployeeDaoImpl employeeDao;
    @Autowired
    private JdbcTemplateSalaryDaoImpl salaryDao;

    public void createNewEmployee()
    {
        int id;
        String name, type;
        double salary = 0;

        System.out.println("Enter employee id");
        id = scanner.nextInt();
        System.out.println("Enter employee name");
        name = scanner.nextLine();
        System.out.println("Enter employee type");
        type = scanner.next();

        employeeDao.createEmployee(id, name, type, salary);
    }

    public void getEmployeeByID()
    {
        System.out.println("Enter employee id");
        int id = scanner.nextInt();
        employeeDao.getEmployeeById(id);
    }

    public void listEmployees()
    {
        System.out.println();
        employees = employeeDao.listEmployees();

        for (int i = 0; i < employees.size(); i++)
        {
            System.out.println(employees.get(i).toString());
        }
    }

    public void setEmployees()
    {
        employees = employeeDao.listEmployees();
    }

    public void deleteEmployee()
    {
        System.out.println("Enter employee id you want to delete");
        int empID = scanner.nextInt();
        employeeDao.deleteEmployee(empID);
    }

    public void updateEmployee()
    {
        System.out.println("Enter employee id");
        int id = scanner.nextInt();
        System.out.println("Enter employee name");
        String name = scanner.next();
        System.out.println("Enter employee type");
        String type = scanner.next();
        employeeDao.updateEmployee(id, name, type);
    }

    public void getSalariedEmployee()
    {
        System.out.println("Enter employee id (1)");
        int id = scanner.nextInt();
        if(employees.size() == 0)
        {
            setEmployees();
        }
        for (int i = 0; i < employees.size(); i++)
        {
            if (employees.get(i).getId() == id)
            {
                employees.get(i).setType(salaryDao.getSalariedEmployeeByEmployeeId(id));
                employees.get(i).setEmployeeType("Salaried");
                System.out.println(employees.get(i).toString());
            }
        }
    }

    public void getHourlyEmployee()
    {
        System.out.println("Enter employee id (2)");
        int id = scanner.nextInt();
        if(employees.size() == 0)
        {
            setEmployees();
        }
        for (int i = 0; i < employees.size(); i++)
        {
            if (employees.get(i).getId() == id)
            {
                employees.get(i).setType(salaryDao.getHourlyEmployeeByEmployeeId(id));
                employees.get(i).setEmployeeType("Hourly");
                System.out.println(employees.get(i).toString());
            }
        }
    }

    public void getCommissionEmployee()
    {
        System.out.println("Enter employee id (3)");
        int id = scanner.nextInt();
        if(employees.size() == 0)
        {
            setEmployees();
        }
        for (int i = 0; i < employees.size(); i++)
        {
            if (employees.get(i).getId() == id)
            {
                employees.get(i).setType(salaryDao.getCommissionEmployeeByEmployeeId(id));
                employees.get(i).setEmployeeType("Commission");
                System.out.println(employees.get(i).toString());
            }
        }
    }

    public void getSalComEmployee()
    {
        System.out.println("Enter employee id (4)");
        int id = scanner.nextInt();
        if(employees.size() == 0)
        {
            setEmployees();
        }
        for (int i = 0; i < employees.size(); i++)
        {
            if (employees.get(i).getId() == id)
            {
                employees.get(i).setType(salaryDao.getSalComEmployeeByEmployeeId(id));
                employees.get(i).setEmployeeType("Salaried-Commission");
                System.out.println(employees.get(i).toString());
            }
        }
    }

    public void calculateEmployeeSalary()
    {
        double salary;
        System.out.println("Enter employee id");
        int id = scanner.nextInt();
        for (int i = 0; i < employees.size(); i++)
        {
            if (employees.get(i).getId() == id)
            {
                if (employees.get(i).getEmployeeType().equals("Salaried"))
                {
                    double monthlySalary = employees.get(i).getType().getMonthlySalary();
                    salary = monthlySalary / 4;
                    System.out.println("Monthly salary: " + monthlySalary);
                    System.out.println("Employee " + employees.get(i).getName() + " earned " + salary + " $ this week");
                }

                else if (employees.get(i).getEmployeeType().equals("Hourly"))
                {
                    int hoursWorked = employees.get(i).getType().getHoursWorked();
                    double hourlyRate = employees.get(i).getType().getHourlyRate();
                    double overtimePay = employees.get(i).getType().getOvertimePay();

                    salary = hoursWorked * hourlyRate * overtimePay;
                    System.out.println("Hours worked: " + hoursWorked + " hourly rate: " + hourlyRate + " overtime pay: " + overtimePay);
                    System.out.println("Employee " + employees.get(i).getName() + " earned " + salary + " $ this week");
                }

                else if (employees.get(i).getEmployeeType().equals("Commission"))
                {
                    double salesAmount = employees.get(i).getType().getSalesAmount();
                    double salesPercentage = employees.get(i).getType().getSalesPercentage();
                    salary = (salesAmount * salesPercentage / 100) / 4;
                    System.out.println("Sales amount: " + salesAmount + " sales percentage: " + salesPercentage);
                    System.out.println("Employee " + employees.get(i).getName() + " earned " + salary + " $ this week");
                }

                else if (employees.get(i).getEmployeeType().equals("Salaried-Commission"))
                {
                    double monthlySalary = employees.get(i).getType().getMonthlySalary();
                    double salesAmount = employees.get(i).getType().getSalesAmount();
                    double salesPercentage = employees.get(i).getType().getSalesPercentage();
                    salary = (monthlySalary + salesAmount * salesPercentage / 100) / 4;
                    System.out.println("Monthly salary: " + monthlySalary + " sales amount: " + salesAmount + " sales percentage: " + salesPercentage);
                    System.out.println("Employee " + employees.get(i).getName() + " earned " + salary + " $ this week");
                }
            }
        }
    }

    public void run()
    {
        employeeDao.setDataSource(dataSource);
        salaryDao.setDataSource(dataSource);

        System.out.println("0 - Exit");
        System.out.println("1 - Add new employee");
        System.out.println("2 - Get employee by id");
        System.out.println("3 - List all employees");
        System.out.println("4 - Delete employee by id");
        System.out.println("5 - Update employee");

        //System.out.println("\n6 - Add new salary record");
        System.out.println("7 - Get Salaried employee by employee id");
        System.out.println("8 - Get Hourly employee by employee id");
        System.out.println("9 - Get Commission employee by employee id");
        System.out.println("10 - Get Salaried-Commission employee by employee id");
        //System.out.println("11 - Delete salary record by id");
        //System.out.println("12 - Update salary record");

        System.out.println("\n13 - Calculate employee salary (only after steps 7 - 10)");

        userInput = 1;

        for (int i = 0; i < employees.size(); i++)
        {
            System.out.println(employees.get(i).toString());
        }

        while (userInput != 0)
        {
            userInput = scanner.nextInt();

            switch (userInput)
            {
                case 0:
                {
                    break;
                }

                case 1:
                {
                    createNewEmployee();
                    break;
                }

                case 2:
                {
                    getEmployeeByID();
                    break;
                }

                case 3:
                {
                    listEmployees();
                    break;
                }

                case 4:
                {
                    deleteEmployee();
                    break;
                }

                case 5:
                {
                    updateEmployee();
                    break;
                }

                case 7:
                {
                    getSalariedEmployee();
                    break;
                }

                case 8:
                {
                    getHourlyEmployee();
                    break;
                }

                case 9:
                {
                    getCommissionEmployee();
                    break;
                }

                case 10:
                {
                    getSalComEmployee();
                    break;
                }

                case 13:
                {
                    calculateEmployeeSalary();
                    break;
                }
            }
        }



    }


}
