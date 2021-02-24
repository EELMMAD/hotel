package se.lexicon.groupProject.hotel.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {
    Booking testObject;
    @BeforeEach
    void setUp() {
        testObject = new Booking(LocalDate.of(2020,2,2), "singleRoom", "3 nights" );
    }

    @Test
    void successfully_created() {

        assertNotNull(testObject);
       // Ask to be sure from Erik
        assertNotEquals("Null", testObject.getBookingId());

        assertEquals("singleRoom", testObject.bookingTitle);
        assertEquals("3 nights" , testObject.bookingDescription);
        assertEquals(LocalDate.of(2020,2,2), testObject.getBookingDate());
    }

    @Test
    void testEquals() {
        Booking copy = new Booking(LocalDate.of(2020,2,2), "singleRoom", "3 nights" );
        assertTrue(testObject.equals(copy));
    }

    @Test
    void testHashCode() {
        Booking copy = new Booking(LocalDate.of(2020,2,2), "singleRoom", "3 nights" );
        assertEquals(copy.hashCode(), testObject.hashCode());    }

    @Test
    void testToString() {
        String toString = testObject.toString();
        assertTrue(toString.contains("0"));
        assertTrue(toString.contains(testObject.getBookingDescription()));
        assertTrue(toString.contains(testObject.getBookingTitle()));
    }
}