package com.example.jboy.interactors.createcat;

import java.util.UUID;

/**
 * Created by Dev on 30/09/2017.
 */

class CreateCatInteractor {
    public CreateCatResponse execute(CreateCatRequest request) {
        CreateCatResponse response = new CreateCatResponse();
        response.id = UUID.randomUUID();
        response.name = request.name;
        response.title = request.title;
        return response;
    }
}
