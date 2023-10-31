package lk.ijse.gdse63.aad.payment_service.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse63.aad.payment_service.dto.Payment_dto;
import lk.ijse.gdse63.aad.payment_service.entity.Payment_entity;
import lk.ijse.gdse63.aad.payment_service.repo.PaymentRepo;
import lk.ijse.gdse63.aad.payment_service.response.Response;
import lk.ijse.gdse63.aad.payment_service.service.custom.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private Response response;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PaymentRepo paymentRepo;



    @Override
    public ResponseEntity<Response> search(String id) {
        Optional<Payment_entity>paymentEntity=paymentRepo.findById(id);
        if (paymentEntity.isPresent()){
            return createAndSendResponse(HttpStatus.FOUND.value(), "Sucess",modelMapper.map(paymentEntity.get(), Payment_dto.class));
        }
        return createAndSendResponse(HttpStatus.NOT_EXTENDED.value(), null,"No serch found Payment");
    }

    @Override
    public ResponseEntity<Response> save(Payment_dto paymentDto) {
      /*  if (search(paymentDto.getPayID()).getBody().getData()==null){
            paymentRepo.save(modelMapper.map(paymentDto,Payment_entity.class));
            return createAndSendResponse(HttpStatus.CREATED.value(), "save payment" ,true);
        }
        throw new RuntimeException(" no save payment");
      *//*  return createAndSendResponse(HttpStatus.CONFLICT.value(), "No save payment!", false);*/

        if (search(paymentDto.getPayID()).getBody().getData()==null){
            paymentRepo.save(modelMapper.map(paymentDto,Payment_entity.class));
            return createAndSendResponse(HttpStatus.OK.value(),"Success", null);
        }
        throw new RuntimeException(" no save payment");
    }

    @Override
    public ResponseEntity<Response> update(Payment_dto paymentDto) {
        if (search(paymentDto.getPayID()).getBody().getData()!=null){
            paymentRepo.save(modelMapper.map(paymentDto,Payment_entity.class));
            return createAndSendResponse(HttpStatus.OK.value(),null,"update payment");
        }
        throw new RuntimeException(" no update payment");
    }

    @Override
    public ResponseEntity<Response> delete(String id) {
        if (search(id).getBody().getData()!=null){
            paymentRepo.deleteById(id);
            return  createAndSendResponse(HttpStatus.OK.value(), null,"delete payment ok");
        }
        throw new RuntimeException("No delete payment");
    }

    @Override
    public ResponseEntity<Response> getAll() {
        List<Payment_entity> paymentEntityList=paymentRepo.findAll();
        if (!paymentEntityList.isEmpty()){
            ArrayList<Payment_dto> paymentDtos=new ArrayList<>();
            paymentEntityList.forEach(paymentEntity -> {
                paymentDtos.add(modelMapper.map(paymentEntity,Payment_dto.class));
            });
            return createAndSendResponse(HttpStatus.OK.value(), null,"found all ok");
        }
        throw new RuntimeException("not work get all payment");

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
