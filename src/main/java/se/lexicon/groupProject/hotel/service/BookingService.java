package se.lexicon.groupProject.hotel.service;

import se.lexicon.groupProject.hotel.entity.Booking;
import se.lexicon.groupProject.hotel.dto.BookingDTO;

import java.util.List;

public interface BookingService {
    BookingDTO findById(String loanId);

    BookingDTO findByBookingId(int bookId);



    List<BookingDTO> findAll();

    BookingDTO create(BookingDTO bookingDTO);

    BookingDTO update(BookingDTO bookingDTO);

    boolean delete(String bookingId);
}
