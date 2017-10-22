package com.example.interactors.createcat;

/**
 * Created by Dev on 09/10/2017.
 */

class FakeCatCreatedPresenter implements CatCreatedPresenter {
    private CreateCatResponse responseModelReceived;
    private boolean showValidationErrorMethodCalled = false;
    private String validationErrorMessage;

    @Override
    public void present(CreateCatResponse response) {
        this.responseModelReceived = response;
    }

    @Override
    public void showValidationError(String errorMessage) {
        showValidationErrorMethodCalled = true;
        validationErrorMessage = errorMessage;
    }

    public CreateCatResponse theReponseModelReceived() {
        return this.responseModelReceived;
    }

    public boolean theShowValidationErrorMethodWasCalled() {
        return showValidationErrorMethodCalled;
    }

    public String theValidationErrorMessage() {
        return this.validationErrorMessage;
    }
}
