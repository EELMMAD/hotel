package se.lexicon.groupProject.hotel.service;

import se.lexicon.groupProject.hotel.dto.CustomerDTO;
import se.lexicon.groupProject.hotel.dto.HotelDTO;
import se.lexicon.groupProject.hotel.dto.RoomDTO;
import se.lexicon.groupProject.hotel.entity.Hotel;
import se.lexicon.groupProject.hotel.entity.Room;
import se.lexicon.groupProject.hotel.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

public class RoomServiceImpl implements RoomService {
    RoomRepository roomRepo;

    @Override
    public List<RoomDTO> findAll() {

        List<Room> foundItems = roomRepo.findAll();
        return RoomDTO.toRoomDto(foundItems);
    }

    @Override
    public Optional<Room> findById(String roomId) {
        if (roomId == null || roomId.equals(""))
            throw new IllegalArgumentException("Title is necessary");
        RoomDTO dto = new RoomDTO(roomRepo.findByRoomId(roomId));
        return null;
    }
    @Override
    public List<Room> findByRoomType(String type) {
        if (type == null || type.equals(""))
            throw new IllegalArgumentException("Room type is necessary");
        List<Room> foundItems = roomRepo.findByRoomType(type);
        return foundItems;
    }


    @Override
    public Room findByRoomId(String roomId) {
        if (roomId == null || roomId.equals(""))
            throw new IllegalArgumentException("Title is necessary");
      return roomRepo.findByRoomId(roomId);
    }





    @Override
    public RoomDTO create(RoomDTO roomDTO) {
        if (roomDTO.getRoomNumber() == "0")
            throw new RuntimeException("Room id is invalid");
        if (roomRepo.findByRoomId(roomDTO.getRoomId()).isAvailable())
            throw new RuntimeException("Duplication exist in room");
       Room room = new Room(roomDTO.getRoomNumber(), roomDTO.getRoomType(), roomDTO.getRoomDescription());
        room.setAvailable(roomRepo.findByRoomId(roomDTO.getRoomId()).isAvailable());
        room.setAvailable(room.isAvailable());
        return new RoomDTO(roomRepo.save(room));
    }

    @Override
    public RoomDTO update(RoomDTO roomDTO) {
        Optional<Room> optionalRoom = roomRepo.findById(roomDTO.getRoomId());
        if (!optionalRoom.isPresent())
            throw new RuntimeException("Room doesn't exist");
        Room toUpdated = optionalRoom.get();
        if (!toUpdated.getRoomDescription().equals(roomDTO.getRoomDescription()))
            toUpdated.setRoomDescription(roomDTO.getRoomDescription());
        if (toUpdated.isAvailable())
            toUpdated.setAvailable(roomDTO.isAvailable());
        if (toUpdated.isAvailable() != roomDTO.isAvailable())
            toUpdated.setAvailable(roomDTO.isAvailable());
        if (toUpdated.getRoomNumber()!= roomDTO.getRoomNumber())
            toUpdated.setRoomNumber(roomDTO.getRoomNumber());
        if(toUpdated.getRoomType() != roomDTO.getRoomType())
            toUpdated.setRoomType(roomDTO.getRoomType());
        return new RoomDTO(roomRepo.save(toUpdated));
    }

    @Override
    public boolean delete(String roomId) {
        if (!roomRepo.findById(roomId).isPresent())
            throw new RuntimeException("There is no room with id: " + roomId);
        boolean deleted = false;
        if (roomRepo.existsById(roomId)) {
            roomRepo.delete(roomRepo.findById(roomId).get());
            deleted = true;
        }
        return deleted;
    }
}
