package com.usmertihsan.graduationProject.pol.service;
import com.usmertihsan.graduationProject.city.entity.CtyCity;
import com.usmertihsan.graduationProject.gen.util.StringDateUtil;
import com.usmertihsan.graduationProject.log.dto.LogDataDto;
import com.usmertihsan.graduationProject.log.service.LogService;
import com.usmertihsan.graduationProject.pol.dto.PlPollutionResponseDto;
import com.usmertihsan.graduationProject.pol.entity.PlPollution;
import com.usmertihsan.graduationProject.pol.service.entityservice.PlPollutionEntityService;
import com.usmertihsan.graduationProject.polcategory.service.PlPollutionCategoryInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.text.ParseException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class PlPollutionService {
    private final String apiKey = "a8dc344f55476f27ec9c38f02a41b142";
    private final PlPollutionEntityService pollutionEntityService;
    private final LogService logService;
    private final PlPollutionCategoryInfoService plPollutionCategoryInfoService;
    private final RestTemplate restTemplate = new RestTemplate();

    // that function getting air pollution requested city, it gets info from https://openweathermap.org/api/air-pollution#history
    // dates converted to unix time format
    public void getAirPollutionComponentDetails(Double lat , Double lon , String startDate, String endDate, CtyCity city) throws ParseException, NullPointerException{

        long startUnixTime = StringDateUtil.startDateConverter(startDate);
        long endUnixTime = StringDateUtil.endDateConverter(endDate);
        String URL = "http://api.openweathermap.org/data/2.5/air_pollution/history?lat="+lat+"&lon="+lon+"&start="+startUnixTime+"&end="+endUnixTime+"&appid="+ apiKey;
        ResponseEntity<PlPollutionResponseDto> pollutionResponseDto = restTemplate.getForEntity(URL, PlPollutionResponseDto.class);
        Integer sizeOfRequestData = pollutionResponseDto.getBody().getList().size();
        savePollutionInformation(startDate,sizeOfRequestData,pollutionResponseDto,city,endDate);
    }


    // this function saving air pollution record to db
    // controls if record already exist in db, it does not save that information ( barrier to redundancy)
    // logging process in use here
    // total calculation of co,so2,o3
    // one day include 24 hours, data comes hourly so all data must be save independently it gets mod % 24 for start new day
    private void savePollutionInformation(String startDate,Integer sizeOfRequestData,ResponseEntity<PlPollutionResponseDto> pollutionResponseDto,CtyCity city,String endDate ) throws ParseException{

        Integer dayCounter = 0;
        Double co= Double.valueOf(0);
        Double so2=Double.valueOf(0);
        Double o3= Double.valueOf(0);
        LogDataDto logDataDto = new LogDataDto();

        for (Integer index=0;index<sizeOfRequestData;index++)
        {
            PlPollution pollution = new PlPollution();
            if(isDateInfoExist(pollutionResponseDto.getBody().getList().get(index).getDt(),city)==true)
            {
                pollution.setPollutionDateUnixTime(pollutionResponseDto.getBody().getList().get(index).getDt());
                pollution.setCarbonMonoxide(pollutionResponseDto.getBody().getList().get(index).getComponents().getCo());
                pollution.setOzone(pollutionResponseDto.getBody().getList().get(index).getComponents().getO3());
                pollution.setSulphurDioxide(pollutionResponseDto.getBody().getList().get(index).getComponents().getSo2());
                pollution.setCity(city);
                pollution.setPollutionDate(startDate);
                dayCounter++;
                co += pollutionResponseDto.getBody().getList().get(index).getComponents().getCo();
                so2 +=pollutionResponseDto.getBody().getList().get(index).getComponents().getSo2();
                o3 +=pollutionResponseDto.getBody().getList().get(index).getComponents().getO3();

                if(dayCounter% 24==0)
                {
                     logDataDto = logService.logDataSaveRequest(city.getCityName(),"FROM API",startDate);
                     logService.log(logDataDto);
                     plPollutionCategoryInfoService.savePollutionCategory(o3,so2,co,startDate, city.getCityName());
                     co= Double.valueOf(0);
                     so2=Double.valueOf(0);
                     o3= Double.valueOf(0);
                     dayCounter = 0;
                     startDate = StringDateUtil.addOneDayToDate(startDate);
                }
                pollution = pollutionEntityService.save(pollution);
            }
            else
            {
                if(index% 24==0)
                {
                    logDataDto = logService.logDataSaveRequest(city.getCityName(),"FROM DATABASE",startDate);
                    logService.log(logDataDto);
                    startDate = StringDateUtil.addOneDayToDate(startDate);
                }
            }
        }
    }



    // that function controls the data if already exist in database
    private Boolean isDateInfoExist(Long unixTime, CtyCity city)
    {
        // this function checks if data is already exist in database, if in database sends false , otherwise true
        List<PlPollution> pollutionList = new ArrayList<>();

        Boolean isExist = true;

        if(pollutionEntityService.findByPollutionDateUnixTime(unixTime)!=null)
        {
            pollutionList = pollutionEntityService.findByPollutionDateUnixTime(unixTime);
        }
        else
        {
            return isExist;
        }

        for (PlPollution pollution  : pollutionList) {
            if(pollution.getCity().getId()==city.getId())
            {
                isExist=false;
            }
        }

        return isExist;
    }

    // delete all data
    public void deleteAllData() {

        pollutionEntityService.deleteAll();
        plPollutionCategoryInfoService.deleteAllData();
        logService.deleteAllData();
    }


}
