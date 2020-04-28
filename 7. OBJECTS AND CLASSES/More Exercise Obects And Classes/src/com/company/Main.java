package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Department> departments = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            Employee employee = new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3]);
            if (input.length == 5) {
                if (input[4].contains("@")) {
                    employee.setEmail(input[4]);
                } else {
                    employee.setAge(Integer.parseInt(input[4]));
                }
            } else if (input.length == 6) {
                employee.setEmail(input[4]);
                employee.setAge(Integer.parseInt(input[5]));
            }
            if (!departments.containsKey(input[3])) {
                departments.put(input[3],new Department(input[3]));
            }
            departments.get(input[3]).addEmployee(employee);
        }
        Department bestDepartment = new Department();
        for (Map.Entry<String,Department> departmentEntry:departments.entrySet()
             ) {
            if (departmentEntry.getValue().getAverage()>bestDepartment.getAverage()){
                bestDepartment.setName(departmentEntry.getValue().getName());
                bestDepartment.setEmployees(departmentEntry.getValue().getEmployees());
            }
        }
        System.out.println("Highest Average Salary: "+ bestDepartment.getName());
        bestDepartment.getEmployees().stream().sorted((e1,e2)->{
            int higher = Double.compare(e2.getSalary(),e1.getSalary());
            return higher;
        }).forEach(employee -> System.out.println(employee.toString()));
    }
}
