package com.lab2.equations;

import com.lab2.functions.logarithmics.Logarifm10;
import com.lab2.functions.logarithmics.Logarifm3;
import com.lab2.functions.logarithmics.Logarifm5;


public class SecondEquation {

    public static Double func(Double x){
        return getEquationODZ(x) ? Math.pow(((Math.pow((Logarifm3.func(x) + Logarifm5.func(x)), 2) - Logarifm10.func(x)) * Math.pow(Logarifm10.func(x), 2)),2) : Double.NaN;
    }

    private static Boolean getEquationODZ(Double x){
        return x > 0;
    }
}
