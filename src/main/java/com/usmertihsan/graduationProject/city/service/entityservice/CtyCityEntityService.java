package com.usmertihsan.graduationProject.city.service.entityservice;

import com.usmertihsan.graduationProject.city.dao.ICtyCityDao;
import com.usmertihsan.graduationProject.city.entity.CtyCity;
import com.usmertihsan.graduationProject.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class CtyCityEntityService extends BaseEntityService<CtyCity, ICtyCityDao> {

    public CtyCityEntityService(ICtyCityDao dao) {
        super(dao);
    }
    public CtyCity findByCityName(String cityName)

    {
        return getDao().findByCityName(cityName);
    }



}
