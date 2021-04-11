package com.lab2.test.integration.equations;


import com.lab2.equations.SecondEquation;
import com.lab2.functions.logarithmics.Logarifm10;
import com.lab2.functions.logarithmics.Logarifm3;
import com.lab2.functions.logarithmics.Logarifm5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class IntegrationTestSecondEq {

    Double x = 1.3;
    Double expectedResult = 0.000000380703;


    Logarifm3 logarifm3;
    Logarifm5 logarifm5;
    Logarifm10 logarifm10;

    SecondEquation secondEquation;


    @Before
    public void setUp(){
      logarifm3 = new Logarifm3();
      logarifm5 = new Logarifm5();
      logarifm10 = new Logarifm10();

      secondEquation = new SecondEquation(logarifm3,logarifm5,logarifm10);

    }

    @Test
    public void integrationTest_METHOD_STUB(){
        secondEquation = Mockito.mock(SecondEquation.class);
        when(secondEquation.func(x)).thenReturn(expectedResult);
        Assert.assertEquals(expectedResult, secondEquation.func(x),  0.001);
    }

    @Test
    public void integrationTest_ALL_STUBS(){
        logarifm3 = Mockito.mock(Logarifm3.class);
        logarifm5 = Mockito.mock(Logarifm5.class);
        logarifm10 = Mockito.mock(Logarifm10.class);


        when(logarifm3.func(x)).thenReturn(Math.log(x) / Math.log(3.0));
        when(logarifm5.func(x)).thenReturn(Math.log(x) / Math.log(5.0));
        when(logarifm10.func(x)).thenReturn(Math.log(x) / Math.log(10.0));
        secondEquation = new SecondEquation(logarifm3,logarifm5,logarifm10);
        Assert.assertEquals(expectedResult, secondEquation.func(x), 0.001);
    }

    @Test
    public void integrationTest_FIRST_STUB(){

        logarifm3 = Mockito.mock(Logarifm3.class);
        logarifm5 = Mockito.mock(Logarifm5.class);


        when(logarifm3.func(x)).thenReturn(Math.log(x) / Math.log(3.0));
        when(logarifm5.func(x)).thenReturn(Math.log(x) / Math.log(5.0));
        secondEquation = new SecondEquation(logarifm3,logarifm5,logarifm10);
        Assert.assertEquals(expectedResult, secondEquation.func(x), 0.001);
    }

    @Test
    public void integrationTest_SECOND_STUB(){
        logarifm3 = Mockito.mock(Logarifm3.class);

        when(logarifm3.func(x)).thenReturn(Math.log(x) / Math.log(3.0));
        secondEquation = new SecondEquation(logarifm3,logarifm5,logarifm10);
        Assert.assertEquals(expectedResult, secondEquation.func(x), 0.001);
    }

    @Test
    public void integrationTest_WITHOUD_STUBS(){
        secondEquation = new SecondEquation(logarifm3,logarifm5,logarifm10);
        Assert.assertEquals(expectedResult, secondEquation.func(x), 0.001);
    }




}
