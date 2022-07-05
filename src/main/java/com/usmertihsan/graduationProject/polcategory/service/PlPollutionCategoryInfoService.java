package com.usmertihsan.graduationProject.polcategory.service;
import com.usmertihsan.graduationProject.gen.util.StringDateUtil;
import com.usmertihsan.graduationProject.polcategory.entity.PlPolCategoryInfo;
import com.usmertihsan.graduationProject.polcategory.service.entityservice.PlPollutionCategoryInfoEntityService;
import com.usmertihsan.graduationProject.polcategory.util.CategoryClassify;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlPollutionCategoryInfoService {
    private final PlPollutionCategoryInfoEntityService pollutionCategoryInfoEntityService;


    // this function saves pollution category like good,satisfactory,severe ...
    //
    public void savePollutionCategory(Double o3, Double so2, Double co, String date, String city)
    {
        PlPolCategoryInfo polCategoryInfo = new PlPolCategoryInfo();

        polCategoryInfo.setCityName(city);
        polCategoryInfo.setCategoryOzone(CategoryClassify.classifyO3Category(o3/24.0));
        polCategoryInfo.setCategorySulphurDioxide(CategoryClassify.classifySO2Category(so2/24.0));
        polCategoryInfo.setCategoryCarbonMonoxide(CategoryClassify.classifyCOCategory(co/24.0));
        polCategoryInfo.setDate(date);
        pollutionCategoryInfoEntityService.save(polCategoryInfo);
    }



    // this function returns given request city information in json format
    public String getPollutionInformation(String date, String cityName,String endDate) throws ParseException
    {
        char quotes ='"';
        String requestResponse ="{"+"\"City\""+":"+quotes+cityName+quotes+","+"\"Results\""+":[" + '\n';
        String oneDayInfo;
        long daySize = StringDateUtil.howManyDays(date,endDate);

        List<PlPolCategoryInfo> polCategoryInfoList = new ArrayList<>();

        for(Integer day=0; day<=daySize;day++)
        {
            if(pollutionCategoryInfoEntityService.findByDate(date)!=null)
            {
                polCategoryInfoList = pollutionCategoryInfoEntityService.findByDate(date);
                for (PlPolCategoryInfo polCategoryInfo  : polCategoryInfoList) {
                    if(cityName.equals(polCategoryInfo.getCityName()))
                    {
                        String test = polCategoryInfo.getCategoryCarbonMonoxide();
                        oneDayInfo = "{\"Date\":"+quotes+date+quotes+","+"\"Categories\":"+"[{\"CO\":"+quotes+polCategoryInfo.getCategoryCarbonMonoxide()+quotes+"}"+","+
                                "{"+"\"SO2\":"+quotes+polCategoryInfo.getCategorySulphurDioxide()+quotes+"},{\"O3\":"+quotes+polCategoryInfo.getCategoryOzone()+quotes+"}]},"+'\n';
                        requestResponse += oneDayInfo;
                    }
                }
            }
            else
            {
                throw new RuntimeException("The requested dates not available! You can only reach information, after 27/11/2020");
            }
            date = StringDateUtil.addOneDayToDate(date);
        }
        return requestResponse;
        }


        // delete all data
    public void deleteAllData() {

        pollutionCategoryInfoEntityService.deleteAll();
    }



}
