package com.usmertihsan.graduationProject.pol.dao;

import com.usmertihsan.graduationProject.city.entity.CtyCity;
import com.usmertihsan.graduationProject.pol.entity.PlPollution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPolPollutionDao extends JpaRepository<PlPollution,Long> {

    List<PlPollution> findByPollutionDateUnixTime(Long unitTime);

}

