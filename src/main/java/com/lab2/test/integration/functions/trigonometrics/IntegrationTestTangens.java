package com.lab2.test.integration.functions.trigonometrics;

import com.lab2.functions.trigonometrics.Cosinus;
import com.lab2.functions.trigonometrics.Cotangens;
import com.lab2.functions.trigonometrics.Tangens;
import com.lab2.utils.TransformationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IntegrationTestTangens {

    private final static Double pi = Math.PI;
    Double x = pi/3;
    Double expectedResult = Math.sin(x) / Math.cos(x);
    TransformationService transformationService = new TransformationService();
    Cosinus cosinus;
    Tangens tangens;



    @Before
    public void setUp(){
        cosinus = new Cosinus();
        tangens = new Tangens(transformationService);

    }

    @Test
    public void integrationTest_METHOD_STUB(){
        transformationService = Mockito.mock(TransformationService.class);
        when(transformationService.transformateTanToCos(x)).thenReturn(expectedResult);
        tangens = new Tangens(transformationService);
        Assert.assertEquals(expectedResult, tangens.func(x), 0.001);
    }

    @Test
    public void integrationTest_ALL_STUBS() {
        cosinus = Mockito.mock(Cosinus.class);
        when(cosinus.func(x)).thenReturn(Math.cos(x));

        transformationService = Mockito.spy(TransformationService.class);
        when(transformationService.transformateSinToCos(x)).thenReturn(Math.sin(x));

        transformationService.setCosinus(cosinus);
        tangens = new Tangens(transformationService);
        Assert.assertEquals(expectedResult, tangens.func(x), 0.001);
    }

    @Test
    public void integrationTest_FIRST_STUB(){
        cosinus = Mockito.mock(Cosinus.class);
        when(cosinus.func(x)).thenReturn(Math.cos(x));

        transformationService = new TransformationService();
        transformationService.setCosinus(cosinus);
        tangens = new Tangens(transformationService);
        Assert.assertEquals(expectedResult, tangens.func(x), 0.001);
    }

    @Test
    public void integrationTest_WITHOUT_STUB(){
        transformationService.setCosinus(cosinus);
        Assert.assertEquals(expectedResult, tangens.func(x),  0.001);

    }
}
