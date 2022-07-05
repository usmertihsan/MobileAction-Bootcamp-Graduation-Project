package com.usmertihsan.graduationProject.log.service.entityservice;

import com.usmertihsan.graduationProject.gen.service.BaseEntityService;
import com.usmertihsan.graduationProject.log.dao.ILogDataDao;
import com.usmertihsan.graduationProject.log.entity.LogData;
import org.springframework.stereotype.Service;

@Service
public class LogEntityService extends BaseEntityService<LogData, ILogDataDao> {


    public LogEntityService(ILogDataDao dao) {
        super(dao);
    }
}
