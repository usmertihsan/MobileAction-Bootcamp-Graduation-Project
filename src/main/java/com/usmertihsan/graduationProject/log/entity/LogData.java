package com.usmertihsan.graduationProject.log.entity;

import com.usmertihsan.graduationProject.gen.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class LogData extends BaseEntity {

    @Id
    @SequenceGenerator(name ="LogData", sequenceName = "LOG_DATA_ID_SEQ")
    @GeneratedValue(generator = "LogData")
    private Long id;

    @Column(name = "CITY",length = 50)
    private String cityName;

    @Column(name = "DATA_COME",length = 30)
    private String dataComingFrom;

    @Column(name="DATE",length = 20)
    private String dataDate;
}
