package com.lab2.equations;

import com.lab2.utils.TransformationService;

public class SecondEquation {

    public static Double func(Double x){
        return (
                Math.pow((Math.pow(
                        (TransformationService.transformateLog3ToLn(x) + TransformationService.transformateLog5ToLn(x)), 2
                ) - TransformationService.transformateLog10ToLn(x)) * Math.pow(TransformationService.transformateLog10ToLn(x), 2) , 2)
        );
    }

    private static Boolean getEquationODZ(Double x){
        return x > 0;
    }
}
