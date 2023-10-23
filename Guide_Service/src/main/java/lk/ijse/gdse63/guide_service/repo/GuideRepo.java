package lk.ijse.gdse63.guide_service.repo;

import lk.ijse.gdse63.guide_service.entity.Guide_entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuideRepo extends JpaRepository<Guide_entity,String> {
    Optional<Guide_entity> findByGuideName(String guideName);
}
