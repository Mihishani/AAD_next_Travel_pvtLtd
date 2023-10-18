package lk.ijse.gdse63.vehicle_service.service.custom.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse63.vehicle_service.dto.VehicleDTO;
import lk.ijse.gdse63.vehicle_service.entity.Vehicles;
import lk.ijse.gdse63.vehicle_service.interfaces.PackageControllerInterface;
import lk.ijse.gdse63.vehicle_service.repo.VehicleRepo;
import lk.ijse.gdse63.vehicle_service.response.Response;
import lk.ijse.gdse63.vehicle_service.service.SuperService;
import lk.ijse.gdse63.vehicle_service.service.custom.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private Response response;
    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PackageControllerInterface packageControllerInterface;



    @Override
/*    @PostMapping(path = "save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
   */ public Response save(VehicleDTO vehicleDTO) {
        if (search(vehicleDTO.getVehicleId()).getData() == null) {
            packageControllerInterface.getVehicleIds(vehicleDTO.getVehicleId(),vehicleDTO.getPackageId());

            vehicleRepo.save(modelMapper.map(vehicleDTO, Vehicles.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Vehicle Successfully saved!", null);
        }
        throw new RuntimeException("Vehicle does not exists!");
  }

    @Override
    public Response update(VehicleDTO vehicleDTO) {

        if (search(vehicleDTO.getVehicleId()).getData() != null) {
            vehicleRepo.save(modelMapper.map(vehicleDTO, Vehicles.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Vehicle Successfully updated!", null);
        }
        throw new RuntimeException("Vehicle does not exists!");

    }


    @Override
    public Response delete(String o) {
        if (search(o).getData() != null) {
            Optional<Vehicles> vehicle = vehicleRepo.findById(o);
            packageControllerInterface.getVehicleIdsForDeleteHotel(vehicle.get().getVehicleId(),vehicle.get().getPackageId());

            vehicleRepo.deleteById(o);
            return createAndSendResponse(HttpStatus.OK.value(), "Vehicle Successfully deleted!", null);
        }
        throw new RuntimeException("Vehicle does not exists!");

    }

    @Override
    public Response search(String o) {
        Optional<Vehicles> vehicles = vehicleRepo.findById(o);
        if (vehicles.isPresent()) {
            return createAndSendResponse(HttpStatus.FOUND.value(), "Vehicle Successfully retrieved!", modelMapper.map(vehicles.get(),VehicleDTO.class));
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Vehicle does not exists!", null);

    }

    @Override
    public Response getAll() {
        List<Vehicles> vehicles = vehicleRepo.findAll();
        if (!vehicles.isEmpty()) {
            ArrayList<VehicleDTO> vehicleDTOS = new ArrayList<>();
            vehicles.forEach((vehicles1) -> {
                vehicleDTOS.add(modelMapper.map(vehicles1, VehicleDTO.class));
            });
            return createAndSendResponse(HttpStatus.FOUND.value(), "Vehicle Successfully retrieved!", vehicleDTOS);
        }
        throw new RuntimeException("No Vehicle found in the database!");

    }

    @Override
    public VehicleDTO getVehicle(String id) {
        Optional<Vehicles> vehicle= vehicleRepo.findById(id);

        if (vehicle.isPresent()) {
            System.out.println(vehicle.get());
            return modelMapper.map(vehicle.get(), VehicleDTO.class);
        }
        throw new RuntimeException("vehicle cannot found!!!");

    }

    @Override
    public Response deleteVehicles(List<String> vehicleIds) {
        System.out.println(vehicleIds);
        for (String vehicleId : vehicleIds) {
            vehicleRepo.deleteById(vehicleId);
            return createAndSendResponse(HttpStatus.OK.value(), "Vehicle"+vehicleId+" deleted!", null);
        }
        return createAndSendResponse(HttpStatus.OK.value(), "ooppsss!", null);

    }

    @Override
    public Response createAndSendResponse(int statusCode, String message, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(message);
        response.setData(data);
        return response;
    }
}
