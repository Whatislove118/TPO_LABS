package com.lab2.utils;

import com.lab2.functions.logarithmics.Logarifm10;
import com.lab2.functions.logarithmics.Logarifm3;
import com.lab2.functions.logarithmics.Logarifm5;
import com.lab2.functions.logarithmics.LogarifmN;
import com.lab2.functions.trigonometrics.Cosinus;
import com.lab2.functions.trigonometrics.Cotangens;
import com.lab2.functions.trigonometrics.Sinus;
import com.lab2.functions.trigonometrics.Tangens;

public class TransformationService {

    
    public static Cosinus cosinus = new Cosinus();

    public static LogarifmN logarifmN = new LogarifmN();
    


    /* Trigonometric part */
    public static Double transformateSinToCos(Double x){
        return Math.sqrt(
            1 - Math.pow(cosinus.func(x), 2)
        );
    }

    public static Double transformateTanToCos(Double x){
        return transformateSinToCos(x) / cosinus.func(x);
    }

    public static Double transformateCotanToCos(Double x){
        return cosinus.func(x) / transformateSinToCos(x);
    }

    /* Logarithmic part */
    public static Double transformateLog3ToLn(Double x){
        return logarifmN.func(x)/ logarifmN.func(3.0);
    }

    public static Double transformateLog5ToLn(Double x){
        return logarifmN.func(x)/ logarifmN.func(5.0);
    }

    public static Double transformateLog10ToLn(Double x){
        return logarifmN.func(x)/logarifmN.func(10.0);
    }




}
