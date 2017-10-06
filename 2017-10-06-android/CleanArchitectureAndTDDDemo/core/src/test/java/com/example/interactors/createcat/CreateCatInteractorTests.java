package com.example.interactors.createcat;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by MyndDev on 06/10/2017.
 */
public class CreateCatInteractorTests {

    @Test
    public void shouldReturnCorrectResponse() {
        CreateCatInteractor interactor = new CreateCatInteractor();
        String response = interactor.execute();
        Assert.assertEquals("Kang Kang 'The Great'", response);
    }
}