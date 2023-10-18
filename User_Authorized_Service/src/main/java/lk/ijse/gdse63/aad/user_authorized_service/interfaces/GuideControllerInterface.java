package lk.ijse.gdse63.aad.user_authorized_service.interfaces;


import lk.ijse.gdse63.aad.user_authorized_service.dto.GuidDTO;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "Guide_Service")
public interface GuideControllerInterface {

    @GetMapping(path = "/demo")
    String getHello();

    @PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response saveGuide(@RequestBody GuidDTO guideDTO);

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody GuidDTO guideDTO);

    @GetMapping(path = "/search", params = "guideId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("guideId") String guideId);

    @DeleteMapping(path = "/delete", params = "guideId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("guideId") String guideId);

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll();
}
