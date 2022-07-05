package com.usmertihsan.graduationProject.city.controller;

import com.usmertihsan.graduationProject.city.entity.CtyCity;
import com.usmertihsan.graduationProject.city.service.CtyCityService;
import com.usmertihsan.graduationProject.city.service.entityservice.CtyCityEntityService;
import com.usmertihsan.graduationProject.gen.util.StringDateUtil;
import com.usmertihsan.graduationProject.pol.service.PlPollutionService;
import com.usmertihsan.graduationProject.polcategory.service.PlPollutionCategoryInfoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CtyCityControllerTest {
    @Mock
    private StringDateUtil stringDateUtil;
    @Mock
    private PlPollutionCategoryInfoService plPollutionCategoryInfoService;

    @Mock
    private CtyCity city = new CtyCity();
    @Mock
    private CtyCityEntityService cityEntityService;
    @Mock
    private PlPollutionService pollutionService;
    @InjectMocks
    private CtyCityService cityService;
    @Test
    void getAirPollutionData() {

        // i got some errors in this function, i could not solve yet.
    }

    @Test
    void deleteAllRecords() {

        // deletes all tables records test case

        String response = cityService.deleteAllData();
        Assertions.assertEquals("All records of tables are deleted",response);
    }
}