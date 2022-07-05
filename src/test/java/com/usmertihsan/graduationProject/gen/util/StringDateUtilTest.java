package com.usmertihsan.graduationProject.gen.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.text.ParseException;

class StringDateUtilTest {

    private final String testDate = "28-06-2022";

    private final String testEndDate = "30-06-2022";

    private final String invalidDate = "20-10-2019";

    @Test
    void shouldStartDateConvert() throws ParseException {

        //  change to  28-06-2022 00:00:00 and convert unixTime

        long testValue =  StringDateUtil.startDateConverter(testDate); // convert unixTime

        Assertions.assertEquals(1656374400,testValue);
    }

    @Test
    void shouldEndDateConvert() throws ParseException{

        // change to  28-06-2022 23:00:00 and convert unixTime

        long testValue =  StringDateUtil.endDateConverter(testDate);

        Assertions.assertEquals(1656457200,testValue);
    }

    @Test
    void shouldAddOneDayToDate() throws ParseException {
        // this fuction increase day one day
        // given string 28-06-2022 it has to return 29-06-2022

        String testValue = StringDateUtil.addOneDayToDate(testDate);
        Assertions.assertEquals("29-06-2022",testValue);
    }

    @Test
    void shouldHowManyDays() throws ParseException{

        //this function calculates how many days available between two given dates.
        long testValue = StringDateUtil.howManyDays(testDate,testEndDate);
        Assertions.assertEquals(2,testValue);
    }

    @Test
    void shouldCompareDates() throws ParseException {
        // this function checks the dates valid in range of 27-11-2020 between current day
        boolean isTrue;
        isTrue = StringDateUtil.compareDates(testDate,testEndDate);

        Assertions.assertTrue(true, String.valueOf(isTrue));

    }

    @Test
    void shouldCompareDatesAndGetException() throws ParseException {
        // this function checks the dates valid in range of 27-11-2020 between current day

        RuntimeException runtimeException = Assertions.assertThrows(RuntimeException.class, () -> StringDateUtil.compareDates(invalidDate,testEndDate));
        Assertions.assertEquals("The given dates invalid! you only reach data 27/11/2020 between today",runtimeException.getMessage());
    }


    @Test
    void shouldCheckAndDefaultStartDay() throws ParseException {

        //it should be return one week ago day
        //if you start this test case you should change expected values current day - 6
        String startDate =null;

        String testValue =StringDateUtil.checkAndDefaultStartDay(startDate);
        Assertions.assertEquals("28-06-2022",testValue);
    }

    @Test
    void shouldCheckAndDefaultEndDate() throws ParseException {

        //it should be return current day
        //if you start this test case you should change expected values current day
        String endDate =null;

        String testValue =StringDateUtil.checkAndDefaultEndDate(endDate);
        Assertions.assertEquals("04-07-2022",testValue);
    }
}