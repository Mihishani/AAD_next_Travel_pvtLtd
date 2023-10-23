package lk.ijse.gdse63.aad.hotel_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HotelServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelServiceApplication.class, args);
        System.out.println("Hotel-Service");
    }

}
