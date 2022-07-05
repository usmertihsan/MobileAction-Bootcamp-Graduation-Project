package com.usmertihsan.graduationProject.polcategory.service.entityservice;

import com.usmertihsan.graduationProject.gen.service.BaseEntityService;
import com.usmertihsan.graduationProject.pol.entity.PlPollution;
import com.usmertihsan.graduationProject.polcategory.dao.IPlPollutionCategoryInfoDao;
import com.usmertihsan.graduationProject.polcategory.entity.PlPolCategoryInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlPollutionCategoryInfoEntityService extends BaseEntityService<PlPolCategoryInfo, IPlPollutionCategoryInfoDao> {

    public PlPollutionCategoryInfoEntityService(IPlPollutionCategoryInfoDao dao) {
        super(dao);
    }

    public List<PlPolCategoryInfo> findByDate(String date)
    {
        return getDao().findByDate(date);
    }
    public List<PlPolCategoryInfo> findByDateAndCityName(String date,String cityName)
    {
        return findByDateAndCityName(date,cityName);
    }


}
