package com.usmertihsan.graduationProject.log.dao;

import com.usmertihsan.graduationProject.log.entity.LogData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILogDataDao extends JpaRepository<LogData,Long> {
}
