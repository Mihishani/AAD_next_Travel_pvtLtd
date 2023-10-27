package lk.ijse.gdse63.aad.user_authorized_service.dto;


import lk.ijse.gdse63.aad.user_authorized_service.model.GENDER;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class User_dto implements Serializable ,SuperDto {

    private String userRole;

    private String userId;

    private String name;

    private String userName;

    private String userPassword;

    private String userNIC;

    private String userNICImageLocation;

    private int userAge;


    private GENDER gender;

    private String userEmail;

    private String userPhone;

    private String userAddress;

    private String remarks;

    private String userImageLocation;

    private boolean isAuthenticated;



    /* "userRole" : "jhvbj",
    "userId" : "fdjbv",
    "name" : "jfvbj",
    "userName" : "jhfv",
    "userPassword" : "jhfvbj",
    "userNIC" : "jdfj",
    "userNICImageLocation" : "kjfvk",
    "userAge" : 56,
    "gender" : "male",
    "userEmail" : "jhfbr",
    "userPhone" : "gbg",
    "userAddress" : "jvf",
    "remarks" : "hjfbg",
    "userImageLocation" : "jhfbvjd",
    "isAuthenticated" : true*/
}
