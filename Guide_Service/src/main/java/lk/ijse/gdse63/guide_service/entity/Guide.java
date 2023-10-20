package lk.ijse.gdse63.guide_service.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Guide {
    @Id
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
