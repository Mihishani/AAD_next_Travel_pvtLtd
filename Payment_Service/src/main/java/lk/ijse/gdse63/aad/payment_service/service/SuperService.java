package lk.ijse.gdse63.aad.payment_service.service;

import lk.ijse.gdse63.aad.payment_service.dto.PaymentDTO;
import lk.ijse.gdse63.aad.payment_service.dto.SuperDTO;
import lk.ijse.gdse63.aad.payment_service.response.Response;

public interface SuperService <T extends SuperDTO,ID> {
    Response savePayment(T t);

    Response update(T t);

    Response delete(ID id);

    Response search(ID id);

    PaymentDTO getPayment(ID id);

    Response getAll();

    Response createAndSendResponse(int statusCode, String message, Object data);
}
