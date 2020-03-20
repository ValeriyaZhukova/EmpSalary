package kz.iitu.employeesalary;

import kz.iitu.employeesalary.config.SpringConfiguration;
import kz.iitu.employeesalary.model.Employee;
import kz.iitu.employeesalary.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        EmployeeSalary facade = context.getBean("facade", EmployeeSalary.class);

        facade.run();

    }
}
