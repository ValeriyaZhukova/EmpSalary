package kz.iitu.employeesalary.event.handler;

import kz.iitu.employeesalary.event.SalaryUpdateEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SalaryUpdateHandler implements ApplicationListener<SalaryUpdateEvent> {



    @Override
    public void onApplicationEvent(SalaryUpdateEvent salaryUpdateEvent)
    {

    }
}
