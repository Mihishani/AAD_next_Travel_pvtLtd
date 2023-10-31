package lk.ijse.gdse63.aad.package_service.interfaces;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("VEHICLE-SERVER")
public interface PackageFiegnInterfaec {


    @GetMapping("/getvehi")
    public ResponseEntity<String> getAllVehicles(@RequestParam String id) ;
        // Return the data as a response






}
