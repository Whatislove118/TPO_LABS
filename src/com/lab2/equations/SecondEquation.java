package com.lab2.equations;

import com.lab2.functions.logarithmics.Logarifm10;
import com.lab2.functions.logarithmics.Logarifm3;
import com.lab2.functions.logarithmics.Logarifm5;


public class SecondEquation {
    public Logarifm3 logarifm3;
    public Logarifm5 logarifm5;
    public Logarifm10 logarifm10;

    public SecondEquation(Logarifm3 logarifm3, Logarifm5 logarifm5, Logarifm10 logarifm10) {
        this.logarifm3 = logarifm3;
        this.logarifm5 = logarifm5;
        this.logarifm10 = logarifm10;
    }

    public SecondEquation() {
    }

    public Double func(Double x){
        return getEquationODZ(x) ? Math.pow(((Math.pow((this.logarifm3.func(x) + this.logarifm5.func(x)), 2) - this.logarifm10.func(x)) * Math.pow(this.logarifm10.func(x), 2)),2) : Double.NaN;
    }

    private static Boolean getEquationODZ(Double x){
        return x > 0;
    }
}
