package se.lexicon.groupProject.hotel.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import se.lexicon.groupProject.hotel.dto.BookingDTO;
import se.lexicon.groupProject.hotel.dto.CustomerDTO;
import se.lexicon.groupProject.hotel.dto.RoomDTO;
import se.lexicon.groupProject.hotel.entity.Booking;
import se.lexicon.groupProject.hotel.entity.Customer;
import se.lexicon.groupProject.hotel.entity.Room;
import se.lexicon.groupProject.hotel.repository.BookingRepository;
import se.lexicon.groupProject.hotel.repository.CustomerRepository;
import se.lexicon.groupProject.hotel.repository.RoomRepository;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BookingServiceImplTest {
    BookingServiceImpl testObject;
    RoomServiceImpl testObject2;
    CustomerServiceImpl testObject3;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    RoomRepository roomRepository;
    Booking booking2;
    Booking booking1;
    Customer customer1;
    Customer customer2;
    Room room1;
    Room room2;
    BookingDTO bookingDTO1 = new BookingDTO();
    BookingDTO bookingDTO2 = new BookingDTO();
    CustomerDTO customerDTO1 = new CustomerDTO();
    CustomerDTO customerDTO2 = new CustomerDTO();
    RoomDTO roomDTO1 = new RoomDTO();
    RoomDTO roomDTO2 = new RoomDTO();

    @BeforeEach
    void setUp() {
        testObject = new BookingServiceImpl(bookingRepository, customerRepository, roomRepository);
        testObject2 = new RoomServiceImpl();
        testObject3 = new CustomerServiceImpl(customerRepository);
        booking1 = new Booking(LocalDate.now(), "test1", "test1");
        booking2 = new Booking(LocalDate.now(), "test2", "test2");
        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        customer1 = new Customer("elmira", "madadi", "elmiramadadi@gmail.com", LocalDate.now());
        customer2 = new Customer("elmira", "madadi", "elmiramadadi@gmail.com", LocalDate.now());
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        room1 = new Room("1", "one", "vip room", "descripton test", true);
        room2 = new Room("1", "one", "vip room", "descripton test", true);
        roomRepository.save(room2);
        roomRepository.save(room1);
    }

    @Test
    void getCustomer() {
        assertNotNull(customer1);
        assertNotNull(customerDTO1);
        assertNotNull(customer2);
        assertNotNull(customerDTO2);
        assertNotNull(room1);
        assertNotNull(roomDTO1);
        assertNotNull(room2);
        assertNotNull(roomDTO2);
        assertNotNull(booking1);
        assertNotNull(bookingDTO1);
        assertNotNull(booking2);
        assertNotNull(bookingDTO2);
    }

    @Test
    void getRoom() {

    }


    @Test
    void findByBookingId() {
        assertEquals(bookingDTO1, testObject.findById(bookingDTO1.getBookingId()));
        assertEquals(bookingDTO2, testObject.findById(bookingDTO2.getBookingId()));
        assertEquals(customerDTO1, testObject.findById(customerDTO1.getCustomerId()));
        assertEquals(customerDTO2, testObject.findById(customerDTO2.getCustomerId()));
        assertEquals(roomDTO1, testObject.findById(roomDTO1.getRoomId()));
        assertEquals(roomDTO2, testObject.findById(roomDTO2.getRoomId()));


    }

    @Test
    void findAll() {
        assertEquals(2, testObject.findAll().size());
        assertTrue(testObject.findAll().contains(bookingDTO1));
        assertTrue(testObject.findAll().contains(bookingDTO2));
        assertTrue(testObject.findAll().contains(roomDTO1));
        assertTrue(testObject.findAll().contains(roomDTO2));
        assertTrue(testObject.findAll().contains(customerDTO1));
        assertTrue(testObject.findAll().contains(customerDTO2));
    }

    @Test
    void create() {
        BookingDTO bookingDTO3 = new BookingDTO();
        bookingDTO3.setBookingTitle("Literature");
        bookingDTO3.setBookingDescription("description test");
        bookingDTO3.setBookingDate(LocalDate.now());
        bookingDTO3 = testObject.create(bookingDTO3);
        assertEquals(3, testObject.findAll().size());
        assertTrue(testObject.findAll().contains(bookingDTO3));
        assertEquals(3, bookingDTO3.getBookingId());
        assertTrue(testObject.findAll().contains(bookingDTO3));
        CustomerDTO customerDTO3 = new CustomerDTO();
        customerDTO3.setAvailable(true);
        customerDTO3.setFirstName("elmira");
        customerDTO3.setBookingDate(LocalDate.now());
        customerDTO3.setEmail("elmiramadadi@gmail.com");
        customerDTO3.setLastName("madadi");
        assertTrue(testObject2.findAll().contains(customerDTO3));
        assertEquals(3, testObject.findAll().size());
        assertTrue(testObject.findAll().contains(customerDTO3));
        assertEquals(3, customerDTO3.getCustomerId());
        assertTrue(testObject.findAll().contains(customerDTO3));
        RoomDTO roomDTO3 = new RoomDTO();
        roomDTO3.setRoomDescription("description room");
        roomDTO3.setRoomNumber("1010");
        roomDTO3.setRoomType("vip");
        assertTrue(testObject3.findAll().contains(roomDTO3));
        assertEquals(3, testObject.findAll().size());
        assertTrue(testObject.findAll().contains(roomDTO3));
        assertEquals(3, roomDTO3.getRoomId());
        assertTrue(testObject.findAll().contains(roomDTO3));

    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}