package lk.ijse.gdse63.aad.user_authorized_service.service;

import lk.ijse.gdse63.aad.user_authorized_service.dto.UserDTO;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;

public interface SuperService<T extends UserDTO,ID> {
    Response save(T t);

    Response update(T t);

    Response delete(ID id);

    Response search(ID id);

    UserDTO getUserDetails(ID id);

    Response getAll();

    Response createAndSendResponse(int statusCode, String message, Object data);
}
