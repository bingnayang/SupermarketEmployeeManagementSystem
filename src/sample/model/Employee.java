package sample.model;

public class Employee {
    private int employee_Id;
    private String first_Name;
    private String last_Name;
    private int title_Id;
    private double salary;
    private String startDate;
    private String endDate;
    private int employmentStatus_Id;

    public int getEmployee_Id() {
        return employee_Id;
    }

    public void setEmployee_Id(int employee_Id) {
        this.employee_Id = employee_Id;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public int getTitle_Id() {
        return title_Id;
    }

    public void setTitle_Id(int title_Id) {
        this.title_Id = title_Id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getEmploymentStatus_Id() {
        return employmentStatus_Id;
    }

    public void setEmploymentStatus_Id(int employmentStatus_Id) {
        this.employmentStatus_Id = employmentStatus_Id;
    }
}
