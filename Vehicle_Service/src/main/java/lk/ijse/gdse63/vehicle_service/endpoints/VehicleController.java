package lk.ijse.gdse63.vehicle_service.endpoints;


import lk.ijse.gdse63.vehicle_service.dto.Vehicle_dto;
import lk.ijse.gdse63.vehicle_service.response.Response;
import lk.ijse.gdse63.vehicle_service.service.custom.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle")
@CrossOrigin
public class VehicleController {


    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/check")
    public String getCheck_vehicle(){
        return "Vehicle API run";
    }


    @PostMapping(path = "vSave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> save(@RequestBody Vehicle_dto vehicleDto){
        System.out.println("vehicle save working");
        return vehicleService.save(vehicleDto);
    }

    @PutMapping(path = "/Vput",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> update(@RequestBody Vehicle_dto vehicleDto){
        System.out.println("VehicleDto update working in vehicle");
        System.out.println(vehicleDto.toString());
        return vehicleService.update(vehicleDto);
    }


    @DeleteMapping(path = "V_delete",params ="Vehicle_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> delete(@RequestParam("Vehicle_ID") String vehicleID){
        return vehicleService.delete(vehicleID);
    }

    @GetMapping(path = "V_search",params = "Vehicle_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> search(@RequestParam("Vehicle_ID") String Vehicle_ID){
        return vehicleService.search(Vehicle_ID);
    }

//for package testing

    @PostMapping("/getvehi")
    public ResponseEntity <String> getAllVehicles(@RequestParam String id) {
        // Return the data as a response
        return ResponseEntity.ok(id);
    }





}
