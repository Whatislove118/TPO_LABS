package com.lab2.utils;

import com.lab2.functions.logarithmics.LogarifmN;
import com.lab2.functions.trigonometrics.Cosinus;

public class TransformationService {

    /* Trigonometric part */
    public static Double transformateSinToCos(Double x){
        return Math.sqrt(
            1 - Math.pow(Cosinus.func(x), 2)
        );
    }

    public static Double transformateTanToCos(Double x){
        return transformateSinToCos(x) / Cosinus.func(x);
    }

    public static Double transformateCotanToCos(Double x){
        return Cosinus.func(x) / transformateSinToCos(x);
    }

    /* Logarithmic part */
    public static Double transformateLog3ToLn(Double x){
        return LogarifmN.func(x)/LogarifmN.func(3.0);
    }

    public static Double transformateLog5ToLn(Double x){
        return LogarifmN.func(x)/LogarifmN.func(5.0);
    }

    public static Double transformateLog10ToLn(Double x){
        return LogarifmN.func(x)/LogarifmN.func(10.0);
    }




}
