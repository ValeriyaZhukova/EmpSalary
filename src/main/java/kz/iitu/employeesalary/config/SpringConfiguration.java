package kz.iitu.employeesalary.config;
import kz.iitu.employeesalary.EmployeeSalary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "kz.iitu.employeesalary")
public class SpringConfiguration {

    @Bean
    public DataSource dataSource()
    {
        DriverManagerDataSource driver = new DriverManagerDataSource();
        driver.setUrl("jdbc:postgresql://localhost:5432/EmployeeSalary");
        driver.setUsername("postgres");
        driver.setPassword("1212");
        return driver;
    }

    @Bean
    public EmployeeSalary facade()
    {
        return new EmployeeSalary();
    }

}
