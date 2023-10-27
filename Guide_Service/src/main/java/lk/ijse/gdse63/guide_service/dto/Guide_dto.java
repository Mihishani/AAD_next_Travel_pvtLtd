package lk.ijse.gdse63.guide_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Guide_dto implements Serializable {


    private String guideID;

    private String guideName;

    private String guideAddress;

    private String guideAge;

    private String guideGender;

    private String guidePICIMGLocation;

    private String guideNICIMGLocation;

    private String guideIDIMGLocation;

    private String guideExperience;

    private int manDayValue;


    private String remark;




/*    "guideID" : "hdfj",
    "guideName" : "dbghd",
    "guideAddress" : "vbfd",
    "guideAge" : "jhdvbgj",
    "guideGender" : "gvgh",
    "guidePICIMGLocation" : "jgvbdj",
    "guideNICIMGLocation" : "vhsdf",
    "guideIDIMGLocation" : "iohgo",
    "guideExperience" : "fhb",
    "manDayValue" : 78,
    "remark" : "bgt"*/



}
