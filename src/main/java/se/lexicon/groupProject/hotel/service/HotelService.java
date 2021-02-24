package se.lexicon.groupProject.hotel.service;

import se.lexicon.groupProject.hotel.dto.CustomerDTO;
import se.lexicon.groupProject.hotel.dto.HotelDTO;

import java.util.List;

public interface HotelService {
    HotelDTO findById(String hotelId);
    List<HotelDTO> findAll();

    HotelDTO create(HotelDTO hotelDTO);

    HotelDTO update(HotelDTO hotelDTO);

    boolean delete(String hotelId);
}
