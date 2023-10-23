package lk.ijse.gdse63.aad.hotel_service.service.custom;

import lk.ijse.gdse63.aad.hotel_service.dto.HotelDTO;
import lk.ijse.gdse63.aad.hotel_service.response.Response;
import lk.ijse.gdse63.aad.hotel_service.service.SuperService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HotelService extends SuperService<HotelDTO,String> {
    ResponseEntity<Response> deleteAllHotels(List<String> hotelIDList);
    ResponseEntity<Response> findByHotelName(String hotelName);

}
