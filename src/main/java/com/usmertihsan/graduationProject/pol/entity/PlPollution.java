package com.usmertihsan.graduationProject.pol.entity;
import com.usmertihsan.graduationProject.city.entity.CtyCity;
import com.usmertihsan.graduationProject.gen.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.persistence.*;


@EntityScan
@Entity
@Getter
@Setter
@Table(name="POLLUTION")
public class PlPollution extends BaseEntity {

    @Id
    @SequenceGenerator(name ="PlPollution", sequenceName = "PL_POLLUTION_ID_SEQ")
    @GeneratedValue(generator = "PlPollution")
    private Long id;

    @Column(name = "CARBON_MONOXIDE_CO")
    private Double carbonMonoxide ;

    @Column(name="OZONE_03")
    private Double ozone ;

    @Column(name="SULPHUR_DIOXIDE_S02")
    private Double sulphurDioxide;

    @Column(name = "POLLUTION_INFO_DATE_UNIX_TIME")
    private Long pollutionDateUnixTime;

    @Column(name = "POLLUTION_INFO_DATE",length = 20)
    private String pollutionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CITY")
    private CtyCity city;

}
