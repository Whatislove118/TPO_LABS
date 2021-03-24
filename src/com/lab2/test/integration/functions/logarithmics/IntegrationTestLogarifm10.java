package com.lab2.test.integration.functions.logarithmics;

import com.lab2.functions.logarithmics.Logarifm10;
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
public class IntegrationTestLogarifm10 {

    LogarifmN logarifmN;
    Logarifm10 logarifm10;

    @Before
    public void setUp(){
        logarifm10 = new Logarifm10();
        logarifmN = new LogarifmN();
    }

    @Test
    public void isolationTest(){
        logarifmN = Mockito.mock(LogarifmN.class);

        when(logarifmN.func(0.56)).thenReturn(Math.log(0.56));
        when(logarifmN.func(10.0)).thenReturn(Math.log(10.0));

        TransformationService.setLogarifmN(logarifmN);
        Assert.assertEquals(logarifm10.func(0.56), Math.log(0.56) / Math.log(10.0), 0.001);
    }

    @Test
    public void integrationTest(){
        TransformationService.setLogarifmN(logarifmN);
        Assert.assertEquals(logarifm10.func(0.56), Math.log(0.56) / Math.log(10.0), 0.001);
    }
}
