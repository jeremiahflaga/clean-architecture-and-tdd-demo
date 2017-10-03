package com.example.jboy.interactors.createcat;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dev on 30/09/2017.
 */

public class CreateCatInteractorTests {

    CatCreatedPresenter presenter;
    FakeCatsRepository repository;
    CreateCatRequest request;
    CreateCatInteractor interactor;

    @Before
    public void setup() {
        // arrange
        presenter = new CatCreatedPresenter();
        repository = new FakeCatsRepository();
        interactor = new CreateCatInteractor(repository, presenter);
        request = new CreateCatRequest();
        request.name = "Kang Kang";
        request.title = "The Great";

        // act
        interactor.execute(request);
    }

    @Test
    public void shouldPassCorrectResponseToPresenter() {
        assertEquals("Kang Kang \"The Great\"", presenter.theResponseModelReceivedByPresentMethod().grandioseName);
        assertEquals(repository.theCatObjectThatWasPassedToTheSaveMethod().getId(), presenter.theResponseModelReceivedByPresentMethod().id);
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
