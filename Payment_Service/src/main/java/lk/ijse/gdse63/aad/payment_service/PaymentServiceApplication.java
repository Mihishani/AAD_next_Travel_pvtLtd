package lk.ijse.gdse63.aad.payment_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PaymentServiceApplication {

    public static void main(String[] args) {
        System.out.println("PAYMENT-SERVER-START");
        SpringApplication.run(PaymentServiceApplication.class, args);
        System.out.println("PAYMENT-SERVER-START");
    }

}
