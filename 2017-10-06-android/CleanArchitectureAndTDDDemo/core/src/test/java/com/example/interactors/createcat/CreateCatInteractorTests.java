package com.example.interactors.createcat;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by MyndDev on 06/10/2017.
 */
public class CreateCatInteractorTests {

    @Test
    public void shouldPassCorrectResponseToPresenter() {
        CatCreatedPresenter presenter = new CatCreatedPresenter();
        CreateCatInteractor interactor = new CreateCatInteractor(presenter);

        interactor.execute();

        Assert.assertEquals("Kang Kang 'The Great'", presenter.theReponseModelReceived().name);
    }
}