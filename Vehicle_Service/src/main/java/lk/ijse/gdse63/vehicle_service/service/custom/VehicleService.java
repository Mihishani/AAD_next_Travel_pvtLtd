package lk.ijse.gdse63.vehicle_service.service.custom;

import lk.ijse.gdse63.vehicle_service.dto.Vehicle_dto;
import lk.ijse.gdse63.vehicle_service.response.Response;
import lk.ijse.gdse63.vehicle_service.service.SuperService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VehicleService extends SuperService<Vehicle_dto,String> {
    ResponseEntity<Response> deleteAllVehicle(List<String> vehicleIDList);
    ResponseEntity<Response> findByVehicleName(String vehicleName);

}
