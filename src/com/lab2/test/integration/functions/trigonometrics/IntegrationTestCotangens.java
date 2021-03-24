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
public class IntegrationTestCotangens {

    private final static Double pi = Math.PI;
    Cosinus cosinus;
    Cotangens cotangens;



    @Before
    public void setUp(){
        cosinus = new Cosinus();
        cotangens = new Cotangens();

    }

    @Test
    public void isolationTest(){
        cosinus = Mockito.mock(Cosinus.class);
        when(cosinus.func(pi/6)).thenReturn(Math.cos(pi/6));
        TransformationService.setCosinus(cosinus);
        Assert.assertEquals(cotangens.func(pi/6), Math.cos(pi/6) / Math.sin(pi/6), 0.001);
    }

    @Test
    public void integrationTest(){
        TransformationService.setCosinus(cosinus);
        Assert.assertEquals(cotangens.func(pi/6), Math.cos(pi/6) / Math.sin(pi/6), 0.001);
    }
}
