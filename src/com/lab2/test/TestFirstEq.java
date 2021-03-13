package com.lab2.test;

import com.lab2.equations.FirstEquation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TestFirstEq {

    private static HashMap<Double, Double> boundaryPoints;
    private static Double pointInfinity;
    private static ArrayList<Double> resultsTestCase;
    private static HashMap<Double, Double> firstPeriodParameters;
    private static HashMap<Double, Double> secondPeriodParameters;
    
    @BeforeClass
    public static void setGeneralUp(){
        resultsTestCase = new ArrayList<>();
        pointInfinity = -Math.PI/2;

        boundaryPoints = new HashMap<>();
        boundaryPoints.put(-Math.PI, -1.0);
        boundaryPoints.put(0.0, 1.0);

        firstPeriodParameters = new HashMap<>();
        firstPeriodParameters.put(-2.0, 4.36);
        firstPeriodParameters.put(-1.9, 8.24);

        secondPeriodParameters = new HashMap<>();
        secondPeriodParameters.put(-1.0, 2.96);
        secondPeriodParameters.put(-0.6, 1.29);
        
    }
    
    @Before
    public void setUp(){
        resultsTestCase.clear();
    }





    @Test
    public void testFunctionValueIsInfinity(){
        resultsTestCase.add(FirstEquation.func(pointInfinity));
        System.out.println(resultsTestCase.get(0));
        Assert.assertTrue(resultsTestCase.get(0).isInfinite());
    }

    @Test
    public void testFirstPeriodFunctionValue(){
        for(Map.Entry<Double, Double> pair: firstPeriodParameters.entrySet()){
            Assert.assertEquals(FirstEquation.func(pair.getKey()),pair.getValue(), 0.01);
        }
    }

    @Test
    public void testSecondPeriodFunctionValue(){
        for(Map.Entry<Double, Double> pair: secondPeriodParameters.entrySet()){
            Assert.assertEquals(FirstEquation.func(pair.getKey()),pair.getValue(), 0.01);
        }
    }


    @Test
    public void testFirstPeriodOfFunction_IS_INCREASING(){
        for(Map.Entry<Double, Double> pair: firstPeriodParameters.entrySet()){
            resultsTestCase.add(FirstEquation.func(pair.getKey()));
        }
        Assert.assertTrue(resultsTestCase.get(0) < resultsTestCase.get(1));

    }

    @Test
    public void testSecondPeriodOfFunction_IS_DECREASING(){
        for(Map.Entry<Double, Double> pair: secondPeriodParameters.entrySet()){
            resultsTestCase.add(FirstEquation.func(pair.getKey()));
        }
        Assert.assertTrue(resultsTestCase.get(0) > resultsTestCase.get(1));

    }

    @Test
    public void testFunctionValueInBoundaryPoints(){
        for(Map.Entry<Double, Double> pair : boundaryPoints.entrySet()){
            resultsTestCase.add(FirstEquation.func(pair.getKey()));
            Assert.assertEquals(FirstEquation.func(pair.getKey()), pair.getValue(), 0.01);
        }
    }

    @Test
    public void testFunctionPeriodicly(){
        Double periodicStep = Math.PI * 2;
        for(Map.Entry<Double, Double> pair: boundaryPoints.entrySet()){
            Assert.assertEquals(FirstEquation.func(pair.getKey()-periodicStep), pair.getValue(), 0.01);
        }

    }




}
