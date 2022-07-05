package com.usmertihsan.graduationProject.polcategory.util;

public class CategoryClassify {

    public static String classifyO3Category(Double o3)
    {
        String categoryName="";

        if(o3>=0 && o3<=50)
        {
            categoryName = "Good";
        }

        else if(o3>=51 && o3<=100)
        {
            categoryName = "Satisfactory";
        }

        else if(o3>=101 && o3<=168)
        {
            categoryName = "Moderate";
        }
        else if(o3>=169 && o3<=208)
        {
            categoryName = "Poor";
        }
        else if(o3>=209 && o3<=748)
        {
            categoryName = "Severe";
        }
        else
        {
            categoryName = "Hazardous";
        }
        return categoryName;
    }

    public static String classifySO2Category(Double so2)
    {
        String categoryName="";

        if(so2>=0 && so2<=40)
        {
            categoryName = "Good";
        }

        else if(so2>=41 && so2<=80)
        {
            categoryName = "Satisfactory";
        }

        else if(so2>=81 && so2<=380)
        {
            categoryName = "Moderate";
        }
        else if(so2>=381 && so2<=800)
        {
            categoryName = "Poor";
        }
        else if(so2>=801 && so2<=1600)
        {
            categoryName = "Severe";
        }
        else
        {
            categoryName = "Hazardous";
        }
        return categoryName;
    }

    public static String classifyCOCategory(Double co)
    {
        String categoryName="";

        if(co>=0 && co<=50)
        {
            categoryName = "Good";
        }

        else if(co>=51 && co<=100)
        {
            categoryName = "Satisfactory";
        }

        else if(co>=101 && co<=150)
        {
            categoryName = "Moderate";
        }
        else if(co>=151 && co<=200)
        {
            categoryName = "Poor";
        }
        else if(co>=201 && co<=300)
        {
            categoryName = "Severe";
        }
        else
        {
            categoryName = "Hazardous";
        }
        return categoryName;
    }
}
