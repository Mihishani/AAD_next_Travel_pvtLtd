package lk.ijse.gdse63.aad.package_service.endpoint;


import lk.ijse.gdse63.aad.package_service.dto.Package_dto;
import lk.ijse.gdse63.aad.package_service.response.Response;
import lk.ijse.gdse63.aad.package_service.service.custom.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/package")
@CrossOrigin(origins = "http://localhost:8080")
public class PackageController {

    PackageController(){
        System.out.println("Package_api_working_on!!!");
    }

    @Autowired
    private PackageService packageService;



    @GetMapping("/check")
    public String getCheck_package(){
        return "Package API Running";
    }

    @PostMapping(path = "/P_save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> save(@RequestBody Package_dto packageDto){
        System.out.println("Package save working");
        return packageService.save(packageDto);
    }

    @PutMapping(path = "/P_put",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> update(@RequestBody Package_dto packageDto){
        System.out.println("Package update working");
        return packageService.update(packageDto);
    }

    @DeleteMapping(path = "/P_dlt",params = "P_id",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> delete(@RequestParam("P_id") String packageId){
        return packageService.delete(packageId);
    }

    @GetMapping(path = "/P_search",params = "Package_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>  search(@RequestParam("Package_ID") String packageID){
        return packageService.search(packageID);
    }

}
