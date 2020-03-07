package kz.iitu.employeesalary.util;

import kz.iitu.employeesalary.models.CommissionEmployee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommissionEmployeeMapper implements RowMapper {

    @Override
    public CommissionEmployee mapRow(ResultSet resultSet, int i) throws SQLException
    {
        CommissionEmployee commissionEmployee = new CommissionEmployee();
        commissionEmployee.setSalesAmount(resultSet.getDouble("SalesAmount"));
        commissionEmployee.setSalesPercentage(resultSet.getDouble("SalesPercentage"));
        return commissionEmployee;
    }
}
