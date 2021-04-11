package com.lab2.test.integration.functions.trigonometrics;

import com.lab2.functions.trigonometrics.Cosinus;
import com.lab2.functions.trigonometrics.Cotangens;
import com.lab2.utils.TransformationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IntegrationTestCotangens {

    private final static Double pi = Math.PI;
    Double x = pi/6;
    Double expectedResult = Math.cos(x) / Math.sin(x);
    TransformationService transformationService = new TransformationService();
    Cosinus cosinus;
    Cotangens cotangens;



    @Before
    public void setUp(){
        cosinus = new Cosinus();
        cotangens = new Cotangens(transformationService);

    }

    @Test
    public void integrationTest_METHOD_STUB(){
        transformationService = Mockito.mock(TransformationService.class);
        when(transformationService.transformateCotanToCos(x)).thenReturn(expectedResult);
        cotangens = new Cotangens(transformationService);
        Assert.assertEquals(expectedResult,cotangens.func(x), 0.001);
    }

    @Test
    public void integrationTest_ALL_STUBS() {

        cosinus = Mockito.mock(Cosinus.class);
        when(cosinus.func(x)).thenReturn(Math.cos(x));

        transformationService = Mockito.spy(TransformationService.class);
        when(transformationService.transformateSinToCos(x)).thenReturn(Math.sin(x));

        transformationService.setCosinus(cosinus);
        cotangens = new Cotangens(transformationService);
        Assert.assertEquals(expectedResult, cotangens.func(x), 0.001);
    }

    @Test
    public void integrationTest_FIRST_STUB(){
        cosinus = Mockito.mock(Cosinus.class);
        when(cosinus.func(x)).thenReturn(Math.cos(x));

        transformationService = new TransformationService();
        transformationService.setCosinus(cosinus);
        cotangens = new Cotangens(transformationService);
        Assert.assertEquals(expectedResult, cotangens.func(x), 0.001);
    }

    @Test
    public void integrationTest_WITHOUT_STUB(){
        transformationService.setCosinus(cosinus);
        Assert.assertEquals(expectedResult,cotangens.func(x),  0.001);

    }
}
