package se.lexicon.groupProject.hotel.service;

import se.lexicon.groupProject.hotel.dto.CustomerDTO;
import se.lexicon.groupProject.hotel.dto.RoomDTO;
import se.lexicon.groupProject.hotel.entity.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {


    List<RoomDTO> findAll();
    Optional<Room> findById(String id);
    List<Room> findByRoomType(String type);
    Room findByRoomId(String roomId);
    RoomDTO create(RoomDTO roomDTO);

    RoomDTO update(RoomDTO roomDTO);

    boolean delete(String roomId);
}
