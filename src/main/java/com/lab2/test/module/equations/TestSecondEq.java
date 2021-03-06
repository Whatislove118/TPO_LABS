package com.lab2.test.module.equations;


import com.lab2.equations.SecondEquation;
import com.lab2.functions.logarithmics.Logarifm10;
import com.lab2.functions.logarithmics.Logarifm3;
import com.lab2.functions.logarithmics.Logarifm5;
import com.lab2.functions.trigonometrics.Cotangens;
import com.lab2.utils.CSVWriter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestSecondEq {

    private static Double separatePoint;
    private static Double seriesExpansionResult;
    private static ArrayList<Double> resultsTestCase;
    private static HashMap<Double, Double> firstPeriodParameters;
    private static HashMap<Double, Double> secondPeriodParameters;
    private static SecondEquation secondEquation;
    private static CSVWriter writer;

    @BeforeClass
    public static void setGeneralUp(){
        writer = new CSVWriter();
        secondEquation = new SecondEquation(new Logarifm3(), new Logarifm5(), new Logarifm10());
        resultsTestCase = new ArrayList<>();
        separatePoint = 1.0;
        seriesExpansionResult = 0.001684;

        firstPeriodParameters = new HashMap<>();
        firstPeriodParameters.put(0.5, 0.0167463);
        firstPeriodParameters.put(0.7, 0.000118313);

        secondPeriodParameters = new HashMap<>();
        secondPeriodParameters.put(1.2, 0.0000000000572513);
        secondPeriodParameters.put(1.4, 0.00000650471);

    }

    @Before
    public void setUp(){
        resultsTestCase.clear();
    }

    @Test
    public void testFirstPeriodFunctionValue(){
        for(Map.Entry<Double, Double> pair: firstPeriodParameters.entrySet()){
            Assert.assertEquals(pair.getValue(),secondEquation.func(pair.getKey()), 0.001);
            writer.writeToFile("secondEq("+ pair.getKey()+") = | " + secondEquation.func(pair.getKey()));
        }
    }

    @Test
    public void testSecondPeriodFunctionValue(){
        for(Map.Entry<Double, Double> pair: secondPeriodParameters.entrySet()){
            Assert.assertEquals(pair.getValue(),secondEquation.func(pair.getKey()), 0.001);
            writer.writeToFile("secondEq("+ pair.getKey()+") = | " + secondEquation.func(pair.getKey()));
        }
    }

    @Test
    public void testPointMinimum(){
        Assert.assertEquals(0.0, secondEquation.func(separatePoint), 0.001);
        writer.writeToFile("secondEq("+ separatePoint + ") = | " + secondEquation.func(separatePoint));
    }

    @Test
    public void testFirstPeriodFunctionValue_IS_DECREASING(){
        for(Map.Entry<Double, Double> pair : firstPeriodParameters.entrySet()){
            pair.setValue(secondEquation.func(pair.getKey()));
        }
        Double lowestValue = firstPeriodParameters.get(0.7);
        Double highestValue = firstPeriodParameters.get(0.5);
        Assert.assertTrue(lowestValue < highestValue);
    }

    @Test
    public void testSecondPeriodFunctionValue_IS_INCREASING(){
        for(Map.Entry<Double, Double> pair : secondPeriodParameters.entrySet()) {
            pair.setValue(secondEquation.func(pair.getKey()));
        }
        Double lowestValue = secondPeriodParameters.get(1.2);
        Double highestValue = secondPeriodParameters.get(1.4);
        Assert.assertTrue(lowestValue < highestValue);
    }


}
