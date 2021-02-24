package se.lexicon.groupProject.hotel.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.groupProject.hotel.dto.BookingDTO;
import se.lexicon.groupProject.hotel.entity.Booking;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends CrudRepository<Booking, String> {
    List<Booking> findAll();
   // List<Booking> findAllByBookingDate(LocalDate bookingDate);


    Booking findBookingWithId(int bookingId);

}
