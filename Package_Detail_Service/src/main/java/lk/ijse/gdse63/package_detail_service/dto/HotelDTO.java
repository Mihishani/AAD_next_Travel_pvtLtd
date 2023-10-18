package lk.ijse.gdse63.package_detail_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelDTO implements Serializable,SuperDTO {
    private String hotelID;
    private String hotelName;
    private String hotelCatageory;
    private String hotelLocation;
    private String hotelLocationWithCoordinates;
    private String hotelEmail;
    private String hotelContactNumber;
    private boolean isPetsAllowed;
    private double FullBoardDoublehotelFee;
    private double HalfBoardDoublehotelFee;
    private double FullBoardTriplehotelFee;
    private double HalfBoardTriplehotelFee;
    private String cancellationCriteria;

    private String packageId;
}