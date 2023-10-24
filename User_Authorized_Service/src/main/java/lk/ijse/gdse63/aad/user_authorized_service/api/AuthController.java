package lk.ijse.gdse63.aad.user_authorized_service.api;


import lk.ijse.gdse63.aad.user_authorized_service.dto.User_dto;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import lk.ijse.gdse63.aad.user_authorized_service.service.custom.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/getAuth", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getAuth(@RequestBody User_dto userDTO) {
        System.out.println(userDTO.toString());
        return userService.save(userDTO);
    }

    @PostMapping(path = "/uploadImage",params = "userId")
    public ResponseEntity<Response> uploadImage(@RequestParam("imageFile") MultipartFile imageFile, @RequestParam("userId") String userId) {
        ResponseEntity<Response> user = userService.search(userId);

        User_dto userData = (User_dto) user.getBody().getData();
        if(userData!=null){
            userData.setUserImageLocation(userService.handleUploads(imageFile));
            return userService.update(userData);
        }
        throw new RuntimeException("User not found!");

    }

    @GetMapping(path = "/hello")
    public String  getRole(){
        return "Hello nigger!";

    }

}
