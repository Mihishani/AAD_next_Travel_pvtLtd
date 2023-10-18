package lk.ijse.gdse63.vehicle_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO implements Serializable,SuperDTO {
    private String vehicleId;
    private String vehicleBrand;
    private String vehicleCategory;
    private String fuelType;
    private String hybridOrNot;
    private String fuelUsage;
    private String vehicleImage;
    private String seatCapacity;
    private String vehicleType;
    private String transmission;
    private String driversName;
    private String driversPhoneNumber;
    private String driverLicenseImageLocation;

    private String packageId;
}
