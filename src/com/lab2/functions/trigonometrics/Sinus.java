package com.lab2.functions.trigonometrics;

import com.lab2.utils.TransformationService;

public class Sinus {
    private TransformationService transformationService;

    public Sinus(TransformationService transformationService) {
        this.transformationService = transformationService;
    }

    public Sinus() {
        this.transformationService = new TransformationService();
    }

    public  Double func(Double x){
        return transformationService.transformateSinToCos(x);
    }

    public void setTransformationService(TransformationService transformationService) {
        this.transformationService = transformationService;
    }



}
