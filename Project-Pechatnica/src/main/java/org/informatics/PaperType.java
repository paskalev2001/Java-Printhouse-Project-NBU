package org.informatics;

public enum PaperType {
    NORMAL(0.10),
    GLOSSY(0.15),
    NEWSPAPER(0.08),
    RICE(0.05);

    private final double basePriceForA5;

    PaperType(double basePriceForA5) {
        this.basePriceForA5 = basePriceForA5;
    }

    public double getBasePriceForA5() {
        return basePriceForA5;
    }
}