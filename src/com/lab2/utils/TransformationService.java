package com.lab2.utils;

public class TransformationService {

    /* Trigonometric part */
    public static Double transformateSinToCos(Double x){
        return Math.sqrt(
            1 - Math.pow(Math.cos(x), 2)
        );
    }

    public static Double transformateTanToCos(Double x){
        return transformateSinToCos(x) / Math.cos(x);
    }

    public static Double transformateCotanToCos(Double x){
        return Math.cos(x) / transformateSinToCos(x);
    }

    /* Logarithmic part */
    public static Double transformateLog3ToLn(Double x){
        return Math.log(x)/Math.log(3);
    }

    public static Double transformateLog5ToLn(Double x){
        return Math.log(x)/Math.log(5);
    }

    public static Double transformateLog10ToLn(Double x){
        return Math.log(x)/Math.log(10);
    }




}
