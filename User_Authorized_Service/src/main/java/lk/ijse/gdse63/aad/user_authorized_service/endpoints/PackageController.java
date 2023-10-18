package lk.ijse.gdse63.aad.user_authorized_service.endpoints;

import lk.ijse.gdse63.aad.user_authorized_service.dto.PackageDTO;
import lk.ijse.gdse63.aad.user_authorized_service.interfaces.PackageControllerInterface;
import lk.ijse.gdse63.aad.user_authorized_service.interfaces.PackageDetailsControllerInterface;
import lk.ijse.gdse63.aad.user_authorized_service.model.Package;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/packages")
@CrossOrigin
public class PackageController {

    @Autowired
    private PackageControllerInterface packageControllerInterface;

    @PostMapping(path = "/savePackage", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@RequestBody PackageDTO packageDTO) {
        return  packageControllerInterface.save(packageDTO);
    }

    @PutMapping(path = "/updatePackage", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody PackageDTO packagesDTO) {
        return packageControllerInterface.update(packagesDTO);
    }

    @GetMapping(path = "/searchPackage", params = "packagesId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("packagesId") String packagesId) {
        return  packageControllerInterface.search(packagesId);
    }

    @DeleteMapping(path = "/deletePackage", params = "packagesId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("packagesId") String packagesId) {
        return  packageControllerInterface.delete(packagesId);
    }

    @GetMapping(path = "/getPackage", params = "packagesId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Package> getPackage(@RequestParam("packagesId") String packagesId) {
        return packageControllerInterface.getPackage(packagesId);
    }

    @GetMapping(path = "/fetchAllPackages", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll() {
        return  packageControllerInterface.getAll();
    }
}
