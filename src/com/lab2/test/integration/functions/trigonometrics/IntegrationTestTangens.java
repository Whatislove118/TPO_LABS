package com.lab2.test.integration.functions.trigonometrics;

import com.lab2.functions.logarithmics.Logarifm5;
import com.lab2.functions.logarithmics.LogarifmN;
import com.lab2.functions.trigonometrics.Cosinus;
import com.lab2.functions.trigonometrics.Cotangens;
import com.lab2.functions.trigonometrics.Tangens;
import com.lab2.utils.TransformationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.swing.text.TabableView;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IntegrationTestTangens {

    private final static Double pi = Math.PI;
    Cosinus cosinus;
    Tangens tangens;

    @Before
    public void setUp(){
        cosinus = new Cosinus();
        tangens = new Tangens();

    }

    @Test
    public void isolationTest(){
        cosinus = Mockito.mock(Cosinus.class);
        when(cosinus.func(pi/4)).thenReturn(Math.cos(pi/4));
        TransformationService.setCosinus(cosinus);
        Assert.assertEquals(tangens.func(pi/4), Math.tan(pi/4), 0.001);
    }

    @Test
    public void integrationTest(){
        TransformationService.setCosinus(cosinus);
        Assert.assertEquals(tangens.func(pi/4), Math.tan(pi/4),  0.001);
    }
}
