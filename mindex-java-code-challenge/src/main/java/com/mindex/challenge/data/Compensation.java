package com.mindex.challenge.data;

public class Compensation {

    private String compensationId;
    private Employee employee = new Employee();
    private int salary;
    private String effectiveDate;

    public Compensation() {
        
    }

    public String getCompensationId(){
        return compensationId;
    }

    public void setCompensationId(String compensationId){
        this.compensationId = compensationId;
    }

    public Employee getEmployee(){
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getSalary(){
        return salary;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public void setDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getDate() {
        return effectiveDate;
    }
}
