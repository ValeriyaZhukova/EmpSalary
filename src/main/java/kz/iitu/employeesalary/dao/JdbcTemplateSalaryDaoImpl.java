package kz.iitu.employeesalary.dao;

import kz.iitu.employeesalary.models.CommissionEmployee;
import kz.iitu.employeesalary.models.HourlyEmployee;
import kz.iitu.employeesalary.models.SalariedCommissionEmployee;
import kz.iitu.employeesalary.models.SalariedEmployee;
import kz.iitu.employeesalary.util.CommissionEmployeeMapper;
import kz.iitu.employeesalary.util.HourlyEmployeeMapper;
import kz.iitu.employeesalary.util.SalComEmployeeMapper;
import kz.iitu.employeesalary.util.SalariedEmployeeMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class JdbcTemplateSalaryDaoImpl implements SalaryDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource dataSource)
    {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addSalaryRecord(Integer ID, double MonthlySalary, double HoursWorked, int HourlyRate, double OvertimePay, double SalesAmount, double SalesPercentage, int EmployeeID)
    {
        String SQL = "INSERT INTO public.\"Salary\"(\"ID\", \"MonthlySalary\", \"HoursWorked\", \"HourlyRate\", \"OvertimePay\", \"SalesAmount\", \"SalesPercentage\", \"EmployeeID\") VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(SQL, ID, MonthlySalary, HoursWorked, HourlyRate, OvertimePay, SalesAmount, SalesPercentage, EmployeeID);
    }

    @Override
    public SalariedEmployee getSalariedEmployeeByEmployeeId(Integer EmpID)
    {
        String SQL = "SELECT \"MonthlySalary\" FROM public.\"Salary\" WHERE \"EmployeeID\" = ?";
        SalariedEmployee salariedEmployee = (SalariedEmployee) jdbcTemplate.queryForObject(SQL, new Object[]{EmpID}, new SalariedEmployeeMapper());
        System.out.println(salariedEmployee.toString());
        return salariedEmployee;
    }

    @Override
    public HourlyEmployee getHourlyEmployeeByEmployeeId(Integer EmpID)
    {
        String SQL = "SELECT \"HoursWorked\", \"HourlyRate\", \"OvertimePay\" FROM public.\"Salary\" WHERE \"EmployeeID\" = ?";
        HourlyEmployee hourlyEmployee = (HourlyEmployee) jdbcTemplate.queryForObject(SQL, new Object[]{EmpID}, new HourlyEmployeeMapper());
        System.out.println(hourlyEmployee.toString());
        return hourlyEmployee;
    }

    @Override
    public CommissionEmployee getCommissionEmployeeByEmployeeId(Integer EmpID)
    {
        String SQL = "SELECT \"SalesAmount\", \"SalesPercentage\" FROM public.\"Salary\" WHERE \"EmployeeID\" = ?";
        CommissionEmployee commissionEmployee = (CommissionEmployee) jdbcTemplate.queryForObject(SQL, new Object[]{EmpID}, new CommissionEmployeeMapper());
        System.out.println(commissionEmployee.toString());
        return commissionEmployee;
    }

    @Override
    public SalariedCommissionEmployee getSalComEmployeeByEmployeeId(Integer EmpID)
    {
        String SQL = "SELECT \"MonthlySalary\", \"SalesAmount\", \"SalesPercentage\" FROM public.\"Salary\" WHERE \"EmployeeID\" = ?";
        SalariedCommissionEmployee salariedCommissionEmployee = (SalariedCommissionEmployee) jdbcTemplate.queryForObject(SQL, new Object[]{EmpID}, new SalComEmployeeMapper());
        System.out.println(salariedCommissionEmployee.toString());
        return salariedCommissionEmployee;
    }

    @Override
    public void deleteSalary(Integer ID)
    {
        String SQL = "DELETE FROM public.\"Salary\" WHERE \"ID\" = ?";
        jdbcTemplate.update(SQL, ID);
        System.out.println("Successfully deleted");
    }

    @Override
    public void updateSalary(Integer ID, double MonthlySalary, double HoursWorked, int HourlyRate, double OvertimePay, double SalesAmount, double SalesPercentage, int EmployeeID)
    {
        String SQL = "UPDATE public.\"Salary\" SET \"MonthlySalary\"=?, \"HoursWorked\"=?, \"HourlyRate\"=?, \"OvertimePay\"=?, \"SalesAmount\"=?, \"SalesPercentage\"=?, \"EmployeeID\"=? WHERE \"ID\" = ?";
        jdbcTemplate.update(SQL, MonthlySalary, HoursWorked, HourlyRate, OvertimePay, SalesAmount, SalesPercentage, EmployeeID, ID);
        System.out.println("Successfully updated.");
    }
}
