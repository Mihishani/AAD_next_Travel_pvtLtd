package lk.ijse.gdse63.aad.hotel_service.repo;


import lk.ijse.gdse63.aad.hotel_service.entity.Hotel_entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Hotel_repo extends JpaRepository<Hotel_entity,String> {
   Optional<Hotel_entity> findByHotelName(String hotelName);

}
