package lk.ijse.gdse63.guide_service.service.custom;

import lk.ijse.gdse63.guide_service.dto.Guide_dto;
import lk.ijse.gdse63.guide_service.response.Response;
import org.springframework.http.ResponseEntity;


public interface GuideService<T extends Guide_dto,ID> {
        ResponseEntity<Response> search(String id);

        ResponseEntity <Response>save(T t);

        ResponseEntity <Response> update(T t);

        ResponseEntity<Response> findByGuideName(String guideName);

        ResponseEntity <Response> delete(String id);

        ResponseEntity <Response>getAll();
        ResponseEntity<Response> createAndSendResponse(int statusCode, String msg, Object data);

/*    ResponseEntity<Response> getGuideByName(String guideName);*/
}
