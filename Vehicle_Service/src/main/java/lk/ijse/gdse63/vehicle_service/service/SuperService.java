package lk.ijse.gdse63.vehicle_service.service;


import lk.ijse.gdse63.vehicle_service.dto.SuperDto;
import lk.ijse.gdse63.vehicle_service.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SuperService<T extends SuperDto,ID >  {


    ResponseEntity<Response> search(String id);

    ResponseEntity<Response>  save(T t);

    ResponseEntity<Response>   update(T t);

    ResponseEntity<Response> delete(String id);

    ResponseEntity<Response>   getAll();

    ResponseEntity<Response> createAndSendResponse(int statusCode,String msg,Object data);
}
