package com.example.jboy.interactors.createcat;

import com.example.jboy.entities.Cat;
import com.example.jboy.repositories.CatsRepository;

import java.util.UUID;

/**
 * Created by Dev on 04/10/2017.
 */

public class CreateCatInteractor {


    private final CatsRepository repository;
    private final CatCreatedPresenter presenter;

    public CreateCatInteractor(CatsRepository repository, CatCreatedPresenter presenter) {
        this.repository = repository;
        this.presenter = presenter;
    }

    public CreateCatResponse execute(CreateCatRequest request) {
        Cat cat = new Cat(UUID.randomUUID());
        cat.setName(request.name);
        cat.setTitle(request.title);

        repository.save(cat);

        CreateCatResponse response = new CreateCatResponse();
        response.id = cat.getId();
        response.grandioseName = String.format("%s \"%s\"", request.name, request.title);

        presenter.present(response);

        return response;
    }
}
