package com.example.jboy.interactors.createcat;

/**
 * Created by Dev on 04/10/2017.
 */

public class CreateCatInteractor {

    public CreateCatResponse execute(CreateCatRequest request) {
        CreateCatResponse response = new CreateCatResponse();
        response.grandioseName = String.format("%s \"%s\"", request.name, request.title);
        return response;
    }
}
