package se.lexicon.groupProject.hotel.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.groupProject.hotel.entity.Booking;
import se.lexicon.groupProject.hotel.entity.Hotel;
import se.lexicon.groupProject.hotel.entity.Room;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RoomRepositoryTest {

    Room testObject;

    @Autowired
    RoomRepository roomRepository;

    @BeforeEach
    void setUp() {
       // roomRepository.save(new Room("3d", "First Type", "Good Room", true, BigDecimal.valueOf(50));
      //  roomRepository.save(new Room("4a", "Second Type", "Nice Room"));
       // roomRepository.save(new Room("2b", "Third Type", "Best Room"));
    }

    @Test
    void successfullyCreated() {
        assertEquals(3, roomRepository.findAll().size());
    }

    @Test
    void findAllByRoomNumberContainingIgnoreCase() {
        //Arrange
        String search = "4a";

        //Act
//        List<Room> foundRoomMatchingSearch= roomRepository.findAllByRoomNumberContainingIgnoreCase(search);

        //Assert
//        assertNotNull(foundRoomMatchingSearch);
//        assertFalse(foundRoomMatchingSearch.isEmpty());
//        assertEquals(1, foundRoomMatchingSearch.size());

    }


    @Test
    void findAllByRoomTypeContainingIgnoreCase() {
        //Arrange
        String search = "THIRD TYPE";

        //Act
//        List<Room> foundRoomMatchingSearch= roomRepository.findAllByRoomTypeContainingIgnoreCase(search);

        //Assert
//        assertNotNull(foundRoomMatchingSearch);
//        assertFalse(foundRoomMatchingSearch.isEmpty());
//        assertEquals(1, foundRoomMatchingSearch.size());
    }

    //test nashode
    @Test
    void findAllByAvailable() {
//        List<Room> foundRooms = roomRepository.findAllByAvailable(true);
//        assertEquals(1, foundRooms.size());
      //  assertTrue(roomRepository.equals(foundRooms.get(0)));
    }
}