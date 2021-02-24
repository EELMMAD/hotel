package se.lexicon.groupProject.hotel.repository;


import org.springframework.data.repository.CrudRepository;
import se.lexicon.groupProject.hotel.entity.Customer;
import se.lexicon.groupProject.hotel.entity.Hotel;

import java.util.List;

public interface HotelRepository extends CrudRepository<Hotel, String> {

    List<Hotel> findAll();
    List<Hotel> findAllByHotelAddressContainingIgnoreCase(String hotelAddress);

    List<Hotel> findAllByHotelDescriptionContainingIgnoreCase(String hotelDescription);
    Hotel findByHotelId(String hotelId);




}
