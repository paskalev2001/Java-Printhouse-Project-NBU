package org.informatics;

import java.io.Serializable;

public class Operator extends Employee  implements Serializable {

    public Operator(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary(double totalIncome) {
        return getBaseSalary();
    }

    @Override
    public String toString() {
        return "Operator{" + "name='" + getName() + "', baseSalary=" + getBaseSalary() + "}";
    }
}