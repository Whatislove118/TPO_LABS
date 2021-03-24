package com.lab2.functions.trigonometrics;

import com.lab2.utils.TransformationService;

public class Cotangens {
    private TransformationService transformationService;

    public Cotangens(TransformationService transformationService) {
        this.transformationService = transformationService;
    }

    public Cotangens() {
        this.transformationService = new TransformationService();
    }

    public  Double func(Double x){
        return checkODZ(x)? transformationService.transformateCotanToCos(x): Double.NaN;
    }


    private static boolean checkODZ(Double x){
        return x != Math.PI && x != 0;
    }

    public void setTransformationService(TransformationService transformationService) {
        this.transformationService = transformationService;
    }
}
