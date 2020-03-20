package kz.iitu.employeesalary.config;
import kz.iitu.employeesalary.EmployeeSalary;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "kz.iitu.employeesalary")
public class SpringConfiguration {

    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/employeesalary")
                .username("root")
                .password("1212")
                .build();
    }

    @Bean
    public EmployeeSalary facade()
    {
        return new EmployeeSalary();
    }



}
