package lk.ijse.gdse63.aad.payment_service.repo;

import lk.ijse.gdse63.aad.payment_service.entity.Payment_entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment_entity,String> {
}
