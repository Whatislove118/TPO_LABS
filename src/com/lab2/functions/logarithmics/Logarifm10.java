package com.lab2.functions.logarithmics;

import com.lab2.utils.TransformationService;

public class Logarifm10 {

    private TransformationService transformationService;

    public Logarifm10(TransformationService transformationService) {
        this.transformationService = transformationService;
    }

    public Logarifm10() {
        this.transformationService = new TransformationService();
    }

    public Double func(Double x){
        return transformationService.transformateLog10ToLn(x);
    }

    public void setTransformationService(TransformationService transformationService) {
        this.transformationService = transformationService;
    }
}
