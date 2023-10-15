package lk.ijse.gdse63.guide_service.repo;

import lk.ijse.gdse63.guide_service.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideRepo extends JpaRepository<Guide,String> {
}
