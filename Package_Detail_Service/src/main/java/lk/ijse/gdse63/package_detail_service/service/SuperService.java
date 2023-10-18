package lk.ijse.gdse63.package_detail_service.service;

import lk.ijse.gdse63.package_detail_service.dto.PackageDetailDTO;
import lk.ijse.gdse63.package_detail_service.response.Response;

public interface SuperService <T extends PackageDetailDTO,ID> {
    Response save(T t);

    Response update(T t);

    Response delete(ID id);

    Response search(ID id);

    PackageDetailDTO getPackageDetail(ID id);

    Response getAll();


    Response createAndSendResponse(int statusCode, String message, Object data);
}
