package lk.ijse.gdse63.aad.user_authorized_service.interfaces;


import lk.ijse.gdse63.aad.user_authorized_service.dto.Package_dto;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient("PACKAGE-SERVICE")
public interface PackageAuthfiegnInterface {



    @PostMapping(path = "/P_save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@RequestBody Package_dto packageDto);


    @PutMapping(path = "/P_put",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody Package_dto packageDto);

    @DeleteMapping(path = "/P_dlt",params = "P_id",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("P_id") String packageId);


    @GetMapping(path = "/P_search",params = "Package_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response  search(@RequestParam("Package_ID") String packageID);


}
