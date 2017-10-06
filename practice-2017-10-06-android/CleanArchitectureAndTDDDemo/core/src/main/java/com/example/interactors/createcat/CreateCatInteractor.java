package com.example.interactors.createcat;

import java.util.UUID;

/**
 * Created by MyndDev on 06/10/2017.
 */

public class CreateCatInteractor {

    CatCreatedPresenter presenter;

    public CreateCatInteractor(CatCreatedPresenter presenter) {
        this.presenter = presenter;
    }

    public void execute(CreateCatRequest request) {

        CreateCatResponse response = new CreateCatResponse();
        response.id = UUID.randomUUID();
        response.name = request.name;
        response.title = request.title;

        presenter.present(response);
    }
}
