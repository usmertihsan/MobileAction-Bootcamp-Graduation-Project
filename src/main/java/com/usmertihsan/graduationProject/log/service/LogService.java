package com.usmertihsan.graduationProject.log.service;

import com.usmertihsan.graduationProject.log.dto.LogDataDto;
import com.usmertihsan.graduationProject.log.entity.LogData;
import com.usmertihsan.graduationProject.log.service.entityservice.LogEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LogService {

    private final LogEntityService logEntityService;


// this function save log to db and @Slf4j uses to log info to console
    public void log(LogDataDto logDataDto){

        LogData logData = new LogData();
        logData.setCityName(logDataDto.getCityName());
        logData.setDataComingFrom(logDataDto.getDataComingFrom());
        logData.setDataDate(logDataDto.getDataDate());
        log.info(logDataDto.getDataComingFrom());
        logEntityService.save(logData);

    }


    // log save request gathering from user
    public LogDataDto logDataSaveRequest(String cityName,String dataComeFrom, String dataDate)
    {
        LogDataDto logDataDto = new LogDataDto();
        logDataDto.setCityName(cityName);
        logDataDto.setDataComingFrom(dataComeFrom);
        logDataDto.setDataDate(dataDate);
        return logDataDto;
    }

    // delete all logs
    public void deleteAllData() {

        logEntityService.deleteAll();
    }

}
