import org.informatics.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PublicationTest {

    private Publication publication;

    @BeforeEach
    void setUp() {
        publication = new Publication("Test Book", 200, PageSize.A4, PaperType.NORMAL, true, 3.50);
    }

    @Test
    void testGetters() {
        assertEquals("Test Book", publication.getTitle());
        assertEquals(200, publication.getNumberOfCopies());
        assertEquals(PageSize.A4, publication.getPageSize());
        assertEquals(PaperType.NORMAL, publication.getPaperType());
        assertTrue(publication.isColor());
        assertEquals(3.50, publication.getPricePerCopy());
    }

    @Test
    void testSetPricePerCopy() {
        publication.setPricePerCopy(4.25);
        assertEquals(4.25, publication.getPricePerCopy());
    }

    @Test
    void testCalculateTotalIncome() {
        double expectedIncome = 200 * 3.50;
        assertEquals(expectedIncome, publication.calculateTotalIncome(), 0.0001);
    }

    @Test
    void testToStringContainsExpectedData() {
        String result = publication.toString();
        assertTrue(result.contains("Test Book"));
        assertTrue(result.contains("200"));
        assertTrue(result.contains("A4"));
        assertTrue(result.contains("NORMAL"));
        assertTrue(result.contains("true"));
        assertTrue(result.contains("3.5"));
    }
}