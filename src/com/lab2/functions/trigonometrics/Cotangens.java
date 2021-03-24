package com.lab2.functions.trigonometrics;

import com.lab2.utils.TransformationService;

public class Cotangens {

    public  Double func(Double x){
        return checkODZ(x)? TransformationService.transformateCotanToCos(x): Double.NaN;
    }


    private static boolean checkODZ(Double x){
        return x != Math.PI && x != 0;
    }

}
