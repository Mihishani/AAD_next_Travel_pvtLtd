package lk.ijse.gdse63.aad.user_authorized_service.endpoints;

import lk.ijse.gdse63.aad.user_authorized_service.dto.PackageDetailDTO;
import lk.ijse.gdse63.aad.user_authorized_service.interfaces.PackageDetailsControllerInterface;
import lk.ijse.gdse63.aad.user_authorized_service.model.Packagedetail;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/packagedetail")
@CrossOrigin
public class PackageDetailController {

    @Autowired
    private PackageDetailsControllerInterface packageDetailsControllerInterface;

    @PostMapping(path = "/spd", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response savePackageDetail(@RequestBody PackageDetailDTO packageDetailDTO) {
        return   packageDetailsControllerInterface.savePackageDetail(packageDetailDTO);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody PackageDetailDTO packageDetailDTO) {
        return  packageDetailsControllerInterface.update(packageDetailDTO);
    }

    @GetMapping(path = "/search", params = "packageDetailId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("packageDetailId") String packageDetailId) {
        return  packageDetailsControllerInterface.search(packageDetailId);
    }

    @DeleteMapping(path = "/delete", params = "packageDetailId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("packageDetailId") String packageDetailId) {
        return  packageDetailsControllerInterface.delete(packageDetailId);
    }

    @GetMapping(path = "/getPayment", params = "packageDetailId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Packagedetail> getPackageDetail(@RequestParam("packageDetailId") String packageDetailId) {
        return  packageDetailsControllerInterface.getPackageDetail(packageDetailId);
    }

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll() {
        return  packageDetailsControllerInterface.getAll();
    }
}
