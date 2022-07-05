package com.usmertihsan.graduationProject.pol.service;
import com.usmertihsan.graduationProject.city.entity.CtyCity;
import com.usmertihsan.graduationProject.log.service.LogService;
import com.usmertihsan.graduationProject.pol.service.entityservice.PlPollutionEntityService;
import com.usmertihsan.graduationProject.polcategory.service.PlPollutionCategoryInfoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.text.ParseException;

@ExtendWith(MockitoExtension.class)
class PlPollutionServiceTest {

    @Mock
    private LogService logService;
    @Mock
    private PlPollutionCategoryInfoService plPollutionCategoryInfoService;

    @Mock
    private PlPollutionEntityService pollutionEntityService;

    @InjectMocks
    private PlPollutionService pollutionService;



    @Test
    void shouldGetAirPollutionComponentDetails() throws ParseException {

        // this function void
        // it checks getting details of air pollution data

        CtyCity city = new CtyCity();

        pollutionService.getAirPollutionComponentDetails(50.0,50.0,"25-05-2022","26-05-2022",city);
    }


    @Test
    void shouldDeleteAllData() {

        //this function also void and deletes all data of pollution -- test case

        pollutionService.deleteAllData();

    }
}