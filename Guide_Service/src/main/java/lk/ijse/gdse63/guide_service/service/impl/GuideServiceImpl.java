package lk.ijse.gdse63.guide_service.service.impl;

import lk.ijse.gdse63.guide_service.dto.Guide_dto;
import lk.ijse.gdse63.guide_service.entity.Guide_entity;
import lk.ijse.gdse63.guide_service.repo.GuideRepo;
import lk.ijse.gdse63.guide_service.response.Response;
import lk.ijse.gdse63.guide_service.service.custom.GuideService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class GuideServiceImpl implements GuideService {


    @Autowired
    private GuideRepo guideRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Response response;

    @Override
    public ResponseEntity<Response> search(String id) {
        Optional<Guide_entity>guideEntity=guideRepo.findById(id);
        if (guideEntity.isPresent()){
            return createAndSendResponse(HttpStatus.FOUND.value(),"Success service",modelMapper.map(guideEntity.get(), Guide_dto.class));
        }
        return createAndSendResponse(HttpStatus.NOT_EXTENDED.value(), "Error",null);
    }

    @Override
    public ResponseEntity<Response> save(Guide_dto guideDto) {
        if (search(guideDto.getGuideID()).getBody().getData()==null){
            guideRepo.save(modelMapper.map(guideDto,Guide_entity.class));
            return createAndSendResponse(HttpStatus.OK.value(),"Success", null);
        }
        throw new RuntimeException(" no save guide");
    }

    @Override
    public ResponseEntity<Response> update(Guide_dto guideDto) {
       /* if (search(guideDto.getGuideID()).getBody().getData()!=null){
            guideRepo.save(modelMapper.map(guideDto,Guide_entity.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Success",null);
        }
        throw new RuntimeException("No update found guide");*/

        Optional<Guide_entity> existingVehicle = guideRepo.findById(guideDto.getGuideID());

        if (existingVehicle.isPresent()) {
            // The vehicle with the given ID exists, so update it
            Guide_entity updatedEntity = modelMapper.map( guideDto, Guide_entity .class);
            updatedEntity.setGuideID( guideDto.getGuideID()); // Set the ID to ensure an update
            guideRepo.save(updatedEntity);
            return createAndSendResponse(HttpStatus.OK.value(), null, "Guide updated successfully");
        } else {
            // The vehicle with the given ID does not exist, so create a new entry
            Guide_entity newEntity = modelMapper.map( guideDto , Guide_entity  .class);
            guideRepo.save(newEntity);
            return createAndSendResponse(HttpStatus.OK.value(), null, "Guide created successfully");
        }
    }

    @Override
    public ResponseEntity<Response> findByGuideName(String guideName) {
        Optional<Guide_entity> guideEntity = guideRepo.findByGuideName(guideName);
        if (guideEntity.isPresent()) {
            return createAndSendResponse(HttpStatus.OK.value(), "Hotel Successfully retrieved!", modelMapper.map(guideEntity.get(), Guide_dto.class));

        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Guide Not Found!", null);
    }

/*    public ResponseEntity<Response> getGuideByName(String vehicleBrand) {
        Guide_entity guide_entity =  guideRepo.findGuideByname(vehicleBrand);
        System.out.println(guide_entity);

         Guide_dto guide_dto = modelMapper.map(guide_entity,  Guide_dto.class);

        if (guide_dto != null){
            return createAndSendResponse(HttpStatus.OK.value(), "success!", guide_dto);
        }
        throw new RuntimeException("Guide cannot find!!");
    }*/


    @Override
    public ResponseEntity<Response> delete(String id) {
        if (search(id).getBody().getData()!=null){
            guideRepo.deleteById(id);
            return createAndSendResponse(HttpStatus.OK.value(),"Sucess delete guide",null);
        }
        throw new RuntimeException("no delete in guide");

       /* if (search(id).getBody().getData() == null) {
            return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "guide  Not Found!", null);

        }
        guideRepo.deleteById(id);
        return createAndSendResponse(HttpStatus.OK.value(), "guide Successfully deleted!", null);
*/

    }

    @Override
    public ResponseEntity<Response> getAll() {
      /*  List<Guide_entity>guideEntities = guideRepo.findAll();
        if (guideEntities.isEmpty()){
            ArrayList<Guide_dto> arrayList =new ArrayList<>();
            guideEntities.forEach(guideEntity -> {
                arrayList.add(modelMapper.map(guideEntity,Guide_dto.class));
            });
            return createAndSendResponse(HttpStatus.OK.value(), "Find all Success",null);
        }
        throw new RuntimeException("Find guide all error");*/

        List<Guide_entity> guides = guideRepo.findAll();
        if (!guides.isEmpty()) {
            ArrayList<Guide_dto> guides_dtos = new ArrayList<>();
            guides.forEach((guidess) -> {
                guides_dtos.add(modelMapper.map(guidess, Guide_dto.class));
            });
            return createAndSendResponse(HttpStatus.FOUND.value(), "Guides Successfully retrieved!", guides_dtos);
        }
        throw new RuntimeException("No Guides found in the database!");

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


}
