package org.informatics;

import java.util.HashMap;
import java.util.Map;

public class PrintingMachine {
    private final String id;
    private final boolean isColorCapable;
    private final int maxPaperCapacity;
    private final int pagesPerMinute;
    private int currentPaperLoaded;
    private final Map<Edition, Integer> printedEditions;

    public PrintingMachine(String id, boolean isColorCapable, int maxPaperCapacity, int pagesPerMinute) {
        this.id = id;
        this.isColorCapable = isColorCapable;
        this.maxPaperCapacity = maxPaperCapacity;
        this.pagesPerMinute = pagesPerMinute;
        this.currentPaperLoaded = 0;
        this.printedEditions = new HashMap<>();
    }

    public void loadPaper(int sheets) {
        if (sheets <= 0) {
            throw new IllegalArgumentException("Cannot load zero or negative sheets.");
        }
        if (currentPaperLoaded + sheets > maxPaperCapacity) {
            throw new IllegalArgumentException("Exceeds machine's paper capacity.");
        }
        currentPaperLoaded += sheets;
    }

    public void printEdition(Edition edition) {
        if (edition.isColorPrint() && !isColorCapable) {
            throw new UnsupportedOperationException("This machine cannot print in color.");
        }

        int requiredSheets = edition.getTotalPagesPrinted();

        if (requiredSheets > currentPaperLoaded) {
            throw new IllegalStateException("Not enough paper loaded to print this edition.");
        }

        currentPaperLoaded -= requiredSheets;
        printedEditions.merge(edition, edition.getCopiesPrinted(), Integer::sum);
        System.out.printf("Machine %s printed %d copies of '%s'%n", id, edition.getCopiesPrinted(), edition.getPublication().getTitle());
    }

    public int getTotalPagesPrinted() {
        return printedEditions.entrySet()
                .stream()
                .mapToInt(e -> e.getKey().getCopiesPrinted())
                .sum();
    }

    public int getCurrentPaperLoaded() {
        return currentPaperLoaded;
    }

    public String getId() {
        return id;
    }

    public boolean isColorCapable() {
        return isColorCapable;
    }

    public int getMaxPaperCapacity() {
        return maxPaperCapacity;
    }

    public int getPagesPerMinute() {
        return pagesPerMinute;
    }

    public Map<Edition, Integer> getPrintedEditions() {
        return printedEditions;
    }

    @Override
    public String toString() {
        return "PrintingMachine{" +
                "id='" + id + '\'' +
                ", colorCapable=" + isColorCapable +
                ", maxCapacity=" + maxPaperCapacity +
                ", loaded=" + currentPaperLoaded +
                ", pages/min=" + pagesPerMinute +
                '}';
    }
}
