package com.example.jboy.interactors.createcat;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dev on 30/09/2017.
 */

public class CreateCatInteractorTests {

    FakeCatsRepository repository = new FakeCatsRepository();
    CreateCatInteractor interactor;
    CreateCatRequest request;
    CreateCatResponse response;

    @Before
    public void setup() {

        // arrange
        interactor = new CreateCatInteractor(repository);

        request = new CreateCatRequest();
        request.name = "Kang Kang";
        request.title = "The Great";

        // act
        response = interactor.execute(request);

    }

    @Test
    public void checkThatItReceivedTheCorrectRequest() {

    }

    @Test
    public void shouldReturnCorrectResponse() {
        // assert
        assertNotNull(response);
        assertNotNull(response.id);
        assertEquals(request.name, response.name);
        assertEquals(request.title, response.title);
    }

    @Test
    public void shouldSaveDataToTheDatabase() {
        // assert
        assertTrue(repository.theSaveMethodWasCalled());
        assertNotNull(repository.theCatEntityThatWasReceivedByTheSaveMethod());
        assertNotNull(repository.theCatEntityThatWasReceivedByTheSaveMethod().getId());
        assertEquals(request.name, repository.theCatEntityThatWasReceivedByTheSaveMethod().getName());
        assertEquals(request.title, repository.theCatEntityThatWasReceivedByTheSaveMethod().getTitle());
    }

    @Test
    public void shouldReturnTheSameCatAsTheOneSavedToTheDatabase() {
        assertEquals(repository.theCatEntityThatWasReceivedByTheSaveMethod().getId(), response.id);
        assertEquals(repository.theCatEntityThatWasReceivedByTheSaveMethod().getName(), response.name);
        assertEquals(repository.theCatEntityThatWasReceivedByTheSaveMethod().getTitle(), response.title);
    }

}
