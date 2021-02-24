package se.lexicon.groupProject.hotel.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.groupProject.hotel.entity.Booking;
import se.lexicon.groupProject.hotel.entity.Customer;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {
Customer testObject;

@Autowired
CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerRepository.save(new Customer("Elmira", "Madadi", "elmiramadadi@gmail.com",LocalDate.now() ));
        customerRepository.save(new Customer("Negar", "Madadi", "negarmadadi@gmail.com", LocalDate.now()));
        customerRepository.save(new Customer("Lena", "Sadr", "lenasadr.gmai.com", LocalDate.now()));
    }
    @Test
    void successfullyCreated() {
        assertEquals(3, customerRepository.findAll().size());
    }

    @Test
    void findAllByCustomerFirstNameIgnoreCase() {
        //Arrange
        String search = "NEGAR";

        //Act
        List<Customer> foundCustomerMatchingSearch = customerRepository.findAllByCustomerFirstNameContainingIgnoreCase(search);

        //Assert
        assertNotNull(foundCustomerMatchingSearch);
       assertFalse(foundCustomerMatchingSearch.isEmpty());
        assertEquals(1, foundCustomerMatchingSearch.size());
        // assertTrue(foundCustomerMatchingSearch.contains(testObject));
    }

    @Test
    void findAllByCustomerLastNameContainingIgnoreCase() {
        //Arrange
        String search = "SADR";

        //Act
        List<Customer> foundCustomerMatchingSearch = customerRepository.findAllByCustomerLastNameContainingIgnoreCase(search);

        //Assert
        assertNotNull(foundCustomerMatchingSearch);
        assertFalse(foundCustomerMatchingSearch.isEmpty());
        assertEquals(1, foundCustomerMatchingSearch.size());
    }

    @Test
    void findAllByCustomerEmailIgnoreCase() {
        //Arrange
        String search = "ELMIRAMADADI";

        //Act
        List<Customer> foundCustomerMatchingSearch = customerRepository.findAllByCustomerEmailContainingIgnoreCase(search);

        //Assert
        assertNotNull(foundCustomerMatchingSearch);
        assertFalse(foundCustomerMatchingSearch.isEmpty());
        assertEquals(1, foundCustomerMatchingSearch.size());
    }
}