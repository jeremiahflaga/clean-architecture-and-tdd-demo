package com.example.interactors.createcat;

import com.example.repositories.FakeCatsRepository;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Dev on 08/10/2017.
 */

public class CreateCatInteractorTests_ImportanceTests {

    FakeCatCreatedPresenter presenter = new FakeCatCreatedPresenter();
    FakeCatsRepository repository = new FakeCatsRepository();
    CreateCatValidator validator = new CreateCatValidator();
    CreateCatInteractor interactor;
    CreateCatRequest request;

    @Before
    public void setup() {
        interactor = new CreateCatInteractor(presenter, repository, validator);
        request = new CreateCatRequest();
    }

    @Test
    public void shouldSayCatIsImportantIfGrandioseNameIsLessThanTen() {
        request.name = "123";
        interactor.execute(request);
        assertTrue(presenter.theReponseModelReceived().isImportant);
    }

    @Test
    public void shouldSayCatIsNotImportantIfGrandioseNameIsEqualToTen() {
        request.name = "1234567890";
        interactor.execute(request);
        assertFalse(presenter.theReponseModelReceived().isImportant);
    }

    @Test
    public void shouldSayCatIsNotImportantIfGrandioseNameIsGreaterThanTen() {
        request.name = "123456789AB";
        interactor.execute(request);
        assertFalse(presenter.theReponseModelReceived().isImportant);
    }
}
