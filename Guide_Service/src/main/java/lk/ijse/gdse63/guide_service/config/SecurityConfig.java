package lk.ijse.gdse63.guide_service.config;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {


    @Autowired
    private JWTAuthFilter jwtAuthFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(jwtAuthFilter, org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .requestMatchers("/**").hasAnyAuthority("HotelAdmin","packageAdmin","GuideAdmin")
                .anyRequest().permitAll()

                .and()
                .csrf().disable();

        return http.build();

    }



}

/*eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyUm9sZSI6Ikd1aWRlQWRtaW4iLCJzdWIiOiJVc2VybmFtZSIsImlhdCI6MTY5ODQyNTM3MywiZXhwIjo0ODUyMDI1MzczfQ._5Vzoz7O45RWpAPNhXPNx6VKWbefOeVxb5q-NaRQHrA"
}*/