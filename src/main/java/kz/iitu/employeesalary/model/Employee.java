package kz.iitu.employeesalary.model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "fixedSalary")
    private double fixedSalary;
    @Column(name = "hourRate")
    private double hourRate;
    @Column(name = "hoursWorked")
    private int hoursWorked;
    @Column(name = "commRate")
    private float commRate;

    @Enumerated(EnumType.STRING)
    private EmployeeType emplType;

    public Employee() {}

    public Employee(String name, double fixedSalary, double hourRate, int hoursWorked, float commRate, EmployeeType emplType)
    {
        this.name = name;
        this.fixedSalary = fixedSalary;
        this.hourRate = hourRate;
        this.hoursWorked = hoursWorked;
        this.commRate = commRate;
        this.emplType = emplType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public double getHourRate() {
        return hourRate;
    }

    public void setHourRate(double hourRate) {
        this.hourRate = hourRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public float getCommRate() {
        return commRate;
    }

    public void setCommRate(float commRate) {
        this.commRate = commRate;
    }

    public EmployeeType getEmplType() {
        return emplType;
    }

    public void setEmplType(EmployeeType emplType) {
        this.emplType = emplType;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fixedSalary=" + fixedSalary +
                ", hourRate=" + hourRate +
                ", hoursWorked=" + hoursWorked +
                ", commRate=" + commRate +
                ", emplType=" + emplType +
                '}';
    }
}


