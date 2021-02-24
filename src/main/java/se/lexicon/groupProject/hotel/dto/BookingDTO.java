package se.lexicon.groupProject.hotel.dto;

import se.lexicon.groupProject.hotel.entity.Booking;
import se.lexicon.groupProject.hotel.entity.Customer;
import se.lexicon.groupProject.hotel.entity.Hotel;
import se.lexicon.groupProject.hotel.entity.Room;
import se.lexicon.groupProject.hotel.repository.BookingRepository;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingDTO implements Serializable {

    private String bookingId;

    @NotNull(message = "Required field")
    @PastOrPresent(message = "bookingDate cannot be in the past")
    private LocalDate bookingDate;

    @NotBlank(message = "Required field")
    @Size(min = 2, max = 255, message = "Need to have at least 2 letters")
    private String bookingTitle;

    @NotBlank(message = "Required field")
    @Size(min = 2, max = 255, message = "Need to have at least 2 letters")
    private String bookingDescription;

    public BookingDTO() {
    }

    public BookingDTO(@NotNull(message = "Required field") @PastOrPresent(message = "bookingDate cannot be in the past") LocalDate bookingDate, @NotBlank(message = "Required field") @Size(min = 2, max = 255, message = "Need to have at least 2 letters") String bookingTitle, @NotBlank(message = "Required field") @Size(min = 2, max = 255, message = "Need to have at least 2 letters") String bookingDescription) {
        this.bookingDate = bookingDate;
        this.bookingTitle = bookingTitle;
        this.bookingDescription = bookingDescription;
    }

    public BookingDTO(Booking booking) {
        setBookingDate(booking.getBookingDate());
        setBookingTitle(booking.getBookingTitle());
        setBookingDescription(booking.getBookingDescription());
    }


    public String getBookingId() {
        return bookingId;
    }


    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTitle() {
        return bookingTitle;
    }

    public void setBookingTitle(String bookingTitle) {
        this.bookingTitle = bookingTitle;
    }

    public String getBookingDescription() {
        return bookingDescription;
    }

    public void setBookingDescription(String bookingDescription) {
        this.bookingDescription = bookingDescription;
    }

    @Override
    public String toString() {
        return "BookingDTO{" +
                "bookingId='" + bookingId + '\'' +
                ", bookingDate=" + bookingDate +
                ", bookingTitle='" + bookingTitle + '\'' +
                ", bookingDescription='" + bookingDescription + '\'' +
                '}';
    }

    public static List<BookingDTO> toBookingDTO(List<Booking> bookings) {
        List<BookingDTO> result = new ArrayList<>();
        for (Booking booking : bookings) {
            BookingDTO bookingDTO = new BookingDTO(booking);
            result.add(bookingDTO);
        }
        return result;
    }
    public static BookingDTO toBookingDto(Booking booking) {
            BookingDTO bookingDTO = new BookingDTO(booking);
            return bookingDTO;
    }


}
