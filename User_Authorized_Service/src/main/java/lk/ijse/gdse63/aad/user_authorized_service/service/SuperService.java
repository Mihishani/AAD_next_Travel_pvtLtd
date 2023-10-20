package lk.ijse.gdse63.aad.user_authorized_service.service;

import lk.ijse.gdse63.aad.user_authorized_service.dto.UserDTO;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.http.ResponseEntity;

public interface SuperService<T extends UserDTO,ID> {
    ResponseEntity<Response> save(T t);

    ResponseEntity<Response> update(T t);

    ResponseEntity<Response> delete(ID id);

    ResponseEntity<Response> search(ID id);

    ResponseEntity<Response> getAll(T t);


}
