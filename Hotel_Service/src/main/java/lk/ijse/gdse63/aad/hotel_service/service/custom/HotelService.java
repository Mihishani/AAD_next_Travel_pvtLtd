package lk.ijse.gdse63.aad.hotel_service.service.custom;

import lk.ijse.gdse63.aad.hotel_service.dto.HotelDTO;
import lk.ijse.gdse63.aad.hotel_service.response.Response;

public interface HotelService<T extends HotelDTO,ID> {
    Response save(T t);

    Response update(T t);

    Response delete(String id);

    Response search(String id);

    Response getAll();

    Response createAndSendResponse(int statusCode, String message, Object data);

}
