package lk.ijse.gdse63.aad.user_authorized_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Vehicles {

    @Id
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
