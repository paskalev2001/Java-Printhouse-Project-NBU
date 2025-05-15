package org.informatics;

import java.io.Serializable;

public class Manager extends Employee implements Serializable {
    private double bonusPercentage;
    private double incomeThreshold; // праг за бонус

    public Manager(String name, double baseSalary, double bonusPercentage, double incomeThreshold) {
        super(name, baseSalary);
        this.bonusPercentage = bonusPercentage;
        this.incomeThreshold = incomeThreshold;
    }

    @Override
    public double calculateSalary(double totalIncome) {
        if (totalIncome > incomeThreshold) {
            return getBaseSalary() + (getBaseSalary() * bonusPercentage / 100);
        } else {
            return getBaseSalary();
        }
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + getName() + '\'' +
                ", baseSalary=" + getBaseSalary() +
                ", bonusPercentage=" + bonusPercentage +
                ", incomeThreshold=" + incomeThreshold +
                '}';
    }
}
