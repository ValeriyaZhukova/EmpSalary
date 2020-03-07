package kz.iitu.employeesalary.dao;

import kz.iitu.employeesalary.models.Employee;
import kz.iitu.employeesalary.util.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

@Component
public class JdbcTemplateEmployeeDaoImpl implements EmployeeDao{

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource dataSource)
    {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createEmployee(Integer ID, String Name, String Type, double Salary)
    {
        String SQL = "INSERT INTO public.\"Employee\"(\"ID\", \"Name\", \"Type\", \"Salary\") VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(SQL, ID, Name, Type, Salary);
        System.out.println("Employee successfully created.\nName: " + Name + "; Type: " + Type + "; Salary: " + Salary + "\n");
    }

    @Override
    public Employee getEmployeeById(Integer ID)
    {
        String SQL = "SELECT * FROM public.\"Employee\" WHERE \"ID\" = ?";
        Employee employee = (Employee) jdbcTemplate.queryForObject(SQL, new Object[]{ID}, new EmployeeMapper());
        System.out.println(employee.toString());
        return employee;
    }

    @Override
    public List listEmployees()
    {
        String SQL = "SELECT * FROM public.\"Employee\"";
        List employees = jdbcTemplate.query(SQL, new EmployeeMapper());
        return employees;
    }

    @Override
    public void deleteEmployee(Integer ID)
    {
        String SQL = "DELETE FROM public.\"Employee\" WHERE \"ID\" = ?";
        jdbcTemplate.update(SQL, ID);
        System.out.println("Employee with id: " + ID + " is successfully removed");
    }

    @Override
    public void updateEmployee(Integer ID, String Name, String Type)
    {
        String SQL = "UPDATE public.\"Employee\" SET \"Name\"=?, \"Type\"=? WHERE \"ID\" = ?";
        jdbcTemplate.update(SQL, Name, Type, ID);
        System.out.println("Employee with id: " + ID + " is successfully updated.");
    }

    public void updateEmployeeSalary(int ID, double Salary)
    {
        String SQL = "UPDATE public.\"Employee\" SET \"Salary\"=? WHERE \"ID\" = ?";
        jdbcTemplate.update(SQL, Salary, ID);
    }
}
