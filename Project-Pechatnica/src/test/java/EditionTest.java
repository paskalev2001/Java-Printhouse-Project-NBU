import org.informatics.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EditionTest {

    private Publication publication;

    @BeforeEach
    void setUp() {
        publication = new Publication("Sample Title", 100, PageSize.A4, PaperType.GLOSSY, true, 2.5);
    }

    @Test
    void testValidEditionCreation() {
        Edition edition = new Edition(publication, 50, true);
        assertEquals(publication, edition.getPublication());
        assertEquals(50, edition.getCopiesPrinted());
        assertTrue(edition.isColorPrint());
    }

    @Test
    void testInvalidCopiesThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Edition(publication, 0, true);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Edition(publication, -10, false);
        });
    }

    @Test
    void testGetCostPerSheet() {
        Edition edition = new Edition(publication, 10, false);
        double expectedCost = PaperType.GLOSSY.getBasePriceForA5() * PageSize.A4.getPriceMultiplier();
        assertEquals(expectedCost, edition.getCostPerSheet(), 0.0001);
    }

    @Test
    void testTotalPagesPrinted() {
        Edition edition = new Edition(publication, 75, false);
        assertEquals(75, edition.getTotalPagesPrinted());
    }

    @Test
    void testTotalPaperCost() {
        Edition edition = new Edition(publication, 10, false);
        double expectedCost = edition.getCostPerSheet() * 10;
        assertEquals(expectedCost, edition.getTotalPaperCost(), 0.0001);
    }

    @Test
    void testToStringRepresentation() {
        Edition edition = new Edition(publication, 20, true);
        String result = edition.toString();
        assertTrue(result.contains("Sample Title"));
        assertTrue(result.contains("printed 20 copies"));
        assertTrue(result.contains("Color"));
    }
}