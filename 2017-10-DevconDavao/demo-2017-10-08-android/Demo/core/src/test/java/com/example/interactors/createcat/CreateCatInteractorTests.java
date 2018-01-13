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

public class CreateCatInteractorTests {

    FakeCatCreatedPresenter presenter = new FakeCatCreatedPresenter();
    FakeCatsRepository repository = new FakeCatsRepository();
    CreateCatValidator validator = new CreateCatValidator();
    CreateCatInteractor interactor;
    CreateCatRequest request;

    @Before
    public void setup() {
        interactor = new CreateCatInteractor(presenter, repository, validator);
        request = new CreateCatRequest();
        request.name = "Kang Kang";
        request.title = "The Great";

        interactor.execute(request);
    }

    @Test
    public void shouldPassCorrectResponseToThePresenter() {
        assertNotNull(presenter.theReponseModelReceived().id);
        assertEquals("Kang Kang 'The Great'", presenter.theReponseModelReceived().grandioseName);
    }

    @Test
    public void shouldSaveNewCatToDatabase() {
        assertTrue(repository.theSaveMethodWasCalled());
    }

    @Test
    public void shouldSaveCorrectCatToDatabase() {
        assertNotNull(repository.theCatEntityReceivedByTheSaveMethod().getId());
        assertEquals(request.name, repository.theCatEntityReceivedByTheSaveMethod().getName());
        assertEquals(request.title, repository.theCatEntityReceivedByTheSaveMethod().getTitle());
    }

    @Test
    public void theCatSavedToDatabaseMustBeTheSameAsTheOneGivenToPresenter() {
        assertEquals(
                repository.theCatEntityReceivedByTheSaveMethod().getId(),
                presenter.theReponseModelReceived().id
        );
    }
}
