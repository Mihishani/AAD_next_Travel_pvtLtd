package lk.ijse.gdse63.aad.package_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Package_dto implements Serializable,Super_dto{

    private String package_id;

    private String packageCategory;

    private String  vehicalCate;

    private String hotelCate;






 

}
