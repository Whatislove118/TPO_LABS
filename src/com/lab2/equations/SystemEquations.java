package com.lab2.equations;

public class SystemEquations {

    public FirstEquation firstEquation;
    public SecondEquation secondEquation;

    public SystemEquations(FirstEquation firstEquation, SecondEquation secondEquation) {
        this.firstEquation = firstEquation;
        this.secondEquation = secondEquation;
    }

    public  Double calculateSystem(Double x){
        if (!checkODZ(x)){
            return Double.NaN;
        }
        double accuracy = 0.1;
        Double resultFirstEq = this.firstEquation.func(x);
        Double resultSecondEq = this.secondEquation.func(x);
        if(Math.abs(resultFirstEq - resultSecondEq) < accuracy){
            return x;
        }
        return Double.NaN;


    }

    private static boolean checkODZ(Double x){
        return x > 0 && x <= 0;
    }
}
