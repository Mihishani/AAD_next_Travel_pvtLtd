package lk.ijse.gdse63.aad.user_authorized_service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GuidDTO implements Serializable,SuperDTO {
    private String guideId;
    private String guideName;
    private String guideAddress;
    private int guideAge;
    private String gender;
    private String guideContact;
    private String guideImageLocation;
    private String guideNICImageLocation;
    private String guideIDImageLocation;
    private String guideExperience;
    private String manDayValue;
    private String remarks;
}