package com.lab2.test.module.equations;

import com.lab2.equations.FirstEquation;
import com.lab2.equations.SecondEquation;
import com.lab2.equations.SystemEquations;
import com.lab2.functions.logarithmics.Logarifm10;
import com.lab2.functions.logarithmics.Logarifm3;
import com.lab2.functions.logarithmics.Logarifm5;
import com.lab2.functions.trigonometrics.Cosinus;
import com.lab2.functions.trigonometrics.Cotangens;
import com.lab2.functions.trigonometrics.Tangens;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;


public class TestSystemEq {
    private ArrayList<Double> points;
    private static SystemEquations systemEquations;

    @BeforeClass
    public static void setGenerallyUp(){
        systemEquations = new SystemEquations(
                new FirstEquation(
                        new Tangens(), new Cosinus(), new Cotangens()
                ),
                new SecondEquation(
                        new Logarifm3(), new Logarifm5(), new Logarifm10()
                )
        );
    }

    @Before
    public void setUp(){
        points = new ArrayList<>();
        points.add(-5.0);
        points.add(5.0);
    }


    @Test
    public void testFunction_DOESNT_HAVE_ANY_DECISION(){
        for (Double point : points){
            Assert.assertTrue(systemEquations.calculateSystem(point).isNaN());
        }
    }
}
