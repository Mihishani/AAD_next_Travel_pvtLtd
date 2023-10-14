package lk.ijse.gdse63.vehicle_service.service.custom;

import lk.ijse.gdse63.vehicle_service.dto.VehicleDTO;
import lk.ijse.gdse63.vehicle_service.response.Response;
import lk.ijse.gdse63.vehicle_service.service.SuperService;

public interface VehicleService <T extends VehicleDTO,ID > {
    Response save(T t);

    Response update(T t);

    Response delete(String id);

    Response search(String id);

    Response getAll();

    Response createAndSendResponse(int statusCode, String message, Object data);
}
