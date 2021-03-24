package com.lab2.equations;

import com.lab2.functions.trigonometrics.Cosinus;
import com.lab2.functions.trigonometrics.Cotangens;
import com.lab2.functions.trigonometrics.Sinus;
import com.lab2.functions.trigonometrics.Tangens;

public class FirstEquation {

    public Tangens tangens;
    public Cosinus cosinus;
    public Cotangens cotangens;

    public FirstEquation(Tangens tangens, Cosinus cosinus, Cotangens cotangens) {
        this.tangens = tangens;
        this.cosinus = cosinus;
        this.cotangens = cotangens;
    }

    public  Double func(Double x){
        return getEquationODZ(x) ? ((this.tangens.func(x) / this.cotangens.func(x)) + this.cosinus.func(x)) : Double.NaN;
    }

    private static Boolean getEquationODZ(Double x){
        return x <= 0 && x != -Math.PI/2;
    }


}
