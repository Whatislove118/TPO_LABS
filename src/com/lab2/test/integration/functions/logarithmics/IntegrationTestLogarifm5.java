package com.lab2.test.integration.functions.logarithmics;

import com.lab2.functions.logarithmics.Logarifm5;
import com.lab2.functions.logarithmics.LogarifmN;
import com.lab2.utils.TransformationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class IntegrationTestLogarifm5 {
    
    Double x = 1.4;
    Double expectedResult = Math.log(x) / Math.log(5.0);
    LogarifmN logarifmN;
    Logarifm5 logarifm5;
    TransformationService transformationService = new TransformationService();

    @Before
    public void setUp(){
        logarifm5 = new Logarifm5(transformationService);
        logarifmN = new LogarifmN();
    }



    @Test
    public void isolationTest_METHOD_STUB(){
        transformationService = Mockito.mock(TransformationService.class);
        when(transformationService.transformateLog5ToLn(x)).thenReturn(expectedResult);
        logarifm5 = new Logarifm5(transformationService);
        Assert.assertEquals(expectedResult,logarifm5.func(x),  0.001);
    }

    @Test
    public void isolationTest_ALL_STUBS(){
        logarifmN = Mockito.mock(LogarifmN.class);
        when(logarifmN.func(x)).thenReturn(Math.log(x));
        when(logarifmN.func(5.0)).thenReturn(Math.log(5.0));
        transformationService.setLogarifmN(logarifmN);
        Assert.assertEquals(expectedResult,logarifm5.func(x),  0.001);
    }

    @Test
    public void isolationTest_FIRST_STUB(){
        logarifmN = Mockito.spy(LogarifmN.class);
        when(logarifmN.func(x)).thenReturn(Math.log(x));
        transformationService.setLogarifmN(logarifmN);
        Assert.assertEquals(expectedResult,logarifm5.func(x),  0.001);
    }

    @Test
    public void integrationTest_WITHOUT_STUBS(){
        transformationService.setLogarifmN(logarifmN);
        Assert.assertEquals(expectedResult,logarifm5.func(x),  0.001);
    }
}
