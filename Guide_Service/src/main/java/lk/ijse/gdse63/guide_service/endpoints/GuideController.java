package lk.ijse.gdse63.guide_service.endpoints;

import lk.ijse.gdse63.guide_service.dto.Guide_dto;
import lk.ijse.gdse63.guide_service.response.Response;
import lk.ijse.gdse63.guide_service.service.custom.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("guide/")
@CrossOrigin/*(origins = "http://localhost:8080")*/
public class GuideController {



    @Autowired
    private GuideService guideService;

    @PostMapping(path = "Gsave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveGuide(@RequestBody Guide_dto guideDto){
        System.out.println("Guide save controller"+guideDto.toString());
        return guideService.save(guideDto);

    }

    @GetMapping(path = "Gget",params = "guideID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity get(  @RequestParam("guideID") String guideID){
        System.out.println("Guide search"+guideID);
        return guideService.search(guideID);
    }

    @PutMapping(path = "Gput",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update( @RequestBody Guide_dto guideDto){
        System.out.println("update guide"+guideDto.toString());
        return guideService.update(guideDto);
    }

    @DeleteMapping(path = "Gdelete",params = "guideID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> delete(@RequestParam("guideID") String guideID){
       /* System.out.println("Guide delete ok"+guideID);*/
        return guideService.delete(guideID);
    }

    @GetMapping(path = "/getGuideByGuideName",params = "guideName",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>getGuideByName(@RequestParam("guideName")String guideName){
        return guideService.findByGuideName(guideName);


    }

/*
    @GetMapping(path = "/getGuideByGuideName",params = "guideName",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> findByGuideName(@RequestParam("guideName")String guideName){
        return guideService.getGuideByName(guideName);


    }
*/

    @GetMapping(path = "/getAllGuides",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>getAllGuides(){
        return  guideService.getAll();

    }


}
