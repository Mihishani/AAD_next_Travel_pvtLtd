package lk.ijse.gdse63.aad.hotel_service.service.custom.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse63.aad.hotel_service.dto.HotelDTO;
import lk.ijse.gdse63.aad.hotel_service.entity.Hotel_entity;
import lk.ijse.gdse63.aad.hotel_service.interfaces.PackageInterface;
import lk.ijse.gdse63.aad.hotel_service.repo.Hotel_repo;
import lk.ijse.gdse63.aad.hotel_service.response.Response;
import lk.ijse.gdse63.aad.hotel_service.service.custom.HotelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public  class HotelServiceImpl implements HotelService {


   @Autowired
   private ModelMapper modelMapper;

    @Autowired
    private Hotel_repo hotelRepo;
    @Autowired
    private Response response;

    @Autowired
    private PackageInterface packageInterface;


    @Override
    public ResponseEntity<Response> add(HotelDTO hotelDTO) {
        if (search(hotelDTO.getHotelId()).getBody().getData() == null) {
            hotelRepo.save(modelMapper.map(hotelDTO, Hotel_entity.class));
         /*    HotelDTO dto = (HotelDTO) findByHotelName(hotelDTO.getHotelName()).getBody().getData();*/
          /*  packageInterface.saveHotelID(hotelDTO.getPackageId(), dto.getHotelId());*/
            return createAndSendResponse(HttpStatus.CREATED.value(), "Hotel Successfully saved!", true);

        }
        return createAndSendResponse(HttpStatus.CONFLICT.value(), "Hotel Already Exists!", false);
    }

    @Override
    public ResponseEntity<Response> update(HotelDTO hotelDTO) {
       /* if (search(hotelDTO.getHotelId()).getBody().getData() == null) {
            return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Hotel Not Found!", null);

        }
        Optional<Hotel_entity> hotelDto = hotelRepo.findById(hotelDTO.getHotelId());
        if (hotelDto.isPresent()) {
            packageInterface.updateHotelPackageId(hotelDto.get().getPackageId(), hotelDTO.getPackageId(), hotelDTO.getHotelId());
            hotelRepo.save(modelMapper.map(hotelDTO, Hotel_entity.class));


        }
        return createAndSendResponse(HttpStatus.OK.value(), "Hotel Successfully updated!", null);*/

        Optional<Hotel_entity> existingVehicle = hotelRepo.findById(hotelDTO.getHotelId());

        if (existingVehicle.isPresent()) {
            // The vehicle with the given ID exists, so update it
             Hotel_entity updatedEntity = modelMapper.map( hotelDTO, Hotel_entity.class);
            updatedEntity.setHotelId(hotelDTO.getHotelId()); // Set the ID to ensure an update
             hotelRepo.save(updatedEntity);
            return createAndSendResponse(HttpStatus.OK.value(), null, "Hotel updated successfully");
        } else {
            // The vehicle with the given ID does not exist, so create a new entry
            Hotel_entity newEntity = modelMapper.map( hotelDTO,  Hotel_entity.class);
             hotelRepo.save(newEntity);
            return createAndSendResponse(HttpStatus.OK.value(), null, "Hotel created successfully");
        }


    }

    @Override
    public ResponseEntity<Response> search(String s) {
        Optional<Hotel_entity> hotel = hotelRepo.findById(s);
        if (hotel.isPresent()) {
            return createAndSendResponse(HttpStatus.OK.value(), "Hotel Successfully retrieved!", modelMapper.map(hotel.get(), HotelDTO.class));

        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Hotel Not Found!", null);
    }

    @Override
    public ResponseEntity<Response> delete(String s) {
        if (search(s).getBody().getData() == null) {
            return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Hotel Not Found!", null);

        }
        hotelRepo.deleteById(s);
        return createAndSendResponse(HttpStatus.OK.value(), "Hotel Successfully deleted!", null);


    }

    @Override
    public ResponseEntity<Response> getAll() {
        List<Hotel_entity> hotels = hotelRepo.findAll();
        if (!hotels.isEmpty()) {
            List<HotelDTO> hotelDTOS = new ArrayList<>();
            hotels.forEach((hotel) -> {
                hotelDTOS.add(modelMapper.map(hotel, HotelDTO.class));

            });
            return createAndSendResponse(HttpStatus.OK.value(), "Hotels Successfully retrieved!", hotelDTOS);

        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Hotels Not Found!", null);

    }

    @Override
    public ResponseEntity<Response> createAndSendResponse(int statusCode, String msg, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(msg);
        response.setData(data);
        System.out.println("Status Code : " + statusCode);
        System.out.println("Sent : " + HttpStatus.valueOf(statusCode));

        return new ResponseEntity<>(response, HttpStatusCode.valueOf(statusCode));

    }

    @Override
    public ResponseEntity<Response> deleteAllHotels(List<String> hotelIDList) {
        System.out.println("HotelServiceIMPL : " + hotelIDList);
        hotelIDList.forEach((hID) -> {
            hotelRepo.deleteById(hID);

        });
        return createAndSendResponse(HttpStatus.OK.value(), "Hotels Successfully deleted!", null);
    }

    @Override
    public ResponseEntity<Response> findByHotelName(String hotelName) {
        Optional<Hotel_entity> hotel = hotelRepo.findByHotelName(hotelName);
        if (hotel.isPresent()) {
            return createAndSendResponse(HttpStatus.OK.value(), "Hotel Successfully retrieved!", modelMapper.map(hotel.get(), HotelDTO.class));

        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Hotel Not Found!", null);
    }



}
