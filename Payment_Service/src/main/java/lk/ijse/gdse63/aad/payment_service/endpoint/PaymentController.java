package lk.ijse.gdse63.aad.payment_service.endpoint;

import lk.ijse.gdse63.aad.payment_service.dto.Payment_dto;
import lk.ijse.gdse63.aad.payment_service.response.Response;
import lk.ijse.gdse63.aad.payment_service.service.custom.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payment")
@CrossOrigin
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(path = "PGet",params = "PayID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> get(@RequestParam("PayID") String PayID){
        System.out.println("payment search");
        return paymentService.search(PayID);
    }

    @PostMapping(path = "/PSave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> save(@RequestBody Payment_dto paymentDto){
        System.out.println("save payment");
        return paymentService.save(paymentDto);
    }

    @PutMapping(path = "Pput",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> update(@RequestBody Payment_dto paymentDto){
        System.out.println("put payment");
        return paymentService.save(paymentDto);
    }

    @DeleteMapping(path = "Pdelet",params = "PayID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> delete(@RequestParam("PayID") String PayID){
        System.out.println("PayID delete ok");
        return paymentService.delete(PayID);
    }


}
