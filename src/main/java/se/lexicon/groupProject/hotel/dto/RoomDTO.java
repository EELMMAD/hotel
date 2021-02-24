package se.lexicon.groupProject.hotel.dto;

import se.lexicon.groupProject.hotel.entity.Customer;
import se.lexicon.groupProject.hotel.entity.Room;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RoomDTO implements Serializable {

    private String roomId;
    @NotBlank(message = "Required field")
    @Size(min = 2, max = 255, message = "Need to have at least 2 letters")
    private String roomNumber;
    @NotBlank(message = "Required field")
    @Size(min = 2, max = 255, message = "Need to have at least 2 letters")
    private String roomType;
    private String roomDescription;
    private boolean available;

    public boolean isAvailable() {
        return available;
    }

    public RoomDTO() {
    }

    public RoomDTO(@NotBlank(message = "Required field") @Size(min = 2, max = 255, message = "Need to have at least 2 letters") String roomNumber, @NotBlank(message = "Required field") @Size(min = 2, max = 255, message = "Need to have at least 2 letters") String roomType, String roomDescription) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomDescription = roomDescription;
    }
    public RoomDTO(Room room) {
        setRoomNumber(room.getRoomNumber());
        setRoomType(room.getRoomType());
        setRoomDescription(room.getRoomDescription());
    }

    public String getRoomId() {
        return roomId;
    }


    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    @Override
    public String toString() {
        return "RoomDTO{" +
                "roomId='" + roomId + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", roomType='" + roomType + '\'' +
                ", roomDescription='" + roomDescription + '\'' +
                '}';
    }
    public static List<RoomDTO> toRoomDto(List<Room> rooms) {
        List<RoomDTO> result = new ArrayList<>();
        for (Room room : rooms) {
            RoomDTO roomDTO = new RoomDTO();
            result.add(roomDTO);
        }
        return result;
    }

}
