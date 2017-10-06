package com.example.interactors.createcat;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by MyndDev on 06/10/2017.
 */
public class CreateCatInteractorTests {

    @Test
    public void shouldPassCorrectResponseToPresenter() {
        FakeCatCreatedPresenter presenter = new FakeCatCreatedPresenter();
        CreateCatInteractor interactor = new CreateCatInteractor(presenter);

        interactor.execute();

        Assert.assertEquals("Kang Kang 'The Great'", presenter.theReponseModelReceived().name);
    }
}