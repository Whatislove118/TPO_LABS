package com.lab1;

import org.junit.Assert;
import org.junit.Test;


public class FirstExercise {


    @Test
    public void check_sin(){
        
        int n = 1;
        int max_n = 10;

        for(double x =0; x<2*Math.PI; x+=0.0001){
            double y = 0.0;
            for (int row_n = n; row_n <= max_n; row_n++){
                y += Math.pow(-1, row_n-1)*Math.pow(x, 2*row_n-1) / getFactorial(2*row_n - 1);
            }
            System.out.println("y = " + y + " --  sin(x) = " + Math.sin(x) + " -- x = " + x);
            Assert.assertEquals(Math.sin(x), y, 0.01);
        }

    }


    @ServiceMethod
    public static long getFactorial(long f) {
        if (f <= 1) {
            return 1;
        }else {
            return f * getFactorial(f - 1);
        }
    }


    @Test
    public void check_get_factorial() {
        for (int i = 1; i<14; i++){
            if (i == 13){
                Assert.assertEquals(6227020800L, getFactorial(13));
            }
        }
    }
}
