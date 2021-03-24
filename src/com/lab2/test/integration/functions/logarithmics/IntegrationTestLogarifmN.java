package com.lab2.test.integration.functions.logarithmics;


import com.lab2.functions.logarithmics.LogarifmN;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IntegrationTestLogarifmN {

    @Mock
    LogarifmN logarifmN;

    @Test
    public void integrationTest(){
        when(logarifmN.func(2.0)).thenReturn(0.6931);
        Assert.assertEquals(logarifmN.func(2.0), 0.6931, 0.001);
    }
}
