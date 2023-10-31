package lk.ijse.gdse63.package_detail_service.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PackageDetailDTO implements Serializable,SuperDTO {
    private String packageID;

    private String packageCategory;

    private String travelDuration;
    private String travelArea;
    private String remark;
    private int noOfAdults;
    private int noOfChildren;
    private int totalHeadCount;
    private boolean isPetsAllowed;
    private boolean isGuideNeeded;
    private double packageValue;
    private double packagePaidValue;
    private int hotelID;
    private int vehicleID;
    private int userID;
    private int guideID;


   /* "packageID" : "001",
    "packageCategory" : "Luxury",
    "travelDuration" : "jb",
    "travelArea" : "Sigiriya",
    "remark" : "good",
    "noOfAdults" : 1,
    "noOfChildren" : 3,
    "totalHeadCount" : 7,
    "isPetsAllowed" : true,
    "isGuideNeeded" : true,
    "packageValue" : 180000.00,
    "packagePaidValue" : 180000.00,
    "hotelID" : 003,
    "vehicleID" : 0004,
    "userID" : 005,
    "guideID" : 006*/

}
