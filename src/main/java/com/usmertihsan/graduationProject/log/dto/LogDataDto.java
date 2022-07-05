package com.usmertihsan.graduationProject.log.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class LogDataDto {

    private String cityName;
    private String dataComingFrom;
    private String dataDate;
}
