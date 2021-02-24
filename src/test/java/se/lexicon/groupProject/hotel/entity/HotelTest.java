package se.lexicon.groupProject.hotel.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HotelTest {
    Hotel testObject;

    @BeforeEach
    void setUp() {
     testObject = new Hotel("5 star", "London E14 8DS",
             "place where many have found its sense of calm transforms the way they feel");
    }

    @Test
    void successfully_created(){
        assertNotNull(testObject);
        assertNotEquals("Null", testObject.getHotelId());
        assertEquals("5 star", testObject.getHotelType());
        assertEquals("London E14 8DS", testObject.getHotelAddress());
        assertEquals("place where many have found its sense of calm transforms the way they feel",
                     testObject.getHotelDescription());
    }

    @Test
    void testEquals() {
        Hotel copy = new Hotel("5 star", "London E14 8DS",
                "place where many have found its sense of calm transforms the way they feel");

        assertTrue(testObject.equals(copy));
    }

    @Test
    void testHashcode() {
        Hotel copy = new Hotel("5 star", "London E14 8DS",
                "place where many have found its sense of calm transforms the way they feel");
        assertEquals(copy.hashCode(), testObject.hashCode());
    }

    @Test
    void testToString() {
        String toString = testObject.toString();
        assertTrue(toString.contains("null"));
        assertTrue(toString.contains("5 star"));
        assertTrue(toString.contains("London E14 8DS"));
        assertTrue(toString.contains(
                "place where many have found its sense of calm transforms the way they feel" ));
    }
}