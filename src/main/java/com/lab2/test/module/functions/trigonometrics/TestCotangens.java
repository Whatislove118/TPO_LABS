package com.lab2.test.module.functions.trigonometrics;

import com.lab2.functions.trigonometrics.Cosinus;
import com.lab2.functions.trigonometrics.Cotangens;
import com.lab2.utils.CSVWriter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestCotangens {
    private final static Double pi = Math.PI;
    private static HashMap<Double, Double> period;
    private static HashMap<Double, Double> separatePoint;
    private static ArrayList<Double> points_NOT_IN_ODZ;

    private static Cotangens cotangens;
    private static CSVWriter writer;

    @BeforeClass
    public static void setGenerallyUp(){
        cotangens = new Cotangens();
        writer = new CSVWriter();
    }

    @Before
    public void setUp(){
        period = new HashMap<>();
        period.put(pi/6, 1.73205);
        period.put(pi/3, 0.577);

        separatePoint = new HashMap<>();
        separatePoint.put(pi/2, 0.0);

        points_NOT_IN_ODZ = new ArrayList<>();
        points_NOT_IN_ODZ.add(0.0);
        points_NOT_IN_ODZ.add(pi);




    }

    @Test
    public void testPeriod_VALUE(){
        for(Map.Entry<Double, Double> pair : period.entrySet()){
            Assert.assertEquals(pair.getValue(), cotangens.func(pair.getKey()), 0.001);
            writer.writeToFile("cot("+ pair.getKey()+") = | " + cotangens.func(pair.getKey()));
        }
    }

    @Test
    public void testFunctionValue_SEPARATE_POINT(){
        for(Map.Entry<Double, Double> pair : separatePoint.entrySet()){
            Assert.assertEquals(pair.getValue(),cotangens.func(pair.getKey()), 0.001);
            writer.writeToFile("cot("+ pair.getKey()+") = | " + cotangens.func(pair.getKey()));
        }
    }

    @Test
    public void testFunctionValue_POINT_NOT_IN_ODZ(){
        for(Double point : points_NOT_IN_ODZ){
            Assert.assertTrue(cotangens.func(point).isNaN());
        }
    }

    @Test
    public void testFirstPeriod_IS_DECREASING(){
        for(Map.Entry<Double, Double> pair : period.entrySet()){
            pair.setValue(cotangens.func(pair.getKey()));
        }
        Double lowestValue = period.get(pi/3);
        Double highestValue = period.get(pi/6);
        Assert.assertTrue(lowestValue < highestValue);
    }



}
