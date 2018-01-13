package com.example.jboy.interactors.createcat;

import com.example.jboy.entities.Cat;
import com.example.jboy.repositories.CatsRepository;

import java.util.UUID;

/**
 * Created by Dev on 30/09/2017.
 */

class CreateCatInteractor {
    private CatsRepository repository;

    CreateCatInteractor(CatsRepository repository) {
        this.repository = repository;
    }

    public CreateCatResponse execute(CreateCatRequest request) {

        Cat cat = new Cat(UUID.randomUUID());
        cat.setName(request.name);
        cat.setTitle(request.title);

        repository.save(cat);

        CreateCatResponse response = new CreateCatResponse();
        response.id = cat.getId();
        response.name = request.name;
        response.title = request.title;

        return response;
    }
}
