package com.lab2.test.module.functions.logarithmics;

import com.lab2.functions.logarithmics.Logarifm10;
import com.lab2.functions.logarithmics.Logarifm3;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestLogarifm10 {
    private static HashMap<Double, Double> periodPoints;

    private static Logarifm10 logarifm10;

    @BeforeClass
    public static void setGenerallyUp(){
        logarifm10 = new Logarifm10();
    }

    @Before
    public void setUp(){
        periodPoints = new HashMap<>();
        periodPoints.put(0.01, -2.0);
        periodPoints.put(0.02, -1.69897);
    }

    @Test
    public void testFunctionValue(){
        for(Map.Entry<Double, Double> pair : periodPoints.entrySet()){
            Assert.assertEquals(pair.getValue(),logarifm10.func(pair.getKey()), 0.001);
        }
    }



}

