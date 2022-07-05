package com.usmertihsan.graduationProject.city.controller;
import com.usmertihsan.graduationProject.city.service.CtyCityService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/air_pollutions")
public class CtyCityController {

    private final CtyCityService cityService;


    // that get mapping call, getting requested city's air pollution data in requested startDate between endDate
    // controls if start and end date null it gets last week information default.
    // second controls it check days valid or not
    @GetMapping("getAirPollutionDataForSpecificCity")
    public String getAirPollutionData(@RequestParam() String cityName,@RequestParam(required = false) String startDate, @RequestParam(required = false) String endDate) throws IOException, ParseException {

       String requestResponse = cityService.getAirPollutionData(cityName,startDate,endDate);
       return requestResponse;
    }


    // that function deletes all table records from db
    @DeleteMapping("deleteAllRecords")
    public String deleteAllRecords(){

        String response = cityService.deleteAllData();
        return response;
    }





}
