package lk.ijse.gdse63.guide_service.service.custom;

import lk.ijse.gdse63.guide_service.dto.GuidDTO;
import lk.ijse.gdse63.guide_service.response.Response;

public interface GuideService<T extends GuidDTO,ID> {
    Response save(T t);

    Response update(T t);

    Response delete(String id);

    Response search(String id);

    Response getAll();

    Response createAndSendResponse(int statusCode, String message, Object data);
}
