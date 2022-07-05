package com.usmertihsan.graduationProject.city.service;
import com.usmertihsan.graduationProject.city.dto.GeocodingResponseDto;
import com.usmertihsan.graduationProject.city.entity.CtyCity;
import com.usmertihsan.graduationProject.city.service.entityservice.CtyCityEntityService;
import com.usmertihsan.graduationProject.gen.util.StringDateUtil;
import com.usmertihsan.graduationProject.pol.service.PlPollutionService;
import com.usmertihsan.graduationProject.polcategory.service.PlPollutionCategoryInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.text.ParseException;

@Service
@RequiredArgsConstructor
public class CtyCityService {

    private final String apiKey = "a8dc344f55476f27ec9c38f02a41b142";
    private final String geoURL = "http://api.openweathermap.org/geo/1.0/direct";
    private final PlPollutionService pollutionService;
    private final PlPollutionCategoryInfoService pollutionCategoryInfoService;
    private final CtyCityEntityService cityEntityService;
    private final RestTemplate restTemplate = new RestTemplate();


    // this function the main most crucial function
    // check dates valid or not and null check
    //if city not available call function and get city info from api
    //get city info and send function get air pollution info
    // and show the result to user
    public String getAirPollutionData(String cityName, String startDate, String endDate) throws ParseException {

        startDate = StringDateUtil.checkAndDefaultStartDay(startDate);
        endDate = StringDateUtil.checkAndDefaultEndDate(endDate);
        boolean isDateValid = StringDateUtil.compareDates(startDate,endDate);

        if(isDateValid)
        {
            CtyCity city = new CtyCity();
            if(cityEntityService.findByCityName(cityName)!=null)
            {
                city = cityEntityService.findByCityName(cityName);
            }
            else
            {
                city = getFromGeocodingApiCityDetails(cityName);
            }
            Double lat = city.getCityLatitude();
            Double lon = city.getCityLongitude();
            pollutionService.getAirPollutionComponentDetails(lat,lon,startDate,endDate, city);
        }
        else
        {
            throw new RuntimeException("Dates invalid!");
        }

        return pollutionCategoryInfoService.getPollutionInformation(startDate,cityName,endDate);
    }



    // this function gets city information from https://openweathermap.org/api/geocoding-api
    // saves to db
    private CtyCity getFromGeocodingApiCityDetails(String cityName) throws NullPointerException
    {
        // get city details from geocoding api
        GeocodingResponseDto[] geocodingResponseDto = restTemplate.getForObject(geoURL + "?q={q}&limit=1&appid={appid}", GeocodingResponseDto[].class, cityName, apiKey);
        CtyCity city = new CtyCity();
        // check if response dto null, if does not null so create new city.
        if(geocodingResponseDto[0]!=null)
        {
            city.setCityName(geocodingResponseDto[0].getName());
            city.setCityLatitude(geocodingResponseDto[0].getLat());
            city.setCityLongitude(geocodingResponseDto[0].getLon());
            city = cityEntityService.save(city);
        }
        else throw new RuntimeException("City information could not found"); // if geocodingResponseDto null
        return  city;
    }


    // delete all tables data from db
    public String deleteAllData() {

        pollutionService.deleteAllData();
        cityEntityService.deleteAll();
        return "All records of tables are deleted";
    }
}

