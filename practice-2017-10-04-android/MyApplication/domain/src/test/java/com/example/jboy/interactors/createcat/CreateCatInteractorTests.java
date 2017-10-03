package com.example.jboy.interactors.createcat;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dev on 30/09/2017.
 */

public class CreateCatInteractorTests {

    CatsRepository repository;
    CreateCatRequest request;
    CreateCatInteractor interactor;

    CreateCatResponse response;

    @Before
    public void setup() {

        // arrange
        repository = new CatsRepository();
        interactor = new CreateCatInteractor(repository);
        request = new CreateCatRequest();
        request.name = "Kang Kang";
        request.title = "The Great";

        // act
        response = interactor.execute(request);
    }

    @Test
    public void shouldReturnCorrectResponse() {
        assertEquals("Kang Kang \"The Great\"", response.grandioseName);
    }

    @Test
    public void shouldSaveDataToDatabase() {
        assertTrue(repository.theSaveMethodWasCalled());
    }

}
