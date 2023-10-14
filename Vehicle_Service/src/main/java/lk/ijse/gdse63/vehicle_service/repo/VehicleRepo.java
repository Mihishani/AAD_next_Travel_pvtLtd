package lk.ijse.gdse63.vehicle_service.repo;

import lk.ijse.gdse63.vehicle_service.entity.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicles,String> {
}
