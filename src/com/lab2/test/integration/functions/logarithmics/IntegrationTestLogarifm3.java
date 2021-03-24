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

    @Before
    public void setUp(){
        logarifm3 = new Logarifm3();
        logarifmN = new LogarifmN();
    }

    @Test
    public void isolationTest(){
        logarifmN = Mockito.mock(LogarifmN.class);
        when(logarifmN.func(2.0)).thenReturn(Math.log(2.0));
        when(logarifmN.func(3.0)).thenReturn(Math.log(3.0));
        TransformationService.setLogarifmN(logarifmN);
        Assert.assertEquals(logarifm3.func(2.0), Math.log(2.0) / Math.log(3.0) , 0.001);
    }

    @Test
    public void integrationTest(){
        TransformationService.setLogarifmN(logarifmN);
        Assert.assertEquals(logarifm3.func(2.0), Math.log(2.0) / Math.log(3.0), 0.001);
    }
}
