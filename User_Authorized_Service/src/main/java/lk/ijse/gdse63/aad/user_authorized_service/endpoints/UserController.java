package lk.ijse.gdse63.aad.user_authorized_service.endpoints;


import lk.ijse.gdse63.aad.user_authorized_service.dto.UserDTO;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import lk.ijse.gdse63.aad.user_authorized_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/User")
@CrossOrigin
public class UserController {

 /*   @GetMapping(path = "/hello")
    public String demo(){
        return "Hello World";
    }*/

    @Autowired
    private UserService userService;

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody UserDTO userDTO) {
        return userService.update(userDTO);
    }

    @GetMapping(path = "/search", params = "userId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("userId") String guideId) {
        return userService.search(guideId);
    }

    @DeleteMapping(path = "/delete", params = "userId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("userId") String guideId) {
        return userService.delete(guideId);
    }

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll() {
        return userService.getAll();
    }
}
