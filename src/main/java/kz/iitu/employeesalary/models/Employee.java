package kz.iitu.employeesalary.models;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {

    private int id;
    private String name;
    @Autowired
    private EmployeeType type;
    private String employeeType;
    private double salary;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public EmployeeType getType()
    {
        return type;
    }

    public void setType(EmployeeType type)
    {
        this.type = type;
    }

    public String getEmployeeType()
    {
        return employeeType;
    }

    public void setEmployeeType(String employeeType)
    {
        this.employeeType = employeeType;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", salary=" + salary +
                '}';
    }
}
