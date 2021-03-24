package com.lab2.test.module.functions.logarithmics;

import com.lab2.functions.logarithmics.Logarifm3;
import com.lab2.functions.logarithmics.LogarifmN;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestLogarifmN {

    private static HashMap<Double, Double> periodPoints;
    private static HashMap<Double, Double> separatePoint;
    private static Double point_NOT_IN_ODZ;
    private static LogarifmN logarifmN;

    @BeforeClass
    public static void setGenerallyUp(){
        logarifmN = new LogarifmN();
    }

    @Before
    public void setUp(){
        periodPoints = new HashMap<>();
        periodPoints.put(0.5, -0.6931);
        periodPoints.put(2.0, 0.6931);

        separatePoint = new HashMap<>();
        separatePoint.put(1.0, 0.0);

        point_NOT_IN_ODZ = -1.0;
    }

    @Test
    public void testFunctionValue(){
        for(Map.Entry<Double, Double> pair : periodPoints.entrySet()){
            Assert.assertEquals(pair.getValue(),logarifmN.func(pair.getKey()), 0.001);
        }
    }

    @Test
    public void testFunctionValue_IS_INCREASING(){
        for(Map.Entry<Double, Double> pair : periodPoints.entrySet()){
            pair.setValue(logarifmN.func(pair.getKey()));
        }
        Double lowestValue = periodPoints.get(0.5);
        Double highestValue = periodPoints.get(2.0);
        Assert.assertTrue(highestValue > lowestValue);
    }

    @Test
    public void testFunctionValue_IN_SEPARATE_POINT(){
        for(Map.Entry<Double, Double> pair : separatePoint.entrySet()) {
            Assert.assertEquals(pair.getValue(),logarifmN.func(pair.getKey()), 0.001);
        }
    }

    @Test
    public void testFunctionValue_NOT_IN_ODZ(){
        Assert.assertTrue(logarifmN.func(point_NOT_IN_ODZ).isNaN());
    }

}
