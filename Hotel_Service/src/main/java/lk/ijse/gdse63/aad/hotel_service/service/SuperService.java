package lk.ijse.gdse63.aad.hotel_service.service;

import lk.ijse.gdse63.aad.hotel_service.dto.HotelDTO;
import lk.ijse.gdse63.aad.hotel_service.dto.SuperDTO;
import lk.ijse.gdse63.aad.hotel_service.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SuperService<T extends SuperDTO,ID> {
    ResponseEntity<Response> add(T t);

    ResponseEntity<Response> update(T t);

    ResponseEntity<Response> search(ID id);

    ResponseEntity<Response> delete(ID id);

    ResponseEntity<Response> getAll();
    ResponseEntity<Response> createAndSendResponse(int statusCode,String msg,Object data);

}
