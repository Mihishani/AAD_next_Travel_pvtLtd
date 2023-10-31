package lk.ijse.gdse63.aad.payment_service.dto;


import lombok.*;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Payment_dto implements Serializable,SuperDTO {

    private String payID;

    private int DailyIncome;
    private int AnnualIncome;
    private int MonthlyIncome;
    private int WeeklyIncome;

}

/*  "payID" : "P001",
    "DailyIncome" : 1000,
    "AnnualIncome" : 1000,
    "MonthlyIncome" : 20000,
    "WeeklyIncome" : 1000*/