package com.lab2.test.module.functions.trigonometrics;

import com.lab2.functions.trigonometrics.Sinus;
import com.lab2.functions.trigonometrics.Tangens;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestTangens {
    private final static Double pi = Math.PI;
    private static HashMap<Double, Double> period;
    private static HashMap<Double, Double> separatePoint;
    private static ArrayList<Double> points_NOT_IN_ODZ;

    private static Tangens tangens;

    @BeforeClass
    public static void setGenerallyUp(){
        tangens = new Tangens();
    }

    @Before
    public void setUp(){
        period = new HashMap<>();
        period.put(pi/6, 0.577);
        period.put(pi/3, 1.73205);

        separatePoint = new HashMap<>();
        separatePoint.put(0.0, 0.0);

        points_NOT_IN_ODZ = new ArrayList<>();
        points_NOT_IN_ODZ.add(-pi/2);
        points_NOT_IN_ODZ.add(pi/2);




    }

    @Test
    public void testPeriod_VALUE(){
        for(Map.Entry<Double, Double> pair : period.entrySet()){
            Assert.assertEquals(pair.getValue(), tangens.func(pair.getKey()), 0.001);
        }
    }

    @Test
    public void testFunctionValue_SEPARATE_POINT(){
        for(Map.Entry<Double, Double> pair : separatePoint.entrySet()){
            Assert.assertEquals(pair.getValue(),tangens.func(pair.getKey()), 0.001);
        }
    }

    @Test
    public void testFunctionValue_POINT_NOT_IN_ODZ(){
        for(Double point : points_NOT_IN_ODZ){
            Assert.assertTrue(tangens.func(point).isNaN());
        }
    }

    @Test
    public void testFirstPeriod_IS_INCREASING(){
        for(Map.Entry<Double, Double> pair : period.entrySet()){
            pair.setValue(tangens.func(pair.getKey()));
        }
        Double lowestValue = period.get(pi/6);
        Double highestValue = period.get(pi/3);
        Assert.assertTrue(lowestValue < highestValue);
    }

}
