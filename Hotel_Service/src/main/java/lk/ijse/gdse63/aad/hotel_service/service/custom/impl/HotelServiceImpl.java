package lk.ijse.gdse63.aad.hotel_service.service.custom.impl;

import lk.ijse.gdse63.aad.hotel_service.dto.HotelDTO;
import lk.ijse.gdse63.aad.hotel_service.entity.Hotel;
import lk.ijse.gdse63.aad.hotel_service.repo.HotelRepo;
import lk.ijse.gdse63.aad.hotel_service.response.Response;
import lk.ijse.gdse63.aad.hotel_service.service.custom.HotelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {
   @Autowired
   private Response response;

   @Autowired
   private ModelMapper modelMapper;

   @Autowired
   private HotelRepo hotelRepo;

    @Override
    public Response save(HotelDTO hotelDTO) {
        if (search(hotelDTO.getHotelID()).getData() == null) {
            hotelRepo.save(modelMapper.map(hotelDTO, Hotel.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Hotel Successfully saved!", null);
        }
        throw new RuntimeException("Hotel already exists!");

    }

    @Override
    public Response update(HotelDTO hotelDTO) {
        if (search(hotelDTO.getHotelID()).getData() != null) {
            hotelRepo.save(modelMapper.map(hotelDTO, Hotel.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Hotel Successfully updated!", null);
        }
        throw new RuntimeException("Hotel does not exists!");

    }

    @Override
    public Response delete(String o) {
        if (search(o).getData() != null) {
            hotelRepo.deleteById(o);
            return createAndSendResponse(HttpStatus.OK.value(), "Hotel Successfully deleted!", null);
        }
        throw new RuntimeException("Hotel does not exists!");

    }

    @Override
    public Response search(String o) {
        Optional<Hotel> hotel= hotelRepo.findById(o);
        if (hotel.isPresent()) {
            return createAndSendResponse(HttpStatus.FOUND.value(), "Hotel Successfully retrieved!", modelMapper.map(hotel.get(), HotelDTO.class));
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Hotel does not exists!", null);

    }

    @Override
    public Response getAll() {
        List<Hotel> hotels = hotelRepo.findAll();
        if (!hotels.isEmpty()) {
            ArrayList<HotelDTO> hotelDTOS = new ArrayList<>();
            hotels.forEach((hotel) -> {
                hotelDTOS.add(modelMapper.map(hotel, HotelDTO.class));
            });
            return createAndSendResponse(HttpStatus.FOUND.value(), "Hotels Successfully retrieved!", hotelDTOS);
        }
        throw new RuntimeException("No Hotels found in the database!");

    }

    @Override
    public Response createAndSendResponse(int statusCode, String message, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(message);
        response.setData(data);
        return response;
    }
}