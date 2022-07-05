package com.usmertihsan.graduationProject.polcategory.dao;

import com.usmertihsan.graduationProject.polcategory.entity.PlPolCategoryInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPlPollutionCategoryInfoDao extends JpaRepository<PlPolCategoryInfo,Long> {
    List<PlPolCategoryInfo> findByDate(String date);
    List<PlPolCategoryInfo> findByDateAndCityName(String date,String cityName);
}
