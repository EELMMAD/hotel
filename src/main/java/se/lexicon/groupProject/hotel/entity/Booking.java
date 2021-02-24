package se.lexicon.groupProject.hotel.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Booking {


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    public String bookingId;

    public LocalDate bookingDate;
    public String bookingTitle;
    public String bookingDescription;


    @OneToMany(cascade ={CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne(cascade ={CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "roomId")
    private Room room;

    public Booking() {
    }
    public Booking(LocalDate bookingDate, String bookingTitle, String bookingDescription) {
        setBookingDate(bookingDate);
        setBookingTitle(bookingTitle);
        setBookingDescription(bookingDescription);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return bookingId == booking.bookingId &&
                Objects.equals(bookingDate, booking.bookingDate) &&
                Objects.equals(bookingTitle, booking.bookingTitle) &&
                Objects.equals(bookingDescription, booking.bookingDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, bookingDate, bookingTitle, bookingDescription);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "booking_id=" + bookingId +
                ", booking_date=" + bookingDate +
                ", booking_title='" + bookingTitle + '\'' +
                ", booking_description='" + bookingDescription + '\'' +
                '}';
    }
}
