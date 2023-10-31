package lk.ijse.gdse63.aad.package_service.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Package_entity {

    @Id

    private String package_id;

    private String packageCategory;

    private String  vehicalCate;

    private String hotelCate;

    @ElementCollection
    private List<String> hotel_list;

    @ElementCollection//we cant use many to one
    private List<String> VehicalList;





}
