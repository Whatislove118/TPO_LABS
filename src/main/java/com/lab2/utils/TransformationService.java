package com.lab2.utils;

import com.lab2.functions.logarithmics.Logarifm10;
import com.lab2.functions.logarithmics.Logarifm3;
import com.lab2.functions.logarithmics.Logarifm5;
import com.lab2.functions.logarithmics.LogarifmN;
import com.lab2.functions.trigonometrics.Cosinus;
import com.lab2.functions.trigonometrics.Cotangens;
import com.lab2.functions.trigonometrics.Sinus;
import com.lab2.functions.trigonometrics.Tangens;
import sun.rmi.runtime.Log;

public class TransformationService {

    
    public  Cosinus cosinus = new Cosinus();

    public  LogarifmN logarifmN = new LogarifmN();
    
    public  void setLogarifmN(LogarifmN logarifm){
        logarifmN = logarifm;
    }

    public  void setCosinus(Cosinus cos){
        cosinus = cos;
    }

    /* Trigonometric part */
    public  Double transformateSinToCos(Double x){
        return Math.sqrt(
            1 - Math.pow(cosinus.func(x), 2)
        );
    }

    public  Double transformateTanToCos(Double x){
        return transformateSinToCos(x) / cosinus.func(x);
    }

    public  Double transformateCotanToCos(Double x){
        return cosinus.func(x) / transformateSinToCos(x);
    }

    /* Logarithmic part */
    public  Double transformateLog3ToLn(Double x){
        return logarifmN.func(x)/ logarifmN.func(3.0);
    }

    public  Double transformateLog5ToLn(Double x){
        return logarifmN.func(x)/ logarifmN.func(5.0);
    }

    public  Double transformateLog10ToLn(Double x){
        return logarifmN.func(x)/logarifmN.func(10.0);
    }




}
