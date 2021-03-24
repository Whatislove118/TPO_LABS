package com.lab2.test.integration.functions.logarithmics;

import com.lab2.functions.logarithmics.Logarifm3;
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
public class IntegrationTestLogarifm3 {

    LogarifmN logarifmN;
    Logarifm3 logarifm3;
    Double x = 2.0;
    Double expectedResult = Math.log(x) / Math.log(3.0);
    TransformationService transformationService;

    @Before
    public void setUp(){
        transformationService = new TransformationService();
        logarifm3 = new Logarifm3(transformationService);
        logarifmN = new LogarifmN();
    }

    @Test
    public void isolationTest_METHOD_STUB(){
        transformationService = Mockito.mock(TransformationService.class);
        when(transformationService.transformateLog3ToLn(x)).thenReturn(expectedResult);
        logarifm3 = new Logarifm3(transformationService);
        Assert.assertEquals(expectedResult, logarifm3.func(x), 0.001);
    }

    @Test
    public void isolationTest_ALL_STUBS(){
        logarifmN = Mockito.mock(LogarifmN.class);
        when(logarifmN.func(x)).thenReturn(Math.log(x));
        when(logarifmN.func(3.0)).thenReturn(Math.log(3.0));
        transformationService.setLogarifmN(logarifmN);
        Assert.assertEquals(expectedResult, logarifm3.func(x), 0.001);
    }

    @Test
    public void isolationTest_FIRST_STUB(){
        logarifmN = Mockito.spy(LogarifmN.class);
        when(logarifmN.func(x)).thenReturn(Math.log(x));
        transformationService.setLogarifmN(logarifmN);
        Assert.assertEquals(expectedResult, logarifm3.func(x), 0.001);
    }

    @Test
    public void integrationTest_WITHOUT_STUBS(){
        transformationService.setLogarifmN(logarifmN);
        Assert.assertEquals(expectedResult, logarifm3.func(x), 0.001);
    }
}
