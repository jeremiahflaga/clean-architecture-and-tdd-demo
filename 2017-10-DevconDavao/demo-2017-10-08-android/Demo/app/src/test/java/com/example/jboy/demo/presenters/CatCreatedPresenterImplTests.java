package com.example.jboy.demo.presenters;

import com.example.interactors.createcat.CreateCatResponse;
import com.example.jboy.demo.R;

import junit.framework.Assert;

import org.junit.Test;

import java.util.UUID;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Dev on 18/10/2017.
 */

public class CatCreatedPresenterImplTests {
    @Test
    public void shouldCreateCorrectViewModel() {
        FakeCatCreatedView view = new FakeCatCreatedView();
        CatCreatedPresenterImpl presenter = new CatCreatedPresenterImpl(view);

        CreateCatResponse response = new CreateCatResponse();
        response.id = UUID.randomUUID();
        response.grandioseName = "Kang Kang 'The Great'";

        presenter.present(response);

        assertEquals(response.grandioseName, view.theViewModelReceived().grandioseName);
    }

    @Test
    public void shouldShowRedGrandioseNameIfCatIsImportant() {
        FakeCatCreatedView view = new FakeCatCreatedView();
        CatCreatedPresenterImpl presenter = new CatCreatedPresenterImpl(view);

        CreateCatResponse response = new CreateCatResponse();
        response.isImportant = true;

        presenter.present(response);

        assertEquals(R.color.red, view.theViewModelReceived().colorOfGrandioseName);
    }

    @Test
    public void shouldShowBlueGrandioseNameIfCatIsNotImportant() {
        FakeCatCreatedView view = new FakeCatCreatedView();
        CatCreatedPresenterImpl presenter = new CatCreatedPresenterImpl(view);

        CreateCatResponse response = new CreateCatResponse();
        response.isImportant = false;

        presenter.present(response);

        assertEquals(R.color.blue, view.theViewModelReceived().colorOfGrandioseName);
    }

    @Test
    public void shouldShowValidationErrorMessage() {
        FakeCatCreatedView view = new FakeCatCreatedView();
        CatCreatedPresenterImpl presenter = new CatCreatedPresenterImpl(view);

        presenter.showValidationError("Error Msg");

        assertTrue(view.theShowErrorMessageMethodWasCalled());
        assertEquals("Error Msg", view.theErrorMessageReceivedByTheShowErrorMessageMethod());
    }
}
