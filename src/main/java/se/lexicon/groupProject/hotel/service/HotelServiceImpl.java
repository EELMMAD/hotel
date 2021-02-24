package se.lexicon.groupProject.hotel.service;

import se.lexicon.groupProject.hotel.dto.HotelDTO;
import se.lexicon.groupProject.hotel.entity.Hotel;
import se.lexicon.groupProject.hotel.repository.HotelRepository;

import java.util.List;
import java.util.Optional;

public class HotelServiceImpl implements HotelService {
    HotelRepository hotelRepo;

    @Override
    public HotelDTO findById(String hotelId){
        if (hotelId == null || hotelId.equals(""))
            throw new IllegalArgumentException("Hotel Id is necessary");
        HotelDTO dto = new HotelDTO(hotelRepo.findByHotelId(hotelId));
        return dto;
    }

    @Override
    public List<HotelDTO> findAll() {
        List<Hotel> foundItems = hotelRepo.findAll();
        return HotelDTO.toHotelDto(foundItems);
    }

    @Override
    public HotelDTO create(HotelDTO hotelDTO) {
        if (hotelDTO.getHotelAddress() == "0")
            throw new RuntimeException("Hotel id is invalid");
        if (hotelRepo.findByHotelId(hotelDTO.getHotelId()).isAvailable())
            throw new RuntimeException("Duplication exist in hotel");
        Hotel hotel = new Hotel(hotelDTO.getHotelAddress(), hotelDTO.getHotelDescription(), hotelDTO.getHotelType());
        hotel.setAvailable(hotelRepo.findByHotelId(hotelDTO.getHotelId()).isAvailable());
        hotel.setAvailable(hotel.isAvailable());
        return new HotelDTO(hotelRepo.save(hotel));
    }

    @Override
    public HotelDTO update(HotelDTO hotelDTO) {
        Optional<Hotel> optionalHotel = hotelRepo.findById(hotelDTO.getHotelId());
        if (!optionalHotel.isPresent())
            throw new RuntimeException("Hotel doesn't exist");
        Hotel toUpdated = optionalHotel.get();
        if (!toUpdated.getHotelAddress().equals(hotelDTO.getHotelAddress()))
            toUpdated.setHotelAddress(hotelDTO.getHotelAddress());
        if (toUpdated.isAvailable())
            toUpdated.setAvailable(hotelDTO.isAvailable());
        if (toUpdated.isAvailable() != hotelDTO.isAvailable())
            toUpdated.setAvailable(hotelDTO.isAvailable());
        if (toUpdated.getHotelDescription()!= hotelDTO.getHotelDescription())
            toUpdated.setHotelDescription(hotelDTO.getHotelDescription());
       if(toUpdated.getHotelType() != hotelDTO.getHotelType())
           toUpdated.setHotelType(hotelDTO.getHotelType());
        return new HotelDTO(hotelRepo.save(toUpdated));
    }

    @Override
    public boolean delete(String hotelId) {
        if (!hotelRepo.findById(hotelId).isPresent())
            throw new RuntimeException("There is no hotel with id: " + hotelId);
        boolean deleted = false;
        if (hotelRepo.existsById(hotelId)) {
            hotelRepo.delete(hotelRepo.findById(hotelId).get());
            deleted = true;
        }
        return deleted;
    }
}
