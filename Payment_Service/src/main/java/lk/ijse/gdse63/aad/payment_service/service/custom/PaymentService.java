package lk.ijse.gdse63.aad.payment_service.service.custom;

import lk.ijse.gdse63.aad.payment_service.dto.Payment_dto;
import lk.ijse.gdse63.aad.payment_service.response.Response;
import org.springframework.http.ResponseEntity;

public interface PaymentService < T extends Payment_dto,ID> {
    ResponseEntity<Response> search(String id);

    ResponseEntity<Response> save(T t);

    ResponseEntity<Response>   update(T t);

    ResponseEntity<Response>   delete(String id);

    ResponseEntity<Response>   getAll();
    ResponseEntity<Response> createAndSendResponse(int statusCode, String msg, Object data);
}
