package com.example.jboy.demo.presenters;

import java.util.UUID;

/**
 * Created by Dev on 19/10/2017.
 */

class FakeCatCreatedView implements CatCreatedView {
    private CatCreatedViewModel viewModelReceived;
    private boolean showErrorMessageMethodCalled = false;
    private String errorMessageReceived;

    public CatCreatedViewModel theViewModelReceived() {
        return viewModelReceived;
    }

    @Override
    public void show(CatCreatedViewModel viewModel) {
        this.viewModelReceived = viewModel;
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        this.showErrorMessageMethodCalled = true;
        this.errorMessageReceived = errorMessage;
    }

    public boolean theShowErrorMessageMethodWasCalled() {
        return showErrorMessageMethodCalled;
    }

    public String theErrorMessageReceivedByTheShowErrorMessageMethod() {
        return errorMessageReceived;
    }
}
