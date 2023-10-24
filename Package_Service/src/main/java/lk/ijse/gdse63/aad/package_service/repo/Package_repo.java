package lk.ijse.gdse63.aad.package_service.repo;


import lk.ijse.gdse63.aad.package_service.entity.Package_entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Package_repo extends JpaRepository<Package_entity,String> {
}
