package com.lab2.equations;

public class SystemEquations {


    public static Double calculateSystem(Double x){
        if (!checkODZ(x)){
            return Double.NaN;
        }
        double accuracy = 0.1;
        Double resultFirstEq = FirstEquation.func(x);
        Double resultSecondEq = SecondEquation.func(x);
        if(Math.abs(resultFirstEq - resultSecondEq) < accuracy){
            return x;
        }
        return Double.NaN;


    }

    private static boolean checkODZ(Double x){
        return x > 0 && x <= 0;
    }
}
