package com.lab2.functions.logarithmics;

import com.lab2.utils.TransformationService;

public class Logarifm3 {
    private TransformationService transformationService;

    public Logarifm3(TransformationService transformationService) {
        this.transformationService = transformationService;
    }

    public Logarifm3() {
        this.transformationService = new TransformationService();
    }

    public Double func(Double x){
        return transformationService.transformateLog3ToLn(x);
    }

    public void setTransformationService(TransformationService transformationService) {
        this.transformationService = transformationService;
    }
}
