package com.example.interactors.createcat;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by MyndDev on 06/10/2017.
 */
public class CreateCatInteractorTests {

    FakeCatsRepository repository = new FakeCatsRepository();
    
    @Test
    public void shouldPassCorrectResponseToPresenter() {
        FakeCatCreatedPresenter presenter = new FakeCatCreatedPresenter();
        CreateCatInteractor interactor = new CreateCatInteractor(presenter, repository);
        CreateCatRequest request = new CreateCatRequest();
        request.name = "Kang Kang";
        request.title = "The Great";

        interactor.execute(request);

        assertEquals(request.name, presenter.theReponseModelReceived().name);
        assertEquals(request.title, presenter.theReponseModelReceived().title);
        assertNotNull(presenter.theReponseModelReceived().id);
    }

    @Test
    public void shouldSaveNewCatToDatabase() {

        FakeCatCreatedPresenter presenter = new FakeCatCreatedPresenter();
        CreateCatInteractor interactor = new CreateCatInteractor(presenter, repository);
        CreateCatRequest request = new CreateCatRequest();
        request.name = "Kang Kang";
        request.title = "The Great";

        interactor.execute(request);

        assertTrue(repository.theSaveMethodWasCalled());
    }
}