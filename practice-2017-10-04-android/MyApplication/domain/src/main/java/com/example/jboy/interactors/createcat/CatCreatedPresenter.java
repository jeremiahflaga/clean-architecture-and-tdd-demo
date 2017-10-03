package com.example.jboy.interactors.createcat;

/**
 * Created by Dev on 04/10/2017.
 */

class CatCreatedPresenter {
    private CreateCatResponse responseModelReceived;

    public void present(CreateCatResponse response) {
        this.responseModelReceived = response;
    }

    public CreateCatResponse theResponseModelReceivedByPresentMethod() {
        return this.responseModelReceived;
    }
}
