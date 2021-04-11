package com.lab2.test.module.functions.logarithmics;

import com.lab2.functions.logarithmics.Logarifm3;
import com.lab2.functions.logarithmics.Logarifm5;
import com.lab2.utils.CSVWriter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestLogarifm5 {
    private static HashMap<Double, Double> periodPoints;

    private static Logarifm5 logarifm5;
    private static CSVWriter writer;

    @BeforeClass
    public static void setGenerallyUp(){
        logarifm5 = new Logarifm5();
        writer = new CSVWriter();
    }

    @Before
    public void setUp(){
        periodPoints = new HashMap<>();
        periodPoints.put(4.3, 0.906288);
        periodPoints.put(5.0, 1.0);


    }

    @Test
    public void testFunctionValue(){
        for(Map.Entry<Double, Double> pair : periodPoints.entrySet()){
            Assert.assertEquals(pair.getValue(),logarifm5.func(pair.getKey()), 0.001);
            writer.writeToFile("log5("+ pair.getKey()+") = | " + logarifm5.func(pair.getKey()));
        }
    }


}

