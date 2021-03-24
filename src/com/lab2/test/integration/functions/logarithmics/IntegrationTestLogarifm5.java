package com.lab2.test.integration.functions.logarithmics;

import com.lab2.functions.logarithmics.Logarifm3;
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

    LogarifmN logarifmN;
    Logarifm5 logarifm5;

    @Before
    public void setUp(){
        logarifm5 = new Logarifm5();
        logarifmN = new LogarifmN();
    }

    @Test
    public void isolationTest(){
        logarifmN = Mockito.mock(LogarifmN.class);

        when(logarifmN.func(1.4)).thenReturn(Math.log(1.4));
        when(logarifmN.func(5.0)).thenReturn(Math.log(5.0));

        TransformationService.setLogarifmN(logarifmN);
        Assert.assertEquals(logarifm5.func(1.4), Math.log(1.4) / Math.log(5.0), 0.001);
    }

    @Test
    public void integrationTest(){
        TransformationService.setLogarifmN(logarifmN);
        Assert.assertEquals(logarifm5.func(1.4), Math.log(1.4) / Math.log(5.0), 0.001);
    }
}
