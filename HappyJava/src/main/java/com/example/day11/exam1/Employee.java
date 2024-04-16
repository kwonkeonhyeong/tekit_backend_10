package com.example.day11.exam1;

import java.util.Objects;

public class Employee {
    private String name;
    private String id;
    private String department;

    public Employee(String name, String id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "[" + name + ',' + id + ',' + department +
                "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee employee)) {
            return false;
        }
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
