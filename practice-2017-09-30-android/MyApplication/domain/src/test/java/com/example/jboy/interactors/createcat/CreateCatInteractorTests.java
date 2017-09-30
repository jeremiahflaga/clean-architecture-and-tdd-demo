package com.example.jboy.interactors.createcat;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dev on 30/09/2017.
 */

public class CreateCatInteractorTests {

    @Test
    public void shouldReturnCorrectResponse() {
        // arrange
        CreateCatInteractor interactor = new CreateCatInteractor();
        CreateCatRequest request = new CreateCatRequest();
        request.name = "Kang Kang";
        request.title = "The Great";

        // act
        CreateCatResponse response = interactor.execute(request);

        // assert
        assertNotNull(response);
        assertNotNull(response.id);
        assertEquals(request.name, response.name);
        assertEquals(request.title, response.title);
    }
}
