package lk.ijse.gdse63.aad.hotel_service.repo;

import lk.ijse.gdse63.aad.hotel_service.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelRepo extends JpaRepository<Hotel,String> {
    Optional<Hotel> findByHotelName(String hotelName);
}
