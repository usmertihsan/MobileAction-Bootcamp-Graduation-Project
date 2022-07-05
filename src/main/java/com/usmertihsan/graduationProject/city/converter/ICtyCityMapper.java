package com.usmertihsan.graduationProject.city.converter;

import com.usmertihsan.graduationProject.city.dto.GeocodingResponseDto;
import com.usmertihsan.graduationProject.city.entity.CtyCity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICtyCityMapper {

    ICtyCityMapper INSTANCE = Mappers.getMapper(ICtyCityMapper.class);

    CtyCity[] convertToCity(GeocodingResponseDto[] geocodingResponseDto);
}
