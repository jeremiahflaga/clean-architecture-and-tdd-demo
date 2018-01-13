package com.example.interactors.createcat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.portable.ResponseHandler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by MyndDev on 06/10/2017.
 */
public class CreateCatInteractorTests {

    FakeCatsRepository repository = new FakeCatsRepository();
    FakeCatCreatedPresenter presenter = new FakeCatCreatedPresenter();
    CreateCatInteractor interactor;
    CreateCatRequest request;

    @Before
    public void setup() {
        interactor = new CreateCatInteractor(presenter, repository);
        request = new CreateCatRequest();
        request.name = "Kang Kang";
        request.title = "The Great";

        interactor.execute(request);
    }

    @Test
    public void shouldPassCorrectResponseToPresenter() {
        assertEquals(request.name, presenter.theReponseModelReceived().name);
        assertEquals(request.title, presenter.theReponseModelReceived().title);
        assertNotNull(presenter.theReponseModelReceived().id);
        assertEquals(repository.theCatEntityReceivedByTheSaveMethod().getId(), presenter.theReponseModelReceived().id);
    }

    @Test
    public void shouldSaveNewCatToDatabase() {
        assertTrue(repository.theSaveMethodWasCalled());
    }

    @Test
    public void shouldSaveCorrectDataToDatabase() {
        assertNotNull(repository.theCatEntityReceivedByTheSaveMethod().getId());
        assertEquals(request.name, repository.theCatEntityReceivedByTheSaveMethod().getName());
        assertEquals(request.title, repository.theCatEntityReceivedByTheSaveMethod().getTitle());
    }
}