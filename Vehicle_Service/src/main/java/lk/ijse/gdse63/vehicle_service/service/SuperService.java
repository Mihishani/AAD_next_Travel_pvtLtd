package lk.ijse.gdse63.vehicle_service.service;


import lk.ijse.gdse63.vehicle_service.dto.SuperDTO;
import lk.ijse.gdse63.vehicle_service.dto.VehicleDTO;
import lk.ijse.gdse63.vehicle_service.response.Response;

import java.util.List;

public interface SuperService<T extends SuperDTO,ID >  {
    Response save(T t);

    Response update(T t);

    Response delete(String id);

    Response search(String id);

    Response getAll();

    VehicleDTO getVehicle(String id);

    Response deleteVehicles(List<String> vehicleIds);

    Response createAndSendResponse(int statusCode, String message, Object data);

}
