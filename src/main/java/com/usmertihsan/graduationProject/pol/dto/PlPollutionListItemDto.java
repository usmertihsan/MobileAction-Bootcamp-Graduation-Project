package com.usmertihsan.graduationProject.pol.dto;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class PlPollutionListItemDto {

    private Long dt;
    private PlPollutionListItemComponentsDto components;

}
