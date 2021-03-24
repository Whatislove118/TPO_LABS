package com.lab2.test.module.functions.trigonometrics;

import com.lab2.functions.trigonometrics.Cotangens;
import com.lab2.functions.trigonometrics.Sinus;
import com.lab2.utils.CSVWriter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestSinus {
    private final static Double pi = Math.PI;
    private static HashMap<Double, Double> firstPeriod;
    private static HashMap<Double, Double> secondPeriod;
    private static HashMap<Double, Double> separatePoint;

    private static Sinus sinus;
    private static CSVWriter writer;

    @BeforeClass
    public static void setGenerallyUp(){
        sinus = new Sinus();
        writer = new CSVWriter();
    }

    @Before
    public void setUp(){
        firstPeriod = new HashMap<>();
        firstPeriod.put(-pi/3, -0.86602);
        firstPeriod.put(-pi/6, -0.5);

        secondPeriod = new HashMap<>();
        secondPeriod.put(pi/6, 0.5);
        secondPeriod.put(pi/3, 0.86602);


        separatePoint = new HashMap<>();
        separatePoint.put(0.0, 0.0);
        separatePoint.put(pi, 0.0);


    }

    @Test
    public void testFirstPeriod_VALUE(){
        for(Map.Entry<Double, Double> pair : firstPeriod.entrySet()){
            Assert.assertEquals(pair.getValue(), -sinus.func(pair.getKey()), 0.001);
            writer.writeToFile("sin("+ pair.getKey()+") = | " + -sinus.func(pair.getKey()));
        }
    }

    @Test
    public void testFunctionValue_SEPARATE_POINT(){
        for(Map.Entry<Double, Double> pair : separatePoint.entrySet()){
            Assert.assertEquals(pair.getValue(),sinus.func(pair.getKey()), 0.001);
            writer.writeToFile("sin("+ pair.getKey()+") = | " + sinus.func(pair.getKey()));
        }
    }

    @Test
    public void testSecondPeriod_VALUE(){
        for(Map.Entry<Double, Double> pair : secondPeriod.entrySet()){
            Assert.assertEquals(pair.getValue(),sinus.func(pair.getKey()), 0.001);
            writer.writeToFile("sin("+ pair.getKey()+") = | " + sinus.func(pair.getKey()));
        }
    }

    @Test
    public void testFirstPeriod_IS_DECREASING(){
        for(Map.Entry<Double, Double> pair : firstPeriod.entrySet()){
            pair.setValue(sinus.func(pair.getKey()));
        }
        Double lowestValue = firstPeriod.get(-pi/6);
        Double highestValue = firstPeriod.get(-pi/3);
        Assert.assertTrue(lowestValue < highestValue);
    }

    @Test
    public void testSecondPeriod_IS_INCREASING(){
        for(Map.Entry<Double, Double> pair : secondPeriod.entrySet()){
            pair.setValue(sinus.func(pair.getKey()));
        }
        Double lowestValue = secondPeriod.get(pi/6);
        Double highestValue = secondPeriod.get(pi/3);
        Assert.assertTrue(highestValue > lowestValue);
    }

}
