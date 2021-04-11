package com.lab2.test.integration.equations;

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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IntegrationTestSystemEq {

    Double x = 0.39;
    Double expectedResult = 0.000000380703;
    FirstEquation firstEquation;
    SecondEquation secondEquation;
    SystemEquations systemEquations;


    @Before
    public void setUp(){
        firstEquation = new FirstEquation(new Tangens(), new Cosinus(), new Cotangens());
        secondEquation = new SecondEquation(new Logarifm3(), new Logarifm5(), new Logarifm10());
        systemEquations = new SystemEquations(firstEquation, secondEquation);
    }

    @Test
    public void integrationTest_METHOD_STUB(){
        systemEquations = Mockito.spy(SystemEquations.class);
        when(systemEquations.calculateSystem(x)).thenReturn(expectedResult);
        Assert.assertEquals(expectedResult, systemEquations.calculateSystem(x),  0.001);
    }

    @Test
    public void integrationTest_ALL_STUBS(){
        systemEquations.firstEquation = Mockito.spy(FirstEquation.class);
        systemEquations.secondEquation = Mockito.mock(SecondEquation.class);


        when(systemEquations.firstEquation.func(x)).thenReturn(0.173208);
        when(systemEquations.secondEquation.func(x)).thenReturn(1.09388);
        Assert.assertTrue(systemEquations.calculateSystem(x).isNaN());
        Mockito.reset(systemEquations.firstEquation);
        Mockito.reset(systemEquations.secondEquation);
    }

    @Test
    public void integrationTest_FIRST_STUB(){
        systemEquations.firstEquation = Mockito.spy(FirstEquation.class);

        when(systemEquations.firstEquation.func(x)).thenReturn(0.173208);
        Assert.assertTrue(systemEquations.calculateSystem(x).isNaN());
        Mockito.reset(systemEquations.firstEquation);
    }

    @Test
    public void integrationTest_WITHOUD_STUBS(){
        Assert.assertTrue(systemEquations.calculateSystem(x).isNaN());
    }


}
