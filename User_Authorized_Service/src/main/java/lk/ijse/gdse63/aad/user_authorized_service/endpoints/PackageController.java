package lk.ijse.gdse63.aad.user_authorized_service.endpoints;

import lk.ijse.gdse63.aad.user_authorized_service.dto.PackageDTO;
import lk.ijse.gdse63.aad.user_authorized_service.interfaces.PackageControllerInterface;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/packages")
@CrossOrigin
public class PackageController {

    @Autowired
    private PackageControllerInterface packageControllerInterface;


    @PostMapping(path = "/save",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> add(@RequestBody PackageDTO packagesDTO){
        return  packageControllerInterface.save(packagesDTO);

    }
    @PutMapping(path = "/update",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>update(@RequestBody PackageDTO packagesDTO){
        return packageControllerInterface.update(packagesDTO);

    }
    @GetMapping(path = "/search",produces = MediaType.APPLICATION_JSON_VALUE,params = "packageID")
    public ResponseEntity<Response>search(@RequestParam("packageID")String packageID){
        return packageControllerInterface.search(packageID);

    }
    @DeleteMapping(path = "/delete",produces = MediaType.APPLICATION_JSON_VALUE,params = "packageID")
    public ResponseEntity<Response>delete(@RequestParam("packageID")String packageID){
        System.out.println("packageID = " + packageID);
        return packageControllerInterface.delete(packageID);

    }
    @GetMapping(path = "/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>getAll(){
        return  packageControllerInterface.getAllPackages();

    }
    @GetMapping(path = "/getAllIDs")
    public List<String> getAllPackageIDs(){
        return  packageControllerInterface.getAllPackageIDs();
    }
    @GetMapping(path = "/getPackageByCategory",produces = MediaType.APPLICATION_JSON_VALUE,params = "category")
    public ResponseEntity<Response>getPackageByCategory(@RequestParam("category")String category){
        return  packageControllerInterface.getPackageByCategory(category);

    }
}
