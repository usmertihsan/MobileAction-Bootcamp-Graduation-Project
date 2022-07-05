package com.usmertihsan.graduationProject.polcategory.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryClassifyTest {


    // 6 test cases for O3
    @Test
    void shouldClassifyO3CategoryAsGood() {

        Double o3 = Double.valueOf(50);

        String testValue = CategoryClassify.classifyO3Category(o3);
        Assertions.assertEquals("Good",testValue);
    }

    @Test
    void shouldClassifyO3CategoryAsSatisfactory() {

        Double o3 = Double.valueOf(100);

        String testValue = CategoryClassify.classifyO3Category(o3);
        Assertions.assertEquals("Satisfactory",testValue);
    }


    @Test
    void shouldClassifyO3CategoryAsModerate() {

        Double o3 = Double.valueOf(168);

        String testValue = CategoryClassify.classifyO3Category(o3);
        Assertions.assertEquals("Moderate",testValue);
    }

    @Test
    void shouldClassifyO3CategoryAsPoor() {

        Double o3 = Double.valueOf(208);

        String testValue = CategoryClassify.classifyO3Category(o3);
        Assertions.assertEquals("Poor",testValue);

    }

    @Test
    void shouldClassifyO3CategoryAsSevere() {

        Double o3 = Double.valueOf(748);

        String testValue = CategoryClassify.classifyO3Category(o3);
        Assertions.assertEquals("Severe",testValue);
    }

    @Test
    void shouldClassifyO3CategoryAsHazardous() {

        Double o3 = Double.valueOf(749);

        String testValue = CategoryClassify.classifyO3Category(o3);
        Assertions.assertEquals("Hazardous",testValue);
    }

    // 6 test cases for SO2
    @Test
    void shouldClassifySO2CategoryAsGood() {

        Double so2 = Double.valueOf(40);

        String testValue = CategoryClassify.classifySO2Category(so2);
        Assertions.assertEquals("Good",testValue);
    }

    @Test
    void shouldClassifySO2CategoryAsSatisfactory() {

        Double so2 = Double.valueOf(80);

        String testValue = CategoryClassify.classifySO2Category(so2);
        Assertions.assertEquals("Satisfactory",testValue);
    }


    @Test
    void shouldClassifySO2CategoryAsModerate() {

        Double so2 = Double.valueOf(380);

        String testValue = CategoryClassify.classifySO2Category(so2);
        Assertions.assertEquals("Moderate",testValue);
    }

    @Test
    void shouldClassifySO2CategoryAsPoor() {

        Double so2 = Double.valueOf(800);

        String testValue = CategoryClassify.classifySO2Category(so2);
        Assertions.assertEquals("Poor",testValue);
    }

    @Test
    void shouldClassifySO2CategoryAsSevere() {

        Double so2 = Double.valueOf(1600);

        String testValue = CategoryClassify.classifySO2Category(so2);
        Assertions.assertEquals("Severe",testValue);
    }

    @Test
    void shouldClassifySO2CategoryAsHazardous() {

        Double so2 = Double.valueOf(1601);

        String testValue = CategoryClassify.classifySO2Category(so2);
        Assertions.assertEquals("Hazardous",testValue);
    }

    // 6 test cases for CO
    @Test
    void shouldClassifyCOCategoryAsGood() {

        Double co = Double.valueOf(50);

        String testValue = CategoryClassify.classifyCOCategory(co);
        Assertions.assertEquals("Good",testValue);
    }

    @Test
    void shouldClassifyCOCategoryAsSatisfactory() {

        Double co = Double.valueOf(100);

        String testValue = CategoryClassify.classifyCOCategory(co);
        Assertions.assertEquals("Satisfactory",testValue);
    }


    @Test
    void shouldClassifyCOCategoryAsModerate() {

        Double co = Double.valueOf(150);

        String testValue = CategoryClassify.classifyCOCategory(co);
        Assertions.assertEquals("Moderate",testValue);
    }

    @Test
    void shouldClassifyCOCategoryAsPoor() {

        Double co = Double.valueOf(200);

        String testValue = CategoryClassify.classifyCOCategory(co);
        Assertions.assertEquals("Poor",testValue);
    }

    @Test
    void shouldClassifyCOCategoryAsSevere() {

        Double co = Double.valueOf(300);

        String testValue = CategoryClassify.classifyCOCategory(co);
        Assertions.assertEquals("Severe",testValue);
    }

    @Test
    void shouldClassifyCOCategoryAsHazardous() {

        Double co = Double.valueOf(301);

        String testValue = CategoryClassify.classifyCOCategory(co);
        Assertions.assertEquals("Hazardous",testValue);
    }


}