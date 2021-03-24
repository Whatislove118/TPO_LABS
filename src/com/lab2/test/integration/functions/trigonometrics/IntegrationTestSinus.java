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
    Cosinus cosinus;
    Sinus sinus;



    @Before
    public void setUp(){
        cosinus = new Cosinus();
        sinus = new Sinus();

    }

    @Test
    public void isolationTest(){
        cosinus = Mockito.mock(Cosinus.class);
        when(cosinus.func(pi/2)).thenReturn(Math.cos(pi/2));
        TransformationService.setCosinus(cosinus);
        Assert.assertEquals(sinus.func(pi/2), Math.sin(pi/2), 0.001);
    }

    @Test
    public void integrationTest(){
        TransformationService.setCosinus(cosinus);
        Assert.assertEquals(sinus.func(pi/2), Math.sin(pi/2), 0.001);
    }
}
