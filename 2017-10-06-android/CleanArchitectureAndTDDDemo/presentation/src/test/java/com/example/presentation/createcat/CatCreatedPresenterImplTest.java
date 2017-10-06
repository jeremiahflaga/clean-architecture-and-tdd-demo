package com.example.presentation.createcat;

import com.example.interactors.createcat.CatCreatedPresenter;
import com.example.interactors.createcat.CreateCatResponse;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by MyndDev on 06/10/2017.
 */
public class CatCreatedPresenterImplTest {
    @Test
    public void passesCorrectViewModelToView() throws Exception {
        CatCreatedView view = new CatCreatedView();
        CatCreatedPresenterImpl presenter = new CatCreatedPresenterImpl(view);

        presenter.present(new CreateCatResponse());

        Assert.assertEquals("Kang Kang 'The Great'", view.theViewModelReceived().grandioseName);
    }

}