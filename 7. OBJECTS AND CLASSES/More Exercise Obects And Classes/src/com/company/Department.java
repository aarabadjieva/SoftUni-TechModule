package com.company;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;

    private List<Employee> employees;

    public Department() {
        this.employees = new ArrayList<>();
    }
    public Department(String name) {
        this();
        this.name = name;
    }
    public void addEmployee(Employee employee){
       this.employees.add(employee);
    }
    public double getAverage(){
        double all = 0;
        if (employees.isEmpty()){
            return 0;
        }
        for (Employee e:this.employees
             ) {
            all+=e.getSalary();
        }
        double average = all/this.employees.size();
        return average;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmployees(List<Employee> employees){
        this.employees = employees;
    }
    public List<Employee> getEmployees(){
        return employees;
    }
}
