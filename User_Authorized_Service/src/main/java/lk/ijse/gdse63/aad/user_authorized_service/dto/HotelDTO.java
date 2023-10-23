package lk.ijse.gdse63.aad.user_authorized_service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelDTO implements Serializable,SuperDTO {

    @Valid
    private String hotelId;
    @NotNull(message = "Package Id cannot be null.")
    @NotBlank(message = "Package Id cannot be blank.")
    private String packageId;
    @NotNull(message = "Hotel Name cannot be null.")
    @NotBlank(message = "Hotel Name cannot be blank.")
    @Size(min = 3, max = 50, message = "Hotel Name must be between 3 and 50 characters.")
    private String hotelName;
    @NotNull(message = "Hotel Category cannot be null.")
    @NotBlank(message = "Hotel Category cannot be blank.")
    @Size(min = 3, max = 50, message = "Hotel Category must be between 3 and 50 characters.")
    private String hotelCategory;
    @NotNull(message = "Hotel Address cannot be null.")
    @NotBlank(message = "Hotel Address cannot be blank.")
    @Size(min = 3, max = 50, message = "Hotel Address must be between 3 and 50 characters.")
    private String hotelLocation;
    @NotNull(message = "Hotel Address cannot be null.")
    @NotBlank(message = "Hotel Address cannot be blank.")
    @Size(min = 3, max = 50, message = "Hotel Address must be between 3 and 50 characters.")
    private String hotelLocationWithCoordinates;
    private String hotelImageLocation;
    @Email(message = "Email should be valid.")
    private String hotelContactEmail;
    @NotNull(message = "Phone cannot be null.")
    @NotBlank(message = "Phone cannot be blank.")
    @Size(min = 10, max = 10, message = "Phone must be 10 characters.")
    private String hotelContact1;
    @NotNull(message = "Phone cannot be null.")
    @NotBlank(message = "Phone cannot be blank.")
    @Size(min = 10, max = 10, message = "Phone must be 10 characters.")
    private String hotelContact2;
    private double fullBoardWithACLuxuryRoomDouble;
    private double halfBoardWithACLuxuryRoomDouble;
    private double fullBoardWithACLuxuryRoomTriple;
    private double halfBoardWithACLuxuryRoomTriple;
    private boolean isPetsAllowed;
    @Positive(message = "Value cannot be negative.")
    private double hotelFee;
    @NotNull(message = "This field cannot be null.")
    @NotBlank(message = "This field cannot be blank.")
    private String cancellationCriteria;
    private String remarks;

}
