package kz.iitu.employeesalary.models;

public abstract class EmployeeType {

    private String type;
    private double monthlySalary;
    private int hoursWorked;
    private double hourlyRate;
    private double overtimePay;
    private double salesAmount;
    private double salesPercentage;

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public double getMonthlySalary()
    {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary)
    {
        this.monthlySalary = monthlySalary;
    }

    public int getHoursWorked()
    {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked)
    {
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate()
    {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate)
    {
        this.hourlyRate = hourlyRate;
    }

    public double getOvertimePay()
    {
        return overtimePay;
    }

    public void setOvertimePay(double overtimePay)
    {
        this.overtimePay = overtimePay;
    }

    public double getSalesAmount()
    {
        return salesAmount;
    }

    public void setSalesAmount(double salesAmount)
    {
        this.salesAmount = salesAmount;
    }

    public double getSalesPercentage()
    {
        return salesPercentage;
    }

    public void setSalesPercentage(double salesPercentage)
    {
        this.salesPercentage = salesPercentage;
    }

    @Override
    public String toString() {
        return "{" +
                "monthlySalary=" + monthlySalary +
                ", hoursWorked=" + hoursWorked +
                ", hourlyRate=" + hourlyRate +
                ", overtimePay=" + overtimePay +
                ", salesAmount=" + salesAmount +
                ", salesPercentage=" + salesPercentage +
                '}';
    }
}
