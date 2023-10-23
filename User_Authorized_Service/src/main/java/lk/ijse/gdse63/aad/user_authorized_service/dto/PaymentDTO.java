package lk.ijse.gdse63.aad.user_authorized_service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDTO implements Serializable,SuperDTO {
    @Valid
    @NotNull(message = "Payment Id cannot be null.")
    @NotBlank(message = "Payment Id cannot be blank.")
    private String paymentId;
    @NotNull(message = "User Id cannot be null.")
    @NotBlank(message = "User Id cannot be blank.")
    private String userId;
    @NotNull(message = "Package Details Id cannot be null.")
    @NotBlank(message = "Package Details Id cannot be blank.")
    private String packageDetailsId;
    @NotNull(message = "Payment Date cannot be null.")
    @NotBlank(message = "Payment Date cannot be blank.")
    private String paymentDate;
    @Positive(message = "Value cannot be negative.")
    private double paymentAmount;
}
