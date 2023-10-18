package lk.ijse.gdse63.aad.user_authorized_service.interfaces;

import lk.ijse.gdse63.aad.user_authorized_service.dto.PackageDTO;
import lk.ijse.gdse63.aad.user_authorized_service.model.Package;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(name ="Package_Service")
public interface PackageControllerInterface {
    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@RequestBody PackageDTO packageDTO);

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody PackageDTO packageDTO);

    @GetMapping(path = "/search", params = "packagesId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("packagesId") String packagesId);

    @DeleteMapping(path = "/delete", params = "packagesId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("packagesId") String packagesId);

    @GetMapping(path = "/getPackage", params = "packagesId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Package> getPackage(@RequestParam("packagesId") String packagesId);

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll();
}
