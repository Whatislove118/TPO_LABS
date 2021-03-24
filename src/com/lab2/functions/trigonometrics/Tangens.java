package com.lab2.functions.trigonometrics;

import com.lab2.utils.TransformationService;

public class Tangens {

    private TransformationService transformationService;

    public Tangens(TransformationService transformationService) {
        this.transformationService = transformationService;
    }

    public Tangens() {
        this.transformationService = new TransformationService();
    }

    public  Double func(Double x){
        return checkODZ(x)? transformationService.transformateTanToCos(x): Double.NaN;
    }

    private static boolean checkODZ(Double x){
        return x != -Math.PI/2 && x != Math.PI/2;
    }

    public void setTransformationService(TransformationService transformationService) {
        this.transformationService = transformationService;
    }
}
