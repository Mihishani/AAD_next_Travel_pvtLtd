package lk.ijse.gdse63.vehicle_service.interfaces;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name ="Package_Service")
public interface PackageControllerInterface {

    @PutMapping( value = "/getVehicleId",params = {"vehicleID","packageID"})
    public void getVehicleIds(@RequestParam("vehicleID") String vehicleId, @RequestParam("packageID") String packageId);

    @PutMapping( value = "/getVehicleIdsForDelete",params = {"vehicleID","packageID"})
    public void getVehicleIdsForDeleteHotel(@RequestParam("vehicleID") String vehicleID, @RequestParam("packageID") String packageId);

}
