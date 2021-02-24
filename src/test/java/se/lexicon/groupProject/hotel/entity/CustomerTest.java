package se.lexicon.groupProject.hotel.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    Customer testObject;

    @BeforeEach
    void setUp() {
//        testObject = new Customer("Negar", "Madadi", "negar.madadi@gmail.com");
    }

    @Test
    void successfully_created(){
        assertNotNull(testObject);

        assertNotEquals("Null", testObject.getCustomerId());

        assertEquals("Negar", testObject.getCustomerFirstName());
        assertEquals("Madadi", testObject.getCustomerLastName());
        assertEquals("negar.madadi@gmail.com", testObject.getCustomerEmail());
    }

    @Test
    void testEquals() {
//       Customer copy = new Customer("Negar", "Madadi", "negar.madadi@gmail.com");
//       assertTrue(testObject.equals(copy));
    }

    @Test
    void testHashcode() {
//        Customer copy = new Customer("Negar", "Madadi", "negar.madadi@gmail.com");
//        assertEquals(copy.hashCode(), testObject.hashCode());
    }

    @Test
    void testToString() {
        String toString = testObject.toString();
       // assertTrue(toString.contains("0"));
        assertTrue(toString.contains(testObject.getCustomerFirstName()));
        assertTrue(toString.contains(testObject.getCustomerLastName()));
        assertTrue(toString.contains(testObject.getCustomerEmail()));


    }
}