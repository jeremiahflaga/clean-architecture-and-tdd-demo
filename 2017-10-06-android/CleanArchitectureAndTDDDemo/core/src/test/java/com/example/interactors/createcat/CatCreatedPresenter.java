package com.example.interactors.createcat;

/**
 * Created by MyndDev on 06/10/2017.
 */

class CatCreatedPresenter {

    private CreateCatResponse responseModel;

    public void present(CreateCatResponse response) {
        this.responseModel = response;
    }

    public CreateCatResponse theReponseModelReceived() {
        return this.responseModel;
    }
}
