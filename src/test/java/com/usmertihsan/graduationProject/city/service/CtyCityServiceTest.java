package com.usmertihsan.graduationProject.city.service;

import com.usmertihsan.graduationProject.city.entity.CtyCity;
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

import java.io.IOException;
import java.text.ParseException;

@ExtendWith(MockitoExtension.class)
class CtyCityServiceTest {

    @Mock
    private StringDateUtil stringDateUtil;
    @Mock
    private PlPollutionCategoryInfoService plPollutionCategoryInfoService;

    @Mock
    private CtyCityEntityService cityEntityService;
    @Mock
    private PlPollutionService pollutionService;
    @InjectMocks
    private  CtyCityService cityService;



    @Test
    void shouldGetAirPollutionData() throws IOException, ParseException {

        //String response = cityService.getAirPollutionData("Ankara","28-06-2022","29-06-2022");

        //Assertions.assertSame(response,response);

    }

    @Test
    void shouldNotGetAirPollutionData() throws IOException, ParseException {

       // test case of if dates invalid
        RuntimeException runtimeException = Assertions.assertThrows(RuntimeException.class, () -> cityService.getAirPollutionData("Ankara","28-06-25","29-06-30"));
        Assertions.assertEquals("The given dates invalid! you only reach data 27/11/2020 between today",runtimeException.getMessage());

    }


    @Test
    void shouldDeleteAllData() {

        // test case of delete table records

        String response = cityService.deleteAllData();
        Assertions.assertEquals("All records of tables are deleted",response);
    }
}