package kz.iitu.employeesalary.util;

import kz.iitu.employeesalary.models.SalariedCommissionEmployee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalComEmployeeMapper implements RowMapper {

    @Override
    public SalariedCommissionEmployee mapRow(ResultSet resultSet, int i) throws SQLException
    {
        SalariedCommissionEmployee salariedCommissionEmployee = new SalariedCommissionEmployee();
        salariedCommissionEmployee.setMonthlySalary(resultSet.getDouble("MonthlySalary"));
        salariedCommissionEmployee.setSalesAmount(resultSet.getDouble("SalesAmount"));
        salariedCommissionEmployee.setSalesPercentage(resultSet.getDouble("SalesPercentage"));
        return salariedCommissionEmployee;
    }
}
