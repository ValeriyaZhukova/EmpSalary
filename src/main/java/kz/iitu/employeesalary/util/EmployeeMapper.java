package kz.iitu.employeesalary.util;

import kz.iitu.employeesalary.models.Employee;
import kz.iitu.employeesalary.models.SalariedEmployee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper {

    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException
    {
        Employee employee = new Employee();

        employee.setId(resultSet.getInt("ID"));
        employee.setName(resultSet.getString("Name"));
        employee.setEmployeeType(resultSet.getString("Type"));
        employee.setSalary(resultSet.getDouble("Salary"));

        return employee;
    }
}
