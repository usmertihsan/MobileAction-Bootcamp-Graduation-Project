# MobileAction-Bootcamp-Graduation-Project

## Project Description 

The required data will be gathered via the https://openweathermap.org/api.
Data on air pollution by the names of the cities and the range of dates
a Restfull in which the information will be read and saved to the database.
Spring Boot Framework will be applied to the application.

## Technologies
Project is created with:
* Java 11
* Spring Framework
* Hibernate
* Postgresql
* Intellij idea
* Junit 5

## Scope of Functionalities 

:pushpin: City informations gathered from (https://openweathermap.org/api/geocoding-api) :white_check_mark:

:pushpin: Air pollution informations gathered from (https://openweathermap.org/api/air-pollution#history) :white_check_mark:

:pushpin: Air pollution categories classify that according to table of “AQI Category,
Pollutants and Health Breakpoints”
from (https://en.wikipedia.org/wiki/Air_quality_index#CAQI) :white_check_mark:

:pushpin: Air pollution data only contains Carbon monoxide (CO), Ozone (O3), Sulphur dioxide (SO2)  :white_check_mark:

:pushpin: User can request query with city name and date range :white_check_mark:

:pushpin: Previously existing records in the database can be deleted. :white_check_mark:

:pushpin: If the desired date is available in the database, it was taken from the database. If it is not in the database, it is saved to the database via the API. :white_check_mark:

:pushpin: City name is must. Date range is default one week range. :white_check_mark:

:pushpin: Using a historical data access API, from November 27, 2020, to the present 
The date range was discovered to be wrong for entries made outside of these dates, and an error message was provided. :white_check_mark:

:pushpin: Using the log mechanism, it is recorded whether the information given is from the database or API. :white_check_mark:

:pushpin: The results were returned in Json format. :white_check_mark:


## Examples of use

## Swagger UI

### GETTING CITY AIR POLLUTION INFORMATION

<img width="712" alt="cty-ui" src="https://user-images.githubusercontent.com/18599278/177319772-6ee18c71-6828-4847-8610-025debcd8dca.png">

### DELETE ALL INFORMATION FROM DATABASE

<img width="710" alt="delete-ui" src="https://user-images.githubusercontent.com/18599278/177319930-d28a0a1c-af81-4531-afaa-6d7b4f3dfd48.png">

## MAKE A REQUEST CITY AIR POLLUTION INFORMATION BY DEFAULT DATE


<img width="708" alt="default-day" src="https://user-images.githubusercontent.com/18599278/177320299-ffef4b18-db16-4706-82b2-b5232c9a05d5.png">


<img width="707" alt="default-result" src="https://user-images.githubusercontent.com/18599278/177320320-996836fd-1f58-4420-a86d-23850fd5a13f.png">

### DATABASE EXAMPLE SCREENSHOTS 

#### CITY TABLE :mag:

<img width="607" alt="DB1" src="https://user-images.githubusercontent.com/18599278/177320971-4a26ec34-082c-4079-ac88-426ed86b6e9d.png">

#### POLLUTION INFORMATION TABLE ( JUST A FEW INFORMATION EXAMPLES ON THE SCREENSHOT) :mag:


<img width="779" alt="db2" src="https://user-images.githubusercontent.com/18599278/177321041-bbd818d5-7ef2-41ff-8b0d-f82faffb03f8.png">

#### POLLUTION CATEGORY :mag:

<img width="792" alt="db3" src="https://user-images.githubusercontent.com/18599278/177321076-19db75ed-2255-424b-a3c6-be38e3f0ae34.png">


#### LOG :mag:

<img width="662" alt="db4" src="https://user-images.githubusercontent.com/18599278/177321119-ff2d6e69-f1e0-46da-8f41-fc68ee34df4f.png">


#### LOG 2 (SAME REQUEST EXECUTED AND DATA GATHERED FROM DATABASE) :mag:

<img width="669" alt="DB5" src="https://user-images.githubusercontent.com/18599278/177321920-e223c106-c6ff-4910-8f55-e1bfb6599818.png">


## MAKE A REQUEST CITY AIR POLLUTION INFORMATION BY REQUESTED DATE RANGE  :large_blue_diamond:

<img width="711" alt="DB6" src="https://user-images.githubusercontent.com/18599278/177322371-243c95a0-3b50-4760-a999-2112f5c6fb14.png">


<img width="710" alt="DB7" src="https://user-images.githubusercontent.com/18599278/177322391-2290cd30-4d1a-4ad0-a682-7bd79c3fe724.png">


## MAKE A REQUEST CITY AIR POLLUTION INFORMATION BY WRONG DATE RANGE :small_red_triangle_down:


<img width="714" alt="DB8" src="https://user-images.githubusercontent.com/18599278/177323024-1b407d98-f1b7-499e-a515-e8b53e3465dd.png">


<img width="697" alt="DB9" src="https://user-images.githubusercontent.com/18599278/177323052-5f0aa31b-1272-43f2-857a-2fefac40d410.png">


## MAKE A REQUEST CITY AIR POLLUTION INFORMATION BY WRONG DATE RANGE 2 :small_red_triangle_down:


<img width="714" alt="db10" src="https://user-images.githubusercontent.com/18599278/177323491-2d321ddc-18ac-4327-a15a-dad247b5e1bc.png">


<img width="702" alt="db11" src="https://user-images.githubusercontent.com/18599278/177323498-df06c3c6-4f35-4e93-a1fb-1ac7771fb46d.png">


## DELETE ALL RECORDS OF TABLES :pill:


<img width="710" alt="db12" src="https://user-images.githubusercontent.com/18599278/177330583-634254e1-7d21-4a80-b838-3e95f92356d0.png">


