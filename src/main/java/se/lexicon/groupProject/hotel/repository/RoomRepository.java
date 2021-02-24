package se.lexicon.groupProject.hotel.repository;


import org.springframework.data.repository.CrudRepository;
import se.lexicon.groupProject.hotel.dto.HotelDTO;
import se.lexicon.groupProject.hotel.dto.RoomDTO;
import se.lexicon.groupProject.hotel.entity.Customer;
import se.lexicon.groupProject.hotel.entity.Room;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends CrudRepository<Room, String> {
    List<Room> findAll();
    Optional<Room> findById(String id);
    List<Room> findByRoomType(String type);
   Room findByRoomId(String roomId);
}
