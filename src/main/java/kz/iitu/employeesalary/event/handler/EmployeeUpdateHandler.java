package kz.iitu.employeesalary.event.handler;

import kz.iitu.employeesalary.event.EmployeeUpdateEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EmployeeUpdateHandler implements ApplicationListener<EmployeeUpdateEvent> {

    @Override
    public void onApplicationEvent(EmployeeUpdateEvent employeeUpdateEvent)
    {
        System.out.println("Successfully updated: \n");
        System.out.println(employeeUpdateEvent.getEmployee().toString());
    }
}
