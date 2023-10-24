package lk.ijse.gdse63.aad.user_authorized_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class UserAuthorizedServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAuthorizedServiceApplication.class, args);
        System.out.println("USER-AUTH-SERVICE");
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
