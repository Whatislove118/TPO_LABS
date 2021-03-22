package com.lab2.test.functions.logarithmics;

import com.lab2.functions.logarithmics.Logarifm3;
import com.lab2.functions.logarithmics.LogarifmN;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestLogarifm3 {

    private static HashMap<Double, Double> periodPoints;

    @Before
    public void setUp(){
        periodPoints = new HashMap<>();
        periodPoints.put(1.3, 0.238814);
        periodPoints.put(1.45, 0.338212);

    }

    @Test
    public void testFunctionValue(){
        for(Map.Entry<Double, Double> pair : periodPoints.entrySet()){
            Assert.assertEquals(pair.getValue(),Logarifm3.func(pair.getKey()), 0.001);
        }
    }



}


