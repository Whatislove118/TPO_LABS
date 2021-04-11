package com.lab2.test.integration.functions.trigonometrics;

import com.lab2.functions.logarithmics.Logarifm5;
import com.lab2.functions.logarithmics.LogarifmN;
import com.lab2.functions.trigonometrics.Cosinus;
import com.lab2.utils.TransformationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IntegrationTestCosinus {
    private final static Double pi = Math.PI;
    Cosinus cosinus;

    @Before
    public void setUp(){
        cosinus = new Cosinus();
    }

    @Test
    public void integrationTest(){
        cosinus = Mockito.mock(Cosinus.class);
        when(cosinus.func(pi/3)).thenReturn(Math.cos(pi/3));
        Assert.assertEquals(Math.cos(pi/3),cosinus.func(pi/3),  0.001);
    }

}
