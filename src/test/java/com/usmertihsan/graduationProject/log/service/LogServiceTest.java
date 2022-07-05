package com.usmertihsan.graduationProject.log.service;

import com.usmertihsan.graduationProject.log.dto.LogDataDto;
import com.usmertihsan.graduationProject.log.entity.LogData;
import com.usmertihsan.graduationProject.log.service.entityservice.LogEntityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class LogServiceTest {

    @Mock
    private LogEntityService logEntityService;

    @InjectMocks
    private  LogService logService;

    @Test
    void log() {

        // test case of save request to db
        LogDataDto logDataDto = new LogDataDto();
        logService.log(logDataDto);
    }

    @Test
    void shouldLogDataSaveRequest() {

        // test case of save request

        LogDataDto logDataDto = new LogDataDto();
        logDataDto = logService.logDataSaveRequest("Ankara","API","25-05-2022");
        Assertions.assertSame(logDataDto ,logDataDto);
    }

    @Test
    void shouldDeleteAllData() {

        // delete all data of log table test case

        logService.deleteAllData();
    }
}