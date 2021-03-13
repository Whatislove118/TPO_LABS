package com.lab2.equations;

import com.lab2.functions.trigonometrics.Cosinus;
import com.lab2.functions.trigonometrics.Cotangens;
import com.lab2.functions.trigonometrics.Tangens;

public class FirstEquation {

    public static Double func(Double x){
        return getEquationODZ(x) ? ((Tangens.func(x) / Cotangens.func(x)) + Cosinus.func(x)) : Double.POSITIVE_INFINITY;
    }

    private static Boolean getEquationODZ(Double x){
        return x <= 0 && x != -Math.PI/2;
    }


}
