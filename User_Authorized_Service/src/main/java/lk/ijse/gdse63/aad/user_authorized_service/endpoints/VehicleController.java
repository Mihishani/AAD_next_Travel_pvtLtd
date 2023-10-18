package lk.ijse.gdse63.aad.user_authorized_service.endpoints;


import lk.ijse.gdse63.aad.user_authorized_service.dto.VehicleDTO;
import lk.ijse.gdse63.aad.user_authorized_service.interfaces.VehicleControllerInterface;
import lk.ijse.gdse63.aad.user_authorized_service.model.Vehicles;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {

    @Autowired
    private VehicleControllerInterface vehicleService;

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response saveVehicle(@RequestBody VehicleDTO vehicleDTO) {
        return vehicleService.saveVehicle(vehicleDTO);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody VehicleDTO vehicleDTO) {
        return vehicleService.update(vehicleDTO);
    }

    @GetMapping(path = "/search", params = "vehicleId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("vehicleId") String vehicleId) {
        return vehicleService.search(vehicleId);
    }

    @DeleteMapping(path = "/delete", params = "vehicleId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("vehicleId") String vehicleId) {
        return vehicleService.delete(vehicleId);
    }

    @GetMapping(path = "/getPackage", params = "vehicleId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Vehicles> getPackage(@RequestParam("vehicleId") String vehicleId) {
        return vehicleService.getVehicle(vehicleId);
    }

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll() {
        return vehicleService.getAll();
    }
}
