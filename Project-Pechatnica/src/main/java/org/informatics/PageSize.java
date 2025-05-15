package org.informatics;

public enum PageSize {
    A5(1.0),
    A4(1.2),
    A3(1.5),
    A2(1.8),
    A1(2.0);

    private final double priceMultiplier;

    PageSize(double priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }

    public double getPriceMultiplier() {
        return priceMultiplier;
    }
}
