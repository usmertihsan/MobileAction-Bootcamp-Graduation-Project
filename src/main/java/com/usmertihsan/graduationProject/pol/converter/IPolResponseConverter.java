package com.usmertihsan.graduationProject.pol.converter;

import com.usmertihsan.graduationProject.city.entity.CtyCity;
import com.usmertihsan.graduationProject.pol.dto.PlPollutionResponseDto;
import org.springframework.http.ResponseEntity;

public interface IPolResponseConverter {

   void savePollution(ResponseEntity<PlPollutionResponseDto> pollutionResponseDto, CtyCity city, String startDate, Integer index);
}
