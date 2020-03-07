package kz.iitu.employeesalary.dao;

import kz.iitu.employeesalary.models.Employee;

import javax.sql.DataSource;
import java.util.List;

public interface EmployeeDao {

    public void setDataSource(DataSource dataSource);

    public void createEmployee(Integer ID, String Name, String Type, double Salary);

    public Employee getEmployeeById(Integer ID);

    public List listEmployees();

    public void deleteEmployee(Integer ID);

    public void updateEmployee(Integer ID, String Name, String Type);

}
