package se.lexicon.groupProject.hotel.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private LocalDate bookingDate;
    private boolean available;
    public void setAvailable(boolean availableStatus) {
        this.available = availableStatus;
    }
    public boolean isAvailable() {
        return available;
    }
    @OneToMany(mappedBy = "customer")
    private List<Booking> bookingList;


    public Customer() {
    }

    public Customer(String customerFirstName, String customerLastName, String customerEmail, LocalDate bookingDate) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerEmail = customerEmail;
        this.bookingDate = bookingDate;
    }


    /*
    public void book(Booking booking){
        book.add(booking);
        booking.set
    }

     */


    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId &&
                Objects.equals(customerFirstName, customer.customerFirstName) &&
                Objects.equals(customerLastName, customer.customerLastName) &&
                Objects.equals(customerEmail, customer.customerEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerFirstName, customerLastName, customerEmail);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customerId +
                ", customer_firstName='" + customerFirstName + '\'' +
                ", customer_lastName='" + customerLastName + '\'' +
                ", customer_email='" + customerEmail + '\'' +
                '}';
    }
}
