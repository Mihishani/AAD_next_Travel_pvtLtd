package lk.ijse.gdse63.package_detail_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PackageDetailServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PackageDetailServiceApplication.class, args);
    }

}
