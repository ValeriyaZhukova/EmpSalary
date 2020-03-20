package kz.iitu.employeesalary;

import kz.iitu.employeesalary.model.Employee;
import kz.iitu.employeesalary.model.EmployeeType;
import kz.iitu.employeesalary.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class EmployeeSalary {

    int userInput;

    Scanner scanner = new Scanner(System.in);

    @Autowired
    EmployeeRepository employeeRepository;

    Employee employee;

    private List<Employee> employees = new ArrayList<>();

    public void createNewEmployee()
    {
        String name, type;
        double fixedSalary;
        double hourRate;
        int hoursWorked;
        float commRate;
        EmployeeType employeeType;

        System.out.println("Enter employee name");
        name = scanner.next();
        System.out.println("Enter employee type");
        type = scanner.next();

        if(type.equals("Salaried"))
        {
            System.out.println("Enter fixed salary");
            fixedSalary = scanner.nextDouble();
            hourRate = 0;
            hoursWorked = 0;
            commRate = 0;
            employeeType = EmployeeType.SALARIED;
        }
        else if(type.equals("Hourly"))
        {
            System.out.println("Enter hour rate");
            hourRate = scanner.nextDouble();
            System.out.println("Enter hours worked");
            hoursWorked = scanner.nextInt();
            fixedSalary = 0;
            commRate = 0;
            employeeType = EmployeeType.HOURLY;
        }
        else if(type.equals("Commission"))
        {
            System.out.println("Enter commission rate");
            commRate = scanner.nextFloat();
            fixedSalary = 0;
            hourRate = 0;
            hoursWorked = 0;
            employeeType = EmployeeType.COMMISION;
        }
        else if(type.equals("Salaried-Commission"))
        {
            System.out.println("Enter fixed salary");
            fixedSalary = scanner.nextDouble();
            System.out.println("Enter commission rate");
            commRate = scanner.nextFloat();
            hourRate = 0;
            hoursWorked = 0;
            employeeType = EmployeeType.SALARIED_COMMISION;
        }
        else
        {
            fixedSalary = 0;
            hourRate = 0;
            hoursWorked = 0;
            commRate = 0;
            employeeType = EmployeeType.SALARIED;
        }
        employee = new Employee(name, fixedSalary, hourRate, hoursWorked, commRate, employeeType);
        employeeRepository.save(employee);
    }

    public void getEmployeeByID()
    {
        long id;
        System.out.println("Enter employee id");
        id = scanner.nextLong();
        employee = employeeRepository.findById(id).get();
        System.out.println(employee.toString());
    }
/*
    public void findEmployeeByName()
    {
        String name;
        System.out.println("Enter employee name");
        name = scanner.next();
        employee = employeeRepository.findByName(name);
        System.out.println(employee.toString());
    }*/

    public void listEmployees()
    {
        employees.clear();
        for (Employee e: employeeRepository.findAll())
        {
            employees.add(e);
        }
        for (int i = 0; i < employees.size(); i++)
        {
            System.out.println(employees.get(i).toString());
        }
    }

    public void deleteEmployee()
    {
        long id;
        System.out.println("Enter employee id");
        id = scanner.nextLong();
        employeeRepository.deleteById(id);
        System.out.println("Employee with id " + id + " was successfully deleted");
    }

    public void updateEmployee()
    {
        long id;
        double fixedSalary;
        double hourRate;
        int hoursWorked;
        float commRate;
        System.out.println("Enter employee id");
        id = scanner.nextLong();
        employee = employeeRepository.findById(id).get();
        System.out.println(employee.toString());

        if (employee.getEmplType().equals(EmployeeType.SALARIED))
        {
            System.out.println("Enter fixed salary");
            fixedSalary = scanner.nextDouble();
            employee.setFixedSalary(fixedSalary);
        }
        else if(employee.getEmplType().equals(EmployeeType.HOURLY))
        {
            System.out.println("Enter hour rate");
            hourRate = scanner.nextDouble();
            System.out.println("Enter hours worked");
            hoursWorked = scanner.nextInt();
            employee.setHourRate(hourRate);
            employee.setHoursWorked(hoursWorked);
        }
        else if (employee.getEmplType().equals(EmployeeType.COMMISION))
        {
            System.out.println("Enter commission rate");
            commRate = scanner.nextFloat();
            employee.setCommRate(commRate);
        }
        else if (employee.getEmplType().equals(EmployeeType.SALARIED_COMMISION))
        {
            System.out.println("Enter fixed salary");
            fixedSalary = scanner.nextDouble();
            System.out.println("Enter commission rate");
            commRate = scanner.nextFloat();
            employee.setCommRate(commRate);
            employee.setFixedSalary(fixedSalary);
        }
        
        employeeRepository.save(employee);
        System.out.println("Successfully updated: \n");
        System.out.println(employee.toString());
    }

    public void calculateEmployeeSalary()
    {
        double salary = 0;
        System.out.println("Enter employee id");
        long id = scanner.nextLong();
        employee = employeeRepository.findById(id).get();

        if (employee.getEmplType().equals(EmployeeType.SALARIED))
        {
            salary = employee.getFixedSalary();
        }
        else if(employee.getEmplType().equals(EmployeeType.HOURLY))
        {
            salary = employee.getHourRate() * employee.getHoursWorked();
        }
        else if (employee.getEmplType().equals(EmployeeType.COMMISION))
        {
            salary = employee.getCommRate() / 100 * 5000;
        }
        else if (employee.getEmplType().equals(EmployeeType.SALARIED_COMMISION))
        {
            salary = employee.getFixedSalary() + employee.getCommRate() / 100 * 5000;
        }

        System.out.println(employee.toString());
        System.out.println("Salary: " + salary);
    }

    public void run()
    {
        System.out.println("0 - Exit");
        System.out.println("1 - Add new employee");
        System.out.println("2 - Get employee by id");
        System.out.println("3 - List all employees");
        System.out.println("4 - Delete employee by id");
        System.out.println("5 - Update employee");

        System.out.println("\n6 - Calculate employee salary");

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

                case 6:
                {
                    calculateEmployeeSalary();
                    break;
                }
            }
        }



    }


}
