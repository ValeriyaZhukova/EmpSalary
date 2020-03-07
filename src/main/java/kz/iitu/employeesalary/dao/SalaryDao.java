package kz.iitu.employeesalary.dao;

import kz.iitu.employeesalary.models.*;

import javax.sql.DataSource;
import java.util.List;

public interface SalaryDao {

    public void setDataSource(DataSource dataSource);

    public void addSalaryRecord(Integer ID,
                          double MonthlySalary,
                          double HoursWorked,
                          int HourlyRate,
                          double OvertimePay,
                          double SalesAmount,
                          double SalesPercentage,
                          int EmployeeID);

    public SalariedEmployee getSalariedEmployeeByEmployeeId(Integer EmpID);

    public HourlyEmployee getHourlyEmployeeByEmployeeId(Integer EmpID);

    public CommissionEmployee getCommissionEmployeeByEmployeeId(Integer EmpID);

    public SalariedCommissionEmployee getSalComEmployeeByEmployeeId(Integer EmpID);

    public void deleteSalary(Integer ID);


    public void updateSalary(Integer ID,
                               double MonthlySalary,
                               double HoursWorked,
                               int HourlyRate,
                               double OvertimePay,
                               double SalesAmount,
                               double SalesPercentage,
                               int EmployeeID);
}
