package lk.ijse.gdse63.guide_service.repo;

import lk.ijse.gdse63.guide_service.entity.Guide_entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GuideRepo extends JpaRepository<Guide_entity,String> {

    @Query("SELECT g FROM Guide_entity  g WHERE g.guideName = : guideName")
   /*  Guide_entity   findGuideByname(@Param("username") String guideName);*/


    Optional<Guide_entity> findByGuideName(String guideName);


}
