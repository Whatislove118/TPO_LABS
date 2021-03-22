package com.lab2.test.functions.trigonometrics;

import com.lab2.functions.logarithmics.LogarifmN;
import com.lab2.functions.trigonometrics.Cosinus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestCosinus {
    private final static Double pi = Math.PI;
    private static HashMap<Double, Double> firstPeriod;
    private static HashMap<Double, Double> secondPeriod;
    private static HashMap<Double, Double> separatePoint;


    @Before
    public void setUp(){
        firstPeriod = new HashMap<>();
        firstPeriod.put(pi/6, 0.86602);
        firstPeriod.put(pi/3, 0.5);

        secondPeriod = new HashMap<>();
        secondPeriod.put(7*pi/6, -0.866);
        secondPeriod.put(4*pi/3, -0.5);


        separatePoint = new HashMap<>();
        separatePoint.put(pi/2, 0.0);
        separatePoint.put(3*pi/2, 0.0);


    }

    @Test
    public void testFirstPeriod_VALUE(){
        for(Map.Entry<Double, Double> pair : firstPeriod.entrySet()){
            Assert.assertEquals(pair.getValue(),Cosinus.func(pair.getKey()), 0.001);
        }
    }

    @Test
    public void testFunctionValue_SEPARATE_POINT(){
        for(Map.Entry<Double, Double> pair : separatePoint.entrySet()){
            Assert.assertEquals(pair.getValue(),Cosinus.func(pair.getKey()), 0.001);
        }
    }

    @Test
    public void testSecondPeriod_VALUE(){
        for(Map.Entry<Double, Double> pair : secondPeriod.entrySet()){
            Assert.assertEquals(pair.getValue(),Cosinus.func(pair.getKey()), 0.001);
        }
    }

    @Test
    public void testFirstPeriod_IS_DECREASING(){
        for(Map.Entry<Double, Double> pair : firstPeriod.entrySet()){
            pair.setValue(LogarifmN.func(pair.getKey()));
        }
        Double lowestValue = firstPeriod.get(pi/6);
        Double highestValue = firstPeriod.get(pi/3);
        Assert.assertTrue(lowestValue < highestValue);
    }

    @Test
    public void testSecondPeriod_IS_INCREASING(){
        for(Map.Entry<Double, Double> pair : secondPeriod.entrySet()){
            pair.setValue(LogarifmN.func(pair.getKey()));
        }
        Double lowestValue = secondPeriod.get(7*pi/6);
        Double highestValue = secondPeriod.get(4*pi/3);
        Assert.assertTrue(highestValue > lowestValue);
    }





}
