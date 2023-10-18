package lk.ijse.gdse63.package_detail_service.interfaces;

import lk.ijse.gdse63.package_detail_service.dto.PackageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("Package_Service")
public interface PackageControllerInterface {
    @GetMapping(path = "/getPackage", params = "packageId")
    public PackageDTO getPackage(@RequestParam("packageId") String packageId);
}
