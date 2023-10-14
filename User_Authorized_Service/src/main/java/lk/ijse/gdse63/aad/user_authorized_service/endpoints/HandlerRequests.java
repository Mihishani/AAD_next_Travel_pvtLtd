package lk.ijse.gdse63.aad.user_authorized_service.endpoints;

import lk.ijse.gdse63.aad.user_authorized_service.config.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@CrossOrigin
public class HandlerRequests {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

 /*   public boolean isAuthenticated(@RequestParam("jwtToken")String jwtToken){
        System.out.println("jwtToken = "+jwtToken);
        UserDetails userDetails =userDetailsService.loadUserByUsername(jwtToken.extractUsername(jwtToken));
        return jwtService.validateToken(jwtToken,userDetails);
    }*/
}
