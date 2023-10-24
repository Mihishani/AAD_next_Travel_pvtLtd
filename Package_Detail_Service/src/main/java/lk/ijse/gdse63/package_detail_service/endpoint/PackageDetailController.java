package lk.ijse.gdse63.package_detail_service.endpoint;

import lk.ijse.gdse63.package_detail_service.dto.PackageDetailDTO;
import lk.ijse.gdse63.package_detail_service.response.Response;
import lk.ijse.gdse63.package_detail_service.service.custom.PackageDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/packageDetail")
@CrossOrigin(origins = "http://localhost:8080")
public class PackageDetailController {
 /*   @GetMapping(path = "/demo")
    public String getHello(){
        return "Helloooooo";
    }*/

    @Autowired
    private PackageDetailService packageDetailService;

    @GetMapping("check")
    public String getCheck(){
        return "Checked OK packageDetails";
    }

    @PostMapping(path = "save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> save(@RequestBody PackageDetailDTO packageDetailsDto){
        return packageDetailService.save(packageDetailsDto);
    }

    @PutMapping(path = "put",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> update(@RequestBody PackageDetailDTO packageDetailsDto){
        return packageDetailService.update(packageDetailsDto);
    }


    @DeleteMapping(path = "delete",params = "PkID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> delete(@RequestParam("PkID") String PkID){
        return packageDetailService.delete(PkID);
    }

    @GetMapping(path = "get",params = "PkID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> search(@RequestParam("PkID")String PkID){
        return packageDetailService.search(PkID);
    }

}
