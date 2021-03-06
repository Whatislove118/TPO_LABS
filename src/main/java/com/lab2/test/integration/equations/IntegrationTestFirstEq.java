package com.lab2.test.integration.equations;

import com.lab2.equations.FirstEquation;
import com.lab2.functions.trigonometrics.Cosinus;
import com.lab2.functions.trigonometrics.Cotangens;
import com.lab2.functions.trigonometrics.Sinus;
import com.lab2.functions.trigonometrics.Tangens;
import com.lab2.utils.TransformationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.swing.text.TabableView;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IntegrationTestFirstEq {
    private final static Double pi = Math.PI;
    Double x = -pi/3;
    Double expectedResult = 3.5;

    Cosinus cosinus;
    Tangens tangens;
    Cotangens cotangens;
    Sinus sinus;

    FirstEquation firstEquation;
    TransformationService transformationService;


    @Before
    public void setUp(){
        transformationService = new TransformationService();
        cosinus = new Cosinus();
        cotangens = new Cotangens(transformationService);
        tangens = new Tangens(transformationService);
        sinus = new Sinus(transformationService);
        firstEquation = new FirstEquation(tangens, cosinus, cotangens);
    }

    @Test
    public void integrationTest_METHOD_STUB(){
        firstEquation = Mockito.mock(FirstEquation.class);
        when(firstEquation.func(x)).thenReturn(expectedResult);
        Assert.assertEquals(expectedResult, firstEquation.func(x),  0.001);
    }

    @Test
    public void integrationTest_ALL_STUBS(){
        cosinus = Mockito.mock(Cosinus.class);
        tangens = Mockito.mock(Tangens.class);
        cotangens = Mockito.mock(Cotangens.class);
        when(cotangens.func(x)).thenReturn(1/Math.tan(x));
        when(tangens.func(x)).thenReturn(Math.tan(x));
        when(cosinus.func(x)).thenReturn(Math.cos(x));
        firstEquation = new FirstEquation(tangens, cosinus, cotangens);
        Assert.assertEquals(expectedResult, firstEquation.func(x), 0.001);
    }

    @Test
    public void integrationTest_FIRST_STUB(){
        cosinus = Mockito.mock(Cosinus.class);
        tangens = Mockito.mock(Tangens.class);
        when(cosinus.func(x)).thenReturn(Math.cos(x));
        when(tangens.func(x)).thenReturn(-Math.tan(x));


        transformationService.setCosinus(cosinus);
        firstEquation = new FirstEquation(tangens, cosinus, cotangens);
        Assert.assertEquals(expectedResult, firstEquation.func(x), 0.001);
    }

    @Test
    public void integrationTest_SECOND_STUB(){
        cosinus = Mockito.mock(Cosinus.class);
        when(cosinus.func(x)).thenReturn(Math.cos(x));

        firstEquation = new FirstEquation(tangens, cosinus, cotangens);
        Assert.assertEquals(expectedResult, firstEquation.func(x), 0.001);
    }

    @Test
    public void integrationTest_WITHOUD_STUB(){
        firstEquation = new FirstEquation(tangens, cosinus, cotangens);
        Assert.assertEquals(expectedResult, firstEquation.func(x), 0.001);
    }

}
