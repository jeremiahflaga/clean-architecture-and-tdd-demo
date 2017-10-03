package com.example.jboy.interactors.createcat;

/**
 * Created by Dev on 04/10/2017.
 */

public class CreateCatInteractor {


    private final CatsRepository repository;

    public CreateCatInteractor(CatsRepository repository) {
        this.repository = repository;
    }

    public CreateCatResponse execute(CreateCatRequest request) {
        CreateCatResponse response = new CreateCatResponse();
        response.grandioseName = String.format("%s \"%s\"", request.name, request.title);

        repository.save();

        return response;
    }
}
