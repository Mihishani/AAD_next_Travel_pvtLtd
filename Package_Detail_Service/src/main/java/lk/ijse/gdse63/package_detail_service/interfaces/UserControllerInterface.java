package lk.ijse.gdse63.package_detail_service.interfaces;

import lk.ijse.gdse63.package_detail_service.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "User_Auth_Service")
public interface UserControllerInterface {
    @GetMapping(path = "/getUserDetail")
    public UserDTO getUserDetail(@RequestParam("userDetailId") String userDetailId);
}
