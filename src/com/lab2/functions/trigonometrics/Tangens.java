package com.lab2.functions.trigonometrics;

import com.lab2.utils.TransformationService;

public class Tangens {

    public  Double func(Double x){
        return checkODZ(x)? TransformationService.transformateTanToCos(x): Double.NaN;
    }

    private static boolean checkODZ(Double x){
        return x != -Math.PI/2 && x != Math.PI/2;
    }

}
