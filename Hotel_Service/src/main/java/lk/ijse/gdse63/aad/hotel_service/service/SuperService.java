package lk.ijse.gdse63.aad.hotel_service.service;

import lk.ijse.gdse63.aad.hotel_service.dto.HotelDTO;
import lk.ijse.gdse63.aad.hotel_service.response.Response;

import java.util.List;

public interface SuperService<T extends HotelDTO,ID> {
    Response saveHotel(T t);

    Response update(T t);

    Response delete(ID id);

    Response search(ID id);

    Response getAll();

    HotelDTO getHotel(ID id);

    Response deleteHotels(List<String> hotelList);

    Response createAndSendResponse(int statusCode, String message, Object data);
}
