package org.informatics;

public class Edition {
    private Publication publication;
    private int copiesPrinted;
    private boolean isColorPrint;

    public Edition(Publication publication, int copiesPrinted, boolean isColorPrint) {
        if (copiesPrinted <= 0) {
            throw new IllegalArgumentException("Number of printed copies must be positive.");
        }

        this.publication = publication;
        this.copiesPrinted = copiesPrinted;
        this.isColorPrint = isColorPrint;
    }

    public Publication getPublication() {
        return publication;
    }

    public int getCopiesPrinted() {
        return copiesPrinted;
    }

    public boolean isColorPrint() {
        return isColorPrint;
    }

    public double getCostPerSheet() {
        return publication.getPaperType().getBasePriceForA5() * publication.getPageSize().getPriceMultiplier();
    }

    public int getTotalPagesPrinted() {
        return copiesPrinted;
    }

    public double getTotalPaperCost() {
        return getCostPerSheet() * getTotalPagesPrinted();
    }

    @Override
    public String toString() {
        return String.format("Edition of '%s' - printed %d copies, %s print",
                publication.getTitle(), copiesPrinted, isColorPrint ? "Color" : "Black & White");
    }
}