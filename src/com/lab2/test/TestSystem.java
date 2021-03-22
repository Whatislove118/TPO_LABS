package com.lab2.test;

import com.lab2.equations.SystemEquations;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


public class TestSystem {
    private ArrayList<Double> points;

    @Before
    public void setUp(){
        points = new ArrayList<>();
        points.add(-5.0);
        points.add(5.0);
    }


    @Test
    public void testFunction_DOESNT_HAVE_ANY_DECISION(){
        for (Double point : points){
            Assert.assertTrue(SystemEquations.calculateSystem(point).isNaN());
        }
    }
}
