package com.usmertihsan.graduationProject.pol.dto;
import lombok.Data;
import lombok.Getter;
import java.util.List;

@Data
@Getter
public class PlPollutionResponseDto {
    private List<PlPollutionListItemDto> list;
}
