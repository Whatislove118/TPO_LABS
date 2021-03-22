package com.lab2.test.functions.logarithmics;

import com.lab2.functions.logarithmics.Logarifm5;
import com.lab2.functions.logarithmics.LogarifmN;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestLogarifm5 {
    private static HashMap<Double, Double> periodPoints;


    @Before
    public void setUp(){
        periodPoints = new HashMap<>();
        periodPoints.put(4.3, 0.906288);
        periodPoints.put(5.0, 1.0);


    }

    @Test
    public void testFunctionValue(){
        for(Map.Entry<Double, Double> pair : periodPoints.entrySet()){
            Assert.assertEquals(pair.getValue(),Logarifm5.func(pair.getKey()), 0.001);
        }
    }


}

