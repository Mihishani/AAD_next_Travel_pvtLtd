package lk.ijse.gdse63.vehicle_service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JWTAuthFilter jwtAuthFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(jwtAuthFilter, org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .requestMatchers("/**").hasAnyAuthority("hotelAdmin","packageAdmin")
                .anyRequest().permitAll()

                .and()
                .csrf().disable();
        return http.build();

    }
}

//eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyUm9sZSI6IkFfVkVISUNMRSIsInN1YiI6InZlaGljbGVBZG1pbiIsImlhdCI6MTY5ODA2ODA5MywiZXhwIjo0ODUxNjY4MDkzfQ.nQTckOEDGVWtQq8ha3AWhsmNx8TIR10Xe73yQBqeABg