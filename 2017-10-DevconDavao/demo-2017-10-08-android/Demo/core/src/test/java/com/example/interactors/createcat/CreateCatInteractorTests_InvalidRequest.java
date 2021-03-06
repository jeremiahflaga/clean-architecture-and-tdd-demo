package com.example.interactors.createcat;

import com.example.repositories.FakeCatsRepository;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Dev on 08/10/2017.
 */

public class CreateCatInteractorTests_InvalidRequest {

    FakeCatCreatedPresenter presenter = new FakeCatCreatedPresenter();
    FakeCatsRepository repository = new FakeCatsRepository();
    CreateCatValidator validator = new CreateCatValidator();
    CreateCatInteractor interactor;
    CreateCatRequest request;

    @Before
    public void setup() {
        interactor = new CreateCatInteractor(presenter, repository, validator);
        request = new CreateCatRequest();
        request.name = "Devil";

        interactor.execute(request);
    }

    @Test
    public void shouldShowValidationErrorMessageIfNameIsDevil() {
        assertTrue(presenter.theShowValidationErrorMethodWasCalled());
    }

    @Test
    public void shouldShowCorrectValidationErrorMessage() {
        assertEquals(
                "Sorry! We do not want the devil to become a god.",
                presenter.theValidationErrorMessage());
    }
}
