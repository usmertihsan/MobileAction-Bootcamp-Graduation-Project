package com.usmertihsan.graduationProject.pol.service.entityservice;

import com.usmertihsan.graduationProject.gen.service.BaseEntityService;
import com.usmertihsan.graduationProject.pol.dao.IPolPollutionDao;
import com.usmertihsan.graduationProject.pol.entity.PlPollution;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlPollutionEntityService extends BaseEntityService<PlPollution, IPolPollutionDao> {

    public PlPollutionEntityService(IPolPollutionDao dao) {
        super(dao);
    }

    public List<PlPollution> findByPollutionDateUnixTime(Long unitTime)
    {
        return getDao().findByPollutionDateUnixTime(unitTime);
    }

}
