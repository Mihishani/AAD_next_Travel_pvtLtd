package lk.ijse.gdse63.package_detail_service.interfaces;

import lk.ijse.gdse63.package_detail_service.dto.VehicleDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "Vehicle_Service")
public interface VehicleControllerInterface {
    @GetMapping(path = "/getVehicle")
    public VehicleDTO getVehicle(@RequestParam("vehicleId") String vehicleId);
}
