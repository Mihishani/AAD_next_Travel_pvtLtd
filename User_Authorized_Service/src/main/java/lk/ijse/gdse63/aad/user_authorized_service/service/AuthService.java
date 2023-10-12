package lk.ijse.gdse63.aad.user_authorized_service.service;

import lk.ijse.gdse63.aad.user_authorized_service.config.JWTService;
import lk.ijse.gdse63.aad.user_authorized_service.entity.User;
import lk.ijse.gdse63.aad.user_authorized_service.repo.UserRepo;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private Response response;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtService;

    public Response register(User user) {
        String password = passwordEncoder.encode(user.getPassword());
        user.setUserPassword(password);
        userRepo.save(user);
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("User successfully registered and JWT Successfully generated!");
        response.setData("JWT : "+jwtService.generateToken(user));
        return response;
    }


}
