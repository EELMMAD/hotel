package se.lexicon.groupProject.hotel.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.groupProject.hotel.entity.Customer;
import se.lexicon.groupProject.hotel.entity.Hotel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class HotelRepositoryTest {


    @Autowired
    HotelRepository hotelRepository;

    @BeforeEach
    void setUp() {
        hotelRepository.save(new Hotel("3 star", "My first address", "Description one"));
        hotelRepository.save(new Hotel("4 star", "My second address", "Description two"));
        hotelRepository.save(new Hotel("5 star", "My third address", "Description three"));
    }
    @Test
    void successfullyCreated() {
        assertEquals(3, hotelRepository.findAll().size());
    }

    @Test
    void findAllByHotelAddressContainingIgnoreCase() {
        //Arrange
        String search = "THIRD address";

        //Act
        List<Hotel> foundHotelMatchingSearch = hotelRepository.findAllByHotelAddressContainingIgnoreCase(search);

        //Assert
        assertNotNull(foundHotelMatchingSearch);
        assertFalse(foundHotelMatchingSearch.isEmpty());
        assertEquals(1, foundHotelMatchingSearch.size());
    }




    @Test
    void findAllByHotelDescriptionContainingIgnoreCase() {
        //Arrange
        String search = "TWO";

        //Act
        List<Hotel> foundHotelMatchingSearch = hotelRepository.findAllByHotelDescriptionContainingIgnoreCase(search);

        //Assert
        assertNotNull(foundHotelMatchingSearch);
        assertFalse(foundHotelMatchingSearch.isEmpty());
        assertEquals(1, foundHotelMatchingSearch.size());
    }
}