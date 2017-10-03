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
        assertEquals(repository.theCatObjectThatWasPassedToTheSaveMethod().getId(), response.id);
    }

    @Test
    public void shouldSaveDataToDatabase() {
        assertTrue(repository.theSaveMethodWasCalled());
    }

    @Test
    public void shouldSaveCorrectDataToDatabase() {
        assertNotNull(repository.theCatObjectThatWasPassedToTheSaveMethod());
        assertNotNull(repository.theCatObjectThatWasPassedToTheSaveMethod().getId());
        assertEquals("Kang Kang", repository.theCatObjectThatWasPassedToTheSaveMethod().getName());
        assertEquals("The Great", repository.theCatObjectThatWasPassedToTheSaveMethod().getTitle());
    }
}
