package lk.ijse.gdse63.aad.hotel_service.repo;

import lk.ijse.gdse63.aad.hotel_service.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel,String> {
}
