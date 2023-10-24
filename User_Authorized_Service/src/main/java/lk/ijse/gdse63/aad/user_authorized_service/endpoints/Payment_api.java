package lk.ijse.gdse63.aad.user_authorized_service.endpoints;



import lk.ijse.gdse63.aad.user_authorized_service.dto.Payment_dto;
import lk.ijse.gdse63.aad.user_authorized_service.interfaces.PayemtAuthfiegnInterface;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Payment")
@CrossOrigin
public class Payment_api {

    @Autowired
    private PayemtAuthfiegnInterface payemtAuthfiegnInterface;


    @GetMapping(path = "PGet",params = "PayID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("PayID") String PayID){
        System.out.println("payment search");
        return payemtAuthfiegnInterface.search(PayID);
    }

    @PostMapping(path = "PSave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@RequestBody Payment_dto paymentDto){
        System.out.println("save payment");
        return payemtAuthfiegnInterface.save(paymentDto);
    }

    @PutMapping(path = "Pput",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody Payment_dto paymentDto){
        System.out.println("put payment");
        return payemtAuthfiegnInterface.save(paymentDto);
    }

    @DeleteMapping(path = "Pdelet",params = "PayID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("PayID") String PayID){
        System.out.println("PayID delete ok");
        return payemtAuthfiegnInterface.delete(PayID);
    }



}
