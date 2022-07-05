package com.usmertihsan.graduationProject.city.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.usmertihsan.graduationProject.gen.entity.BaseEntity;
import com.usmertihsan.graduationProject.pol.entity.PlPollution;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class CtyCity extends BaseEntity {

    @Id
    @SequenceGenerator(name ="CtyCity", sequenceName = "CTY_CITY_ID_SEQ")
    @GeneratedValue(generator = "CtyCity")
    private Long id;

    @Column(name = "CITY_NAME",length = 25)
    private String cityName;

    @Column(name = "CITY_LAT")
    private Double cityLatitude;

    @Column(name="CITY_LON")
    private Double cityLongitude;

}
