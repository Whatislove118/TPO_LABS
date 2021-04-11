package com.lab2.test.integration.functions.trigonometrics;

import com.lab2.functions.logarithmics.Logarifm5;
import com.lab2.functions.logarithmics.LogarifmN;
import com.lab2.functions.trigonometrics.Cosinus;
import com.lab2.functions.trigonometrics.Cotangens;
import com.lab2.functions.trigonometrics.Sinus;
import com.lab2.utils.TransformationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IntegrationTestSinus {

    private final static Double pi = Math.PI;
    Double x = pi/4;
    Double expectedResult = Math.sin(x);
    TransformationService transformationService = new TransformationService();
    Cosinus cosinus;
    Sinus sinus;



    @Before
    public void setUp(){
        cosinus = new Cosinus();
        sinus = new Sinus(transformationService);

    }

    @Test
    public void integrationTest_METHOD_STUB(){
        transformationService = Mockito.mock(TransformationService.class);
        when(transformationService.transformateSinToCos(x)).thenReturn(expectedResult);
        sinus = new Sinus(transformationService);
        Assert.assertEquals(expectedResult,sinus.func(x), 0.001);
    }

    @Test
    public void integrationTest_FIRST_STUB() {

        cosinus = Mockito.mock(Cosinus.class);
        when(cosinus.func(x)).thenReturn(Math.cos(x));


        transformationService.setCosinus(cosinus);
        sinus = new Sinus(transformationService);
        Assert.assertEquals(expectedResult, sinus.func(x), 0.001);
    }



    @Test
    public void integrationTest_WITHOUT_STUB(){
        transformationService.setCosinus(cosinus);
        Assert.assertEquals(expectedResult,sinus.func(x),  0.001);

    }
}
