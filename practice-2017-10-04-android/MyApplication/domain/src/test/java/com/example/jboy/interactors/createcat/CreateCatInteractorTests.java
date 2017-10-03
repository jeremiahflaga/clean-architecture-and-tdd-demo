package com.example.jboy.interactors.createcat;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dev on 30/09/2017.
 */

public class CreateCatInteractorTests {

    @Test
    public void shouldReturnCorrectResponse() {
        CreateCatInteractor interactor = new CreateCatInteractor();
        CreateCatRequest request = new CreateCatRequest();
        request.name = "Kang Kang";
        request.title = "The Great";

        CreateCatResponse response = interactor.execute(request);

        assertEquals("Kang Kang \"The Great\"", response.grandioseName);
    }



}
