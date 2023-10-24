package lk.ijse.gdse63.vehicle_service.interfaces;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name ="Package_Service")
public interface PackageControllerInterface {


}
