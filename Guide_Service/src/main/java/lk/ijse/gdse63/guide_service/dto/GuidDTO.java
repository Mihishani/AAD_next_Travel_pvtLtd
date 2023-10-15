package lk.ijse.gdse63.guide_service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GuidDTO {
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
}
