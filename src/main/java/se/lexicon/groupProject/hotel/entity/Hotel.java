package se.lexicon.groupProject.hotel.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Hotel {


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    public String hotelId;
    public String hotelType;
    public String hotelAddress;
    public String hotelDescription;
    private boolean available;

    public void setAvailable(boolean availableStatus) {
        this.available = availableStatus;
    }

    @OneToMany(mappedBy = "hotel")
    private List<Room> roomList;

    public Hotel() {
    }

    public Hotel(String hotelType, String hotelAddress, String hotelDescription) {
       setHotelType(hotelType);
       setHotelAddress(hotelAddress);
       setHotelDescription(hotelDescription);
    }
    public boolean isAvailable() {
        return available;
    }

    public String getHotelId() {
        return hotelId;
    }

    public String getHotelType() {
        return hotelType;
    }

    public void setHotelType(String hotelType) {
        this.hotelType = hotelType;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelDescription() {
        return hotelDescription;
    }

    public void setHotelDescription(String hotelDescription) {
        this.hotelDescription = hotelDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return hotelId == hotel.hotelId &&
                Objects.equals(hotelType, hotel.hotelType) &&
                Objects.equals(hotelAddress, hotel.hotelAddress) &&
                Objects.equals(hotelDescription, hotel.hotelDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelId, hotelType, hotelAddress, hotelDescription);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotel_id=" + hotelId +
                ", hotel_type='" + hotelType + '\'' +
                ", hotel_address='" + hotelAddress + '\'' +
                ", hotel_description='" + hotelDescription + '\'' +
                '}';
    }
}
