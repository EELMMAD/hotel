package se.lexicon.groupProject.hotel.dto;

import se.lexicon.groupProject.hotel.entity.Customer;
import se.lexicon.groupProject.hotel.entity.Hotel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HotelDTO implements Serializable {
    private String hotelId;
    @NotBlank(message = "Required field")
    @Size(min = 2, max = 255, message = "Need to have at least 2 letters")
    private String hotelType;
    @NotBlank(message = "Required field")
    @Size(min = 2, max = 255, message = "Need to have at least 2 letters")
    private String hotelAddress;
    public String hotelDescription;
    private boolean available;

    public HotelDTO() {
    }

    public HotelDTO(@NotBlank(message = "Required field") @Size(min = 2, max = 255, message = "Need to have at least 2 letters") String hotelType, @NotBlank(message = "Required field") @Size(min = 2, max = 255, message = "Need to have at least 2 letters") String hotelAddress, String hotelDescription) {
        this.hotelType = hotelType;
        this.hotelAddress = hotelAddress;
        this.hotelDescription = hotelDescription;
    }

    public HotelDTO(Hotel hotel) {

        setHotelType(hotel.getHotelType());
        setHotelAddress(hotel.getHotelAddress());
        setHotelDescription(hotel.getHotelDescription());
    }
    public boolean isAvailable() {
        return available;
    }

    public static List<HotelDTO> toHotelDto(List<Hotel> hotels) {
        List<HotelDTO> result = new ArrayList<>();
        for (Hotel hotel : hotels) {
            HotelDTO hotelDTO = new HotelDTO();
            result.add(hotelDTO);
        }
        return result;
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
    public String toString() {
        return "HotelDTO{" +
                "hotelId='" + hotelId + '\'' +
                ", hotelType='" + hotelType + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                ", hotelDescription='" + hotelDescription + '\'' +
                '}';
    }
}
