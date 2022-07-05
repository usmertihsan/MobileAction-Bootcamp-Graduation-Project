package com.usmertihsan.graduationProject.city.dao;

import com.usmertihsan.graduationProject.city.entity.CtyCity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICtyCityDao extends JpaRepository<CtyCity,Long> {

    CtyCity findByCityName(String cityName);

}
