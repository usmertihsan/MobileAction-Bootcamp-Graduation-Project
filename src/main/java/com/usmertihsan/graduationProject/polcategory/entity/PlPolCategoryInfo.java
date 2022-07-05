package com.usmertihsan.graduationProject.polcategory.entity;

import com.usmertihsan.graduationProject.gen.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@EntityScan
@Entity
@Getter
@Setter
@Table(name="POLLUTION_CATEGORY")
public class PlPolCategoryInfo extends BaseEntity {

    @Id
    @SequenceGenerator(name ="PlPolCategoryInfo", sequenceName = "PL_POLLUTION_CATEGORY_ID_SEQ")
    @GeneratedValue(generator = "PlPolCategoryInfo")
    private Long id;

    @Column(name="POLLUTION_DATE",length = 20)
    private String date;

    @Column(name="REQUEST_CITY",length = 20)
    private String cityName;

    @Column(name="CATEGORY_OZONE_03",length = 20)
    private String categoryOzone;

    @Column(name = "CATEGORY_CARBON_MONOXIDE_CO",length = 20)
    private String categoryCarbonMonoxide ;

    @Column(name="CATEGORY_SULPHUR_DIOXIDE_S02",length = 20)
    private String categorySulphurDioxide;

}
