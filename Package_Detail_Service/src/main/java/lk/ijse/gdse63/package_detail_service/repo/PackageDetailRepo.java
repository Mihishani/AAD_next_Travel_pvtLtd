package lk.ijse.gdse63.package_detail_service.repo;

import lk.ijse.gdse63.package_detail_service.entity.PackageDetail_entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageDetailRepo extends JpaRepository<PackageDetail_entity,String> {
}
