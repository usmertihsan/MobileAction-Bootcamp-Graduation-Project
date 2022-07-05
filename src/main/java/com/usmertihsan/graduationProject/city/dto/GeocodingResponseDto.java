package com.usmertihsan.graduationProject.city.dto;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Data
@Getter
public class GeocodingResponseDto {
    public  String name;
    private Double lat;
    private Double lon;
}
