package com.example.interactors.createcat;

import com.example.entities.Cat;
import com.example.repositories.CatsRepository;

import java.util.UUID;

/**
 * Created by MyndDev on 06/10/2017.
 */

public class CreateCatInteractor {

    CatCreatedPresenter presenter;
    private final CatsRepository repository;

    public CreateCatInteractor(CatCreatedPresenter presenter, CatsRepository repository) {
        this.presenter = presenter;
        this.repository = repository;
    }

    public void execute(CreateCatRequest request) {

        repository.save(new Cat());

        CreateCatResponse response = new CreateCatResponse();
        response.id = UUID.randomUUID();
        response.name = request.name;
        response.title = request.title;

        presenter.present(response);
    }
}
