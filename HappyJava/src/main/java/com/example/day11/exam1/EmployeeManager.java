package com.example.day11.exam1;

import java.util.HashSet;

public class EmployeeManager {
    private final HashSet<Employee> employees;

    public EmployeeManager() {
        employees = new HashSet<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee findEmployee(String id) {
        for (Employee employee : employees) {
            if(employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public String toString() {
        return "employees=" + employees;
    }
}
