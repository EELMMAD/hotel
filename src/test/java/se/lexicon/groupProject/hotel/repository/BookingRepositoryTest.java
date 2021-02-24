package se.lexicon.groupProject.hotel.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.groupProject.hotel.entity.Booking;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookingRepositoryTest {

    Booking testObject;

    @Autowired
    BookingRepository bookingRepository;

    @BeforeEach
    void setUp() {
        // Booking booking1 = new Booking(LocalDate.of(2012, 05, 03), "My room title 3", "booking description 1");
        //Booking booking2 = new Booking(LocalDate.of(2013, 06, 22), "My room title 2", "booking description 2");
        //Booking booking3 = new Booking(LocalDate.of(2015, 05, 03), "my room title 3", "booking description 3");

        bookingRepository.save(new Booking(LocalDate.of(2012, 05, 03), "My room title 3", "booking description 1"));
        bookingRepository.save(new Booking(LocalDate.of(2013, 06, 22), "My room title 2", "booking description 2"));
        bookingRepository.save(new Booking(LocalDate.of(2015, 05, 03), "my room title 3", "booking description 3"));
    }


    @Test
    void successfullyCreated() {
        assertEquals(3, bookingRepository.findAll().size());
    }

    /*
    @Test
    void findAllByBookingDate() {

    }

     */

    @Test
    void findAllByBookingTitleContainingIgnoreCase() {
        //Arrange
        String search = "TiTLE ";

        //Act
//        List<Booking> foundBookingMatchingSearch = bookingRepository.findAllByBookingTitleContainingIgnoreCase(search);

        //Assert
//        assertNotNull(foundBookingMatchingSearch);
//        assertFalse(foundBookingMatchingSearch.isEmpty());
//        assertEquals(3, foundBookingMatchingSearch.size());
       // assertTrue(foundBookingMatchingSearch.contains(testObject));
    }
}