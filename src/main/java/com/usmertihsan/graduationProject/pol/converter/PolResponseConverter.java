package com.usmertihsan.graduationProject.pol.converter;

import com.usmertihsan.graduationProject.city.entity.CtyCity;
import com.usmertihsan.graduationProject.pol.dto.PlPollutionResponseDto;
import com.usmertihsan.graduationProject.pol.entity.PlPollution;
import com.usmertihsan.graduationProject.pol.service.entityservice.PlPollutionEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
public class PolResponseConverter implements IPolResponseConverter{

    private  final PlPollutionEntityService pollutionEntityService;

    private final IPolResponseConverter polResponseConverter = new IPolResponseConverter() {
        @Override
        public void savePollution(ResponseEntity<PlPollutionResponseDto> pollutionResponseDto, CtyCity city, String startDate, Integer index) {

        }
    };
    public void savePollution(ResponseEntity<PlPollutionResponseDto> pollutionResponseDto, CtyCity city, String startDate, Integer index)

    {
        PlPollution pollution = new PlPollution();
        pollution.setPollutionDateUnixTime(pollutionResponseDto.getBody().getList().get(index).getDt());
        pollution.setCarbonMonoxide(pollutionResponseDto.getBody().getList().get(index).getComponents().getCo());
        pollution.setOzone(pollutionResponseDto.getBody().getList().get(index).getComponents().getO3());
        pollution.setSulphurDioxide(pollutionResponseDto.getBody().getList().get(index).getComponents().getSo2());
        pollution.setCity(city);
        pollution.setPollutionDate(startDate);
        pollution = pollutionEntityService.save(pollution);
    }
}
