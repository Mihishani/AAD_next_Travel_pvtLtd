package lk.ijse.gdse63.package_detail_service.service.custom;

import lk.ijse.gdse63.package_detail_service.dto.PackageDetailDTO;
import lk.ijse.gdse63.package_detail_service.response.Response;

public interface PackageDetailService<T extends PackageDetailDTO,ID> {
    Response save(T t);

    Response update(T t);

    Response delete(String id);

    Response search(String id);

    Response getAll();

    Response createAndSendResponse(int statusCode, String message, Object data);
}
