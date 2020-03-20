package kz.iitu.employeesalary.repository;

import kz.iitu.employeesalary.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

   /* @Query("SELECT e FROM employee e WHERE e.name = :name")
    public Employee findByName(@Param("name") String name);*/
}
