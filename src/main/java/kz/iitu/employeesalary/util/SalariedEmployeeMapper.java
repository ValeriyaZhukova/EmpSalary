package kz.iitu.employeesalary.util;

import kz.iitu.employeesalary.models.SalariedEmployee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalariedEmployeeMapper implements RowMapper {

    @Override
    public SalariedEmployee mapRow(ResultSet resultSet, int i) throws SQLException
    {
        SalariedEmployee salariedEmployee = new SalariedEmployee();
        salariedEmployee.setMonthlySalary(resultSet.getDouble("MonthlySalary"));
        return salariedEmployee;
    }
}
