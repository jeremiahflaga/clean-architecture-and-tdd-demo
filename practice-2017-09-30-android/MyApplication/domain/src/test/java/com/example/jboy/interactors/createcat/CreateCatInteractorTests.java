package com.example.jboy.interactors.createcat;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dev on 30/09/2017.
 */

public class CreateCatInteractorTests {

    FakeCatsRepository repository = new FakeCatsRepository();

    @Test
    public void shouldReturnCorrectResponse() {
        // arrange
        CreateCatInteractor interactor = new CreateCatInteractor(repository);
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

    @Test
    public void shouldSaveDataToTheDatabase() {
        // arrange
        CreateCatInteractor interactor = new CreateCatInteractor(repository);
        CreateCatRequest request = new CreateCatRequest();
        request.name = "Kang Kang";
        request.title = "The Great";

        // act
        CreateCatResponse response = interactor.execute(request);

        // assert
        assertTrue(repository.theSaveMethodWasCalled());
        assertNotNull(repository.theCatEntityThatWasReceivedByTheSaveMethod());
        assertNotNull(repository.theCatEntityThatWasReceivedByTheSaveMethod().getId());
        assertEquals(request.name, repository.theCatEntityThatWasReceivedByTheSaveMethod().getName());
        assertEquals(request.title, repository.theCatEntityThatWasReceivedByTheSaveMethod().getTitle());
    }
}
