package com.usmertihsan.graduationProject.gen.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class StringDateUtil {

    public static long startDateConverter(String startDate) throws ParseException
    {
        //it gets string of time from user and sends to formatter function
        String additionalStartDate =startDate+" 00:00:00";
        long startDateUnixTime = unixDateFormatter(additionalStartDate);
        return startDateUnixTime;
    }

    public static long endDateConverter(String endDate) throws ParseException
    {
        //it gets string of time from user and sends to formatter function
        String additionalEndDate =endDate+" 23:00:00";
        long endDateUnixTime = unixDateFormatter(additionalEndDate);

        return endDateUnixTime;
    }

    private static long unixDateFormatter(String convertDate) throws ParseException
    {
        // because of the openWeather api , time must be reformatted to unix time, UTC time zone
        // for example convertion: from(dateConverter function sends 26-05-2022 --->  26-05-2022 23:00:00)  ---> 1656201600
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = df.parse(convertDate);
        long unixTime = date.getTime()/1000;
        return unixTime;
    }

    public static String addOneDayToDate(String originalDate) throws ParseException
    {
        // the function that increase  day by one for saving database
        SimpleDateFormat dateFormat = new SimpleDateFormat( "dd-MM-yyyy" );
        Calendar cal = Calendar.getInstance();
        cal.setTime( dateFormat.parse(originalDate));
        cal.add( Calendar.DATE, 1 );
        String convertedDate=dateFormat.format(cal.getTime());
        return convertedDate;
    }

    public static long howManyDays(String startDate,String endDate) throws ParseException
    {
// Convert `String` to `Date`
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date dateBefore = sdf.parse(startDate);
        Date dateAfter = sdf.parse(endDate);
// Calculate the number of days between dates
        long timeDiff = Math.abs(dateAfter.getTime() - dateBefore.getTime());
        long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
        System.out.println("The number of days between dates: " + daysDiff);
        return daysDiff;
    }


    public static boolean compareDates(String start,String end) throws ParseException
    {
        // this function checks request days are valid or not. For example the openweather api gives data after 27/11/2020
        // it controls dates between 27/11/200 and today date or not
        String originalStarter="26-11-2020";
        String current = getCurrentDay();

        // Create 4 dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date originalStarterDate = dateFormat.parse(originalStarter);
        Date startDate = dateFormat.parse(start);
        Date endDate =dateFormat.parse(end);
        Date currentDay=dateFormat.parse(current);

        // Date object is having 3 methods namely after,before and equals for comparing
        // after() and before() if it true then will return true
        if(startDate.after(originalStarterDate) && endDate.before(currentDay) ){
            return true;
        }
        else
        {
            //if given dates invalid.
            throw new RuntimeException("The given dates invalid! you only reach data 27/11/2020 between today");
        }

    }

    // getting current day
    private static String getCurrentDay()
    {
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy" );
        dateObj = dateObj.plusDays(1);
        String date = dateObj.format(formatter);
        System.out.println(date);
        return date;
    }


    // it checks if startDate null give one week ago date
    public static String checkAndDefaultStartDay(String startDate)
    {
        if(startDate==null)
        {
            LocalDate dateObj = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy" );
            dateObj = dateObj.minusDays(6);
            startDate = dateObj.format(formatter);
        }

        return startDate;
    }

    // it checks if endDate null give one week ago date
    public static String checkAndDefaultEndDate(String endDate)
    {
        if(endDate==null)
        {
            LocalDate dateObj = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy" );
            endDate = dateObj.format(formatter);
        }
        return endDate;
    }


}
