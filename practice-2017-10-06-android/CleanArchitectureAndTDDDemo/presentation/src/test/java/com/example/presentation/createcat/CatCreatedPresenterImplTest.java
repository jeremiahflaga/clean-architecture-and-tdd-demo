package com.example.presentation.createcat;

import com.example.interactors.createcat.CreateCatResponse;

import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

/**
 * Created by MyndDev on 06/10/2017.
 */
public class CatCreatedPresenterImplTest {
    @Test
    public void passesCorrectViewModelToView() throws Exception {
        FakeCatCreatedView view = new FakeCatCreatedView();
        CatCreatedPresenterImpl presenter = new CatCreatedPresenterImpl(view);
        CreateCatResponse response = new CreateCatResponse();
        response.id = UUID.randomUUID();
        response.name = "Kang Kang";
        response.title = "The Great";

        presenter.present(response);

        Assert.assertEquals(
                String.format("%s: %s '%s'", response.id, response.name, response.title),
                view.theViewModelReceived().grandioseName);
    }

}