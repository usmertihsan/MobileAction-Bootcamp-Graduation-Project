package com.usmertihsan.graduationProject.polcategory.service;

import com.usmertihsan.graduationProject.city.entity.CtyCity;
import com.usmertihsan.graduationProject.city.service.CtyCityService;
import com.usmertihsan.graduationProject.log.service.LogService;
import com.usmertihsan.graduationProject.pol.service.PlPollutionService;
import com.usmertihsan.graduationProject.pol.service.entityservice.PlPollutionEntityService;
import com.usmertihsan.graduationProject.polcategory.entity.PlPolCategoryInfo;
import com.usmertihsan.graduationProject.polcategory.service.entityservice.PlPollutionCategoryInfoEntityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PlPollutionCategoryInfoServiceTest {

    @Mock
    private CtyCityService cityService;
    @Mock
    private LogService logService;

    @Mock
    private PlPollutionCategoryInfoEntityService pollutionCategoryInfoEntityService;

    @InjectMocks
    private PlPollutionCategoryInfoService pollutionCategoryInfoService;

    @Test
    void shouldSavePollutionCategory() {
        //it checks pollution saving category in to db
        pollutionCategoryInfoService.savePollutionCategory(50.0,50.0,50.0,"25-05-2022","Ankara");

    }

    @Test
    void shouldGetPollutionInformation() throws ParseException {

        //it checks pollution information getting response
        String response = pollutionCategoryInfoService.getPollutionInformation("25-05-2022","Ankara","26-05-2022");
        Assertions.assertEquals(response,response);
    }

    @Test
    void shouldDeleteAllData() {
        // deletes all data of category info -- test case
        pollutionCategoryInfoService.deleteAllData();
    }
}