package lk.ijse.gdse63.aad.user_authorized_service.interfaces;



import jakarta.validation.Valid;
import lk.ijse.gdse63.aad.user_authorized_service.dto.Guide_dto;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient("guide-service")
public interface GuideAuthfiegnInterface {



    @PostMapping(path = "/Gsave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response saveGuide(@RequestBody Guide_dto guideDto);


    @GetMapping(path = "Gget",params = "guideID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response get(@Valid @RequestParam("guideID") String guideID);
    @PutMapping(path = "Gput",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@Valid @RequestBody Guide_dto guideDto);

    @DeleteMapping(path = "Gdelete",params = "guideID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@Valid  @RequestParam("guideID") String guideID);


}
