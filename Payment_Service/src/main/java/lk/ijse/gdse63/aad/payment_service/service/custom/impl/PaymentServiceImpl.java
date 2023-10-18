package lk.ijse.gdse63.aad.payment_service.service.custom.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse63.aad.payment_service.dto.PaymentDTO;
import lk.ijse.gdse63.aad.payment_service.entity.Payment;
import lk.ijse.gdse63.aad.payment_service.repo.PaymentRepo;
import lk.ijse.gdse63.aad.payment_service.response.Response;
import lk.ijse.gdse63.aad.payment_service.service.custom.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public Response savePayment(PaymentDTO paymentDTO) {
        if (search(paymentDTO.getPaymentId()).getData() == null) {
            paymentRepo.save(modelMapper.map(paymentDTO, Payment.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Payment Successfully saved!", null);
        }
        throw new RuntimeException("Payment does not exists!");
    }

    @Override
    public Response update(PaymentDTO paymentDTO) {
        if (search(paymentDTO.getPaymentId()).getData() != null) {
            paymentRepo.save(modelMapper.map(paymentDTO, Payment.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Payment Successfully updated!", null);
        }
        throw new RuntimeException("Payment does not exists!");

    }

    @Override
    public Response delete(String s) {
        if (search(s).getData() != null) {
            paymentRepo.deleteById(s);
            return createAndSendResponse(HttpStatus.OK.value(), "Payment Successfully deleted!", null);
        }
        throw new RuntimeException("Payment does not exists!");
    }

    @Override
    public Response search(String s) {
        Optional<Payment> payment = paymentRepo.findById(s);
        if (payment.isPresent()) {
            return createAndSendResponse(HttpStatus.FOUND.value(), "Payment Successfully retrieved!", modelMapper.map(payment.get(), PaymentDTO.class));
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Payment does not exists!", null);

    }

    @Override
    public PaymentDTO getPayment(String s) {
        Optional<Payment> payment = paymentRepo.findById(s);

        if (payment.isPresent()) {
            System.out.println(payment.get());
            return modelMapper.map(payment.get(), PaymentDTO.class);
        }
        throw new RuntimeException("payment cannot found!!!");

    }

    @Override
    public Response getAll() {
        List<Payment> payment = paymentRepo.findAll();
        if (!payment.isEmpty()) {
            ArrayList<PaymentDTO> payments_dtos = new ArrayList<>();
            payment.forEach((paymentss) -> {
                payments_dtos.add(modelMapper.map(paymentss, PaymentDTO.class));
            });
            return createAndSendResponse(HttpStatus.FOUND.value(), "Payments Successfully retrieved!", payments_dtos);
        }
        throw new RuntimeException("No Payments found in the database!");

    }

    @Override
    public Response createAndSendResponse(int statusCode, String message, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(message);
        response.setData(data);
        return response;
    }
}
