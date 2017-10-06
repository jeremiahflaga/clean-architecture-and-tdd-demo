package com.example.interactors.createcat;

/**
 * Created by MyndDev on 06/10/2017.
 */

class CreateCatInteractor {

    CatCreatedPresenter presenter;

    public CreateCatInteractor(CatCreatedPresenter presenter) {
        this.presenter = presenter;
    }

    public void execute() {
        CreateCatResponse response = new CreateCatResponse();
        response.name = "Kang Kang 'The Great'";

        presenter.present(response);
    }
}
