package lk.ijse.gdse63.package_detail_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PackageDTO implements Serializable,SuperDTO {
    private String packageId;
    private String packageCategory;
    private String vehicleCategory;
    private String hotelCategory;
}
