
import static org.junit.jupiter.api.Assertions.*;

import org.informatics.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class EmployeeSerializerTest {

    private List<Employee> employees;
    private final String filename = "test_employees.ser";

    @BeforeEach
    void setUp() {
        employees = new ArrayList<>();
        employees.add(new Operator("Test Operator", 1000.0));
        employees.add(new Manager("Test Manager", 2000.0, 15.0, 5000.0));
    }

    @Test
    void testSerializationAndDeserialization() throws EmployeeSerializationException {
        EmployeeSerializer.serializeEmployees(employees, filename);
        List<Employee> deserialized = EmployeeSerializer.deserializeEmployees(filename);

        assertNotNull(deserialized);
        assertEquals(2, deserialized.size());
        assertEquals("Test Operator", deserialized.get(0).getName());
        assertEquals("Test Manager", deserialized.get(1).getName());
    }

    @Test
    void testSerializationThrowsExceptionOnEmptyList() {
        Exception exception = assertThrows(EmployeeSerializationException.class, () -> {
            EmployeeSerializer.serializeEmployees(new ArrayList<>(), filename);
        });

        String expectedMessage = "No list of employees was provided for serialization.";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    void testDeserializationThrowsExceptionOnMissingFile() {
        Exception exception = assertThrows(EmployeeSerializationException.class, () -> {
            EmployeeSerializer.deserializeEmployees("non_existing_file.ser");
        });

        String expectedMessage = "does not exist";
        assertTrue(exception.getMessage().toLowerCase().contains(expectedMessage));
    }

    @AfterEach
    void cleanUp() {
        File file = new File(filename);
        if (file.exists()) {
            file.delete();
        }
    }
}