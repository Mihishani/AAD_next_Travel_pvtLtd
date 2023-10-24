package lk.ijse.gdse63.aad.user_authorized_service.endpoints;


import lk.ijse.gdse63.aad.user_authorized_service.dto.Guide_dto;
import lk.ijse.gdse63.aad.user_authorized_service.interfaces.GuideAuthfiegnInterface;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("")
public class Guide_api {

    @Autowired
    private GuideAuthfiegnInterface guideAuthfiegnInterface;



   @PostMapping(path = "Gsave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@RequestBody Guide_dto guideDto){
       System.out.println("Guide save"+guideDto.toString());
       return guideAuthfiegnInterface.saveGuide(guideDto);

   }

   @GetMapping(path = "Gget",params = "guideID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response get(@RequestParam("guideID") String guideID){
       System.out.println("Guide search"+guideID);
     return guideAuthfiegnInterface.get(guideID);
   }

   @PutMapping(path = "Gput",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
   public Response update(  @RequestBody Guide_dto guideDto){
       System.out.println("update guide"+guideDto.toString());
       return guideAuthfiegnInterface.saveGuide(guideDto);
   }

   @DeleteMapping(path = "Gdelete",params = "guideID",produces = MediaType.APPLICATION_JSON_VALUE)
   public Response delete(   @RequestParam("guideID") String guideID){
       System.out.println("Guide delete ok"+guideID);
       return guideAuthfiegnInterface.delete(guideID);
   }






}
