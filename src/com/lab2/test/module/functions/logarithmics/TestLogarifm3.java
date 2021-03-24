package com.lab2.test.module.functions.logarithmics;


import com.lab2.functions.logarithmics.Logarifm3;

import com.lab2.utils.CSVWriter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestLogarifm3 {

    private static HashMap<Double, Double> periodPoints;
    private static Logarifm3 logarifm3;
    private static CSVWriter writer;

    @BeforeClass
    public static void setGenerallyUp(){
        logarifm3 = new Logarifm3();
        writer = new CSVWriter();
    }

    @Before
    public void setUp(){
        periodPoints = new HashMap<>();
        periodPoints.put(1.3, 0.238814);
        periodPoints.put(1.45, 0.338212);

    }

    @Test
    public void testFunctionValue(){
        for(Map.Entry<Double, Double> pair : periodPoints.entrySet()){
            Assert.assertEquals(pair.getValue(),logarifm3.func(pair.getKey()), 0.001);
            writer.writeToFile("log3("+ pair.getKey()+") = | " + logarifm3.func(pair.getKey()));
        }
    }



}


