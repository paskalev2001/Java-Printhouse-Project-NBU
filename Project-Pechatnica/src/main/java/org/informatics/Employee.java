package org.informatics;

import java.io.Serializable;

public abstract class Employee implements Serializable {
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public abstract double calculateSalary(double totalIncome);

    @Override
    public String toString() {
        return "Employee{name='" + name + "', baseSalary=" + baseSalary + "}";
    }
}
