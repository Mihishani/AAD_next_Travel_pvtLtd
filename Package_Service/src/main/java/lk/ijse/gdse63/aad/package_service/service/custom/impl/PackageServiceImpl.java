package lk.ijse.gdse63.aad.package_service.service.custom.impl;

import lk.ijse.gdse63.aad.package_service.dto.Package_dto;
import lk.ijse.gdse63.aad.package_service.entity.Package_entity;
import lk.ijse.gdse63.aad.package_service.interfaces.PackageFiegnInterfaec;
import lk.ijse.gdse63.aad.package_service.repo.Package_repo;
import lk.ijse.gdse63.aad.package_service.response.Response;
import lk.ijse.gdse63.aad.package_service.service.custom.PackageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;



@Service
@Transactional
public class PackageServiceImpl implements PackageService {

    @Autowired
    private Package_repo packageRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Response response;



    //Rest templet for communication other servers
    //Fientclient , Service Discovery we use

    @Autowired
    private PackageFiegnInterfaec packageFiegnInterfaec;






    //-------------------------------------------------------



    @Override
    public ResponseEntity<Response> search(String id) {
        Optional<Package_entity>packageEntity=packageRepo.findById(id);
        if (packageEntity.isPresent()){
            return createAndSendResponse(HttpStatus.FOUND.value() ,"success",modelMapper.map(packageEntity.get(),Package_dto.class));
        }
        return createAndSendResponse(HttpStatus.NOT_EXTENDED.value(),"eorr",null);
    }

    @Override
    public ResponseEntity<Response> save(Package_dto packageDto) {
        if (search(packageDto.getPackage_id()).getBody().getData()==null){
            packageRepo.save(modelMapper.map(packageDto,Package_entity.class));
            return createAndSendResponse(HttpStatus.OK.value(),null,"Save OK");
        }
        throw new RuntimeException("Package not exits");
    }

    @Override
    public ResponseEntity<Response>  update(Package_dto packageDto) {
        if (search(packageDto.getPackage_id()).getBody().getData() !=null){
            packageRepo.save(modelMapper.map(packageDto,Package_entity.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Update OK!",null);
        }
        throw new RuntimeException("No found!");

    }

    @Override
    public ResponseEntity<Response>  delete(String id) {
        if (search(id).getBody().getData()!=null){
            packageRepo.deleteById(id);
            return createAndSendResponse(HttpStatus.OK.value(),null,"Delete OK");
        }
        throw new RuntimeException("Not found!");
    }

    @Override
    public ResponseEntity<Response>  getAll() {
        List<Package_entity>packageEntities=packageRepo.findAll();
        if (!packageEntities.isEmpty()){
            ArrayList<Package_dto> packageDtos=new ArrayList<>();
            packageEntities.forEach(packageEntity -> {
                packageDtos.add(modelMapper.map(packageEntity,Package_dto.class));
            });
            return createAndSendResponse(HttpStatus.FOUND.value(),"Success", packageDtos);
        }
        throw new RuntimeException("No found all");
    }

    @Override
    public ResponseEntity<Response> createAndSendResponse(int statusCode, String msg, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(msg);
        response.setData(data);
        System.out.println("Status Code : " + statusCode);
        System.out.println("Sent : " + HttpStatus.valueOf(statusCode));

        return new ResponseEntity<>(response, HttpStatusCode.valueOf(statusCode));

    }






    // testing
    public ResponseEntity<String> createVehicles(@RequestBody String id) {
        // You should pass the id to your Feign client to retrieve vehicle data
        List<String> vehicles = Collections.singletonList(packageFiegnInterfaec.getAllVehicles(id).getBody());

        Package_entity packageEntity=new Package_entity();
        packageEntity.setVehicalList(Collections.singletonList("V0124445"));
        // Here you can add logic to process the 'vehicles' data
        packageRepo.save(packageEntity);

        // If creation is successful, return a success response
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
