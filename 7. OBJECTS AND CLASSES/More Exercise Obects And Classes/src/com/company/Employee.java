package com.company;

public class Employee {
    private String name;
    private Double salary;
    private String position;
    private String department;
    private String email = "n/a";
    private int age = -1;

    public Employee(String name, Double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public void setAge(int age){
        this.age = age;
    }
    public double getSalary(){
        return salary;
    }
    public String getName(){
        return name;
    }
    public String getPosition(){
        return position;
    }
    public String getDepartment(){
        return department;
    }
    public String getEmail(){
        return email;
    }
    public int getAge(){
        return age;
    }
    public String toString(){
        return String.format("%s %.2f %s %d"
                ,getName(),getSalary(),getEmail(),getAge());
    }
}
