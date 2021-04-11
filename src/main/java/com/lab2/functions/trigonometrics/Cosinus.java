package com.lab2.functions.trigonometrics;

import com.lab1.FirstExercise;
import com.lab2.utils.TransformationService;
import org.junit.Assert;

public class Cosinus{

    public  Double func(Double x){
        int n = 0;
        int max_n = 10;
        double y = 0.0;
        for (int row_n = n; row_n <= max_n; row_n++){
            y += Math.pow(-1, row_n)*Math.pow(x, 2*row_n) / FirstExercise.getFactorial(2L *row_n);
        }
        return y;
    }




}
