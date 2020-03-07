package kz.iitu.employeesalary.event;

import org.springframework.context.ApplicationEvent;

public class SalaryUpdateEvent extends ApplicationEvent {

    public SalaryUpdateEvent(Object source) {
        super(source);
    }
}
