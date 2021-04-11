package com.lab2.functions.logarithmics;

import com.lab2.utils.TransformationService;

public class Logarifm5 {
    private TransformationService transformationService;

    public Logarifm5(TransformationService transformationService) {
        this.transformationService = transformationService;
    }

    public Logarifm5() {
        this.transformationService = new TransformationService();
    }

    public  Double func(Double x){
        return transformationService.transformateLog5ToLn(x);
    }

    public void setTransformationService(TransformationService transformationService) {
        this.transformationService = transformationService;
    }
}
