package curihous.ifit.codetest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class TestServiceTest {
    
    private TestService service;
    
    @BeforeEach
    void setUp() {
        service = new TestService();
    }
    
    @Test
    void testProcessData() {
        String result = service.processData("TEST DATA");
        assertEquals("test data", result);
    }
    
    @Test
    void testProcessDataWithNull() {
        String result = service.processData(null);
        assertNull(result);
    }
    
    @Test
    void testProcessDataWithEmptyString() {
        String result = service.processData("");
        assertEquals("", result);
    }
    
    @Test
    void testValidateInput() {
        assertTrue(service.validateInput("valid data"));
        assertFalse(service.validateInput(null));
        assertFalse(service.validateInput(""));
        assertFalse(service.validateInput("   "));
    }
    
    @Test
    void testGetDataCount() {
        assertEquals(0, service.getDataCount());
        service.processData("test");
        assertEquals(1, service.getDataCount());
    }
    
    @Test
    void testGetDataAtInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            service.getDataAt(0);
        });
    }
}
