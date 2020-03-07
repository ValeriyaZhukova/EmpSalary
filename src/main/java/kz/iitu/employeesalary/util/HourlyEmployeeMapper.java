package kz.iitu.employeesalary.util;

import kz.iitu.employeesalary.models.HourlyEmployee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HourlyEmployeeMapper implements RowMapper {

    @Override
    public HourlyEmployee mapRow(ResultSet resultSet, int i) throws SQLException
    {
        HourlyEmployee hourlyEmployee = new HourlyEmployee();
        hourlyEmployee.setHoursWorked(resultSet.getInt("HoursWorked"));
        hourlyEmployee.setHourlyRate(resultSet.getDouble("HourlyRate"));
        hourlyEmployee.setOvertimePay(resultSet.getDouble("OvertimePay"));
        return hourlyEmployee;
    }
}
