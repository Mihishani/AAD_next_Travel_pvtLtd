package lk.ijse.gdse63.guide_service.endpoints;

import lk.ijse.gdse63.guide_service.dto.GuidDTO;
import lk.ijse.gdse63.guide_service.response.Response;
import lk.ijse.gdse63.guide_service.service.custom.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@CrossOrigin
public class GuideController {
    @GetMapping(path = "/demo")
    public String getHello(){
        return "Helloooooo";
    }

    @Autowired
    private GuideService guideService;

    @PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response saveGuide(@RequestBody GuidDTO guidDTO){
        return guideService.save(guidDTO);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody GuidDTO guidDTO) {
        return guideService.update(guidDTO);
    }

    @GetMapping(path = "/search", params = "guideId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("guideId") String guideId) {
        return guideService.search(guideId);
    }

    @DeleteMapping(path = "/delete", params = "guideId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("guideId") String guideId) {
        return guideService.delete(guideId);
    }

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll() {
        return guideService.getAll();
    }
}
