package lk.ijse.gdse63.aad.hotel_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class HotelDTO implements Serializable,SuperDTO {

    private String hotelId;
     private String hotelName;
     private String hotelCategory;
    private String hotelLocation;
    private String hotelLocationWithCoordinates;
    private String hotelImageLocation;
    private String hotelContactEmail;
    private String hotelContact1;
    private String hotelContact2;
    private double fullBoardWithACLuxuryRoomDouble;
    private double halfBoardWithACLuxuryRoomDouble;
    private double fullBoardWithACLuxuryRoomTriple;
    private double halfBoardWithACLuxuryRoomTriple;
    private boolean isPetsAllowed;
    private double hotelFee;
    private String cancellationCriteria;
    private String packageId;
    private String remarks;



   /* "hotelId" : "003",
    "packageId" : "004",
    "hotelName" : "Blue water hotel",
    "hotelCategory" : "super Luxury",
    "hotelLocation" : "wadduwa",
    "hotelLocationWithCoordinates" : "12.3456, 78.9012",
    "hotelImageLocation" : "gvh",
    "hotelContactEmail" : "bluwater@gmail.com",
    "hotelContact1" : "0897654789",
    "hotelContact2" : "0567845689",
    "fullBoardWithACLuxuryRoomDouble" : 60000.00,
    "halfBoardWithACLuxuryRoomDouble" : 40000.00,
    "fullBoardWithACLuxuryRoomTriple" : 80000.00,
    "halfBoardWithACLuxuryRoomTriple" : 75000.00,
    "isPetsAllowed" : true,
    "hotelFee" : 150000.00,
    "cancellationCriteria" : "free cancellation up to 48 hours before check-in",
    "remarks" : "good"*/
 }
