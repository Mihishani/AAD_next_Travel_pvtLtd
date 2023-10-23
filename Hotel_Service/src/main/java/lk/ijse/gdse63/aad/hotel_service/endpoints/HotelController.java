package lk.ijse.gdse63.aad.hotel_service.endpoints;

import lk.ijse.gdse63.aad.hotel_service.dto.HotelDTO;
import lk.ijse.gdse63.aad.hotel_service.interfaces.PackageControllerInterface;
import lk.ijse.gdse63.aad.hotel_service.response.Response;
import lk.ijse.gdse63.aad.hotel_service.service.custom.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@CrossOrigin
public class HotelController {
/*
    @GetMapping(path = "/demo")
    public String getHello(){
        return "Helloooooo";
    }
*/

    @Autowired
    private HotelService hotelService;

    @Autowired
    private PackageControllerInterface packageControllerInterface;

    @PostMapping(path = "/saveHotel", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> saveHotel(@RequestBody HotelDTO hotelDTO) {
        return hotelService.add(hotelDTO);


    }

    @PutMapping(path = "/updateHotel", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> updateHotel(@RequestBody HotelDTO hotelDTO) {
        return hotelService.update(hotelDTO);

    }

    @GetMapping(path = "/searchHotel", params = "hotelID", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> searchHotel(@RequestParam("hotelID") String hotelID) {
        return hotelService.search(hotelID);

    }

    @DeleteMapping(path = "/deleteHotel", params = "hotelID", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> deleteHotel(@RequestParam("hotelID") String hotelID) {
        ResponseEntity<Response> response = searchHotel(hotelID);
        HotelDTO hotelDTO = (HotelDTO) response.getBody().getData();
        hotelService.delete(hotelID);
        return packageControllerInterface.deleteHotelID(hotelDTO.getPackageId(), hotelDTO.getHotelId());

    }

    @GetMapping(path = "/getAllHotels", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getAllHotels() {
        return hotelService.getAll();

    }

    @DeleteMapping(path = "/deleteAllHotels", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> deleteAllHotels(@RequestBody List<String> hotelIDs) {
        return hotelService.deleteAllHotels(hotelIDs);

    }

    @GetMapping(path = "/getHotelByHotelName", params = "hotelName", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getHotelByName(@RequestParam("hotelName") String hotelName) {
        return hotelService.findByHotelName(hotelName);


    }
}
