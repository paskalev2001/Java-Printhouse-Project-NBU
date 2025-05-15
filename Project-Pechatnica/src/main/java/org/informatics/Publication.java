package org.informatics;

public class Publication {
    private String title;
    private int numberOfCopies;
    private PageSize pageSize;
    private PaperType paperType;
    private boolean isColor;
    private double pricePerCopy;

    public Publication(String title, int numberOfCopies, PageSize pageSize, PaperType paperType, boolean isColor, double pricePerCopy) {
        this.title = title;
        this.numberOfCopies = numberOfCopies;
        this.pageSize = pageSize;
        this.paperType = paperType;
        this.isColor = isColor;
        this.pricePerCopy = pricePerCopy;
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public PageSize getPageSize() {
        return pageSize;
    }

    public PaperType getPaperType() {
        return paperType;
    }

    public boolean isColor() {
        return isColor;
    }

    public double getPricePerCopy() {
        return pricePerCopy;
    }

    public void setPricePerCopy(double pricePerCopy) {
        this.pricePerCopy = pricePerCopy;
    }

    public double calculateTotalIncome() {
        return numberOfCopies * pricePerCopy;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "title='" + title + '\'' +
                ", numberOfCopies=" + numberOfCopies +
                ", pageSize=" + pageSize +
                ", paperType=" + paperType +
                ", isColor=" + isColor +
                ", pricePerCopy=" + pricePerCopy +
                '}';
    }
}