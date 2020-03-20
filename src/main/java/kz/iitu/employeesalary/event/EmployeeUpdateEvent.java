package kz.iitu.employeesalary.event;

import kz.iitu.employeesalary.model.Employee;
import org.springframework.context.ApplicationEvent;

public class EmployeeUpdateEvent extends ApplicationEvent {

    Employee employee;

    public EmployeeUpdateEvent(Object source, Employee employee) {
        super(source);
        this.employee = employee;
    }

    public Employee getEmployee()
    {
        return employee;
    }
}
