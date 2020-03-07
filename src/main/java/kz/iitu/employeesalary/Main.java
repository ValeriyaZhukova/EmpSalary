package kz.iitu.employeesalary;

import kz.iitu.employeesalary.config.SpringConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        EmployeeSalary facade = context.getBean("facade", EmployeeSalary.class);

        facade.run();

    }
}
