package lk.ijse.gdse63.aad.user_authorized_service.endpoints;



import lk.ijse.gdse63.aad.user_authorized_service.model.User;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import lk.ijse.gdse63.aad.user_authorized_service.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    private Response response;

    @Autowired
    private AuthService authService;

    @PostMapping(path = "/register",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response register(@RequestBody User user){
        authService.register(user);
        return response;
    }
}
