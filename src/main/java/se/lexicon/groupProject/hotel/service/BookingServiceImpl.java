package se.lexicon.groupProject.hotel.service;

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

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class BookingServiceImpl implements BookingService {
    //////////////
    BookingRepository bookingRepository;
    CustomerRepository customerRepository;
    RoomRepository roomRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepo, CustomerRepository customerRepo, RoomRepository roomRepo) {
        this.bookingRepository = bookingRepo;
        this.customerRepository = customerRepo;
        this.roomRepository = roomRepo;
    }

    @Transactional
    public Customer getCustomer(CustomerDTO customerDTO) {

        return customerRepository.findByCustomerId(customerDTO.getCustomerId());
    }

    @Transactional
    public Room getRoom(RoomDTO roomDTO) {
        return roomRepository.findById(roomDTO.getRoomId()).orElseThrow(() -> new IllegalArgumentException("Room does not exist"));
    }

    @Override
    public BookingDTO findById(String bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new RuntimeException(
                bookingId + " id does not match with and Booking"));
        return new BookingDTO(booking);
    }

    @Override
    public BookingDTO findByBookingId(int bookId) {
        Booking foundItems = bookingRepository.findBookingWithId(bookId);
        return BookingDTO.toBookingDto(foundItems);
    }


    @Override
    public List<BookingDTO> findAll() {
        List<Booking> foundItems = bookingRepository.findAll();
        return BookingDTO.toBookingDTO(foundItems);
    }

    @Override
    public BookingDTO create(BookingDTO bookingDTO) {
        if (bookingDTO.getBookingId() == "0" || bookingDTO.getBookingId().equals(""))
            throw new RuntimeException("booking id is invalid");
        bookingRepository.findBookingWithId(Integer.parseInt(bookingDTO.getBookingId()));
        Booking booking = new Booking(bookingDTO.getBookingDate(), bookingDTO.getBookingTitle(), bookingDTO.getBookingDescription());
        return new BookingDTO(bookingRepository.save(booking));
    }

    @Override
    public BookingDTO update(BookingDTO bookingDTO) {
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingDTO.getBookingId());
        if (!optionalBooking.isPresent())
            throw new RuntimeException("customer doesn't exist");
        Booking toUpdated = new Booking(optionalBooking.get().getBookingDate() ,optionalBooking.get().getBookingTitle() ,optionalBooking.get().getBookingDescription());
        if (!toUpdated.getBookingId().equals(bookingDTO.getBookingTitle()))
            toUpdated.setBookingTitle(bookingDTO.getBookingTitle());
        if (toUpdated.getBookingDescription() != bookingDTO.getBookingDescription())
            toUpdated.setBookingDescription(bookingDTO.getBookingDescription());
        if (toUpdated.getBookingDate() != bookingDTO.getBookingDate())
            toUpdated.setBookingDate(bookingDTO.getBookingDate());
        return new BookingDTO(bookingRepository.save(toUpdated));
    }

    @Override
    public boolean delete(String bookingId) {

        if (!bookingRepository.findById(bookingId).isPresent())
            throw new RuntimeException("There is no booking with id: " + bookingId);
        boolean deleted = false;
        if (bookingRepository.existsById(bookingId)) {
            bookingRepository.delete(bookingRepository.findById(bookingId).get());
            deleted = true;
        }
        return deleted;
    }
}
