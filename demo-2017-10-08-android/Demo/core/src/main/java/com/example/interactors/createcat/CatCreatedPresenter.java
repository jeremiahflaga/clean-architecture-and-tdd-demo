package com.example.interactors.createcat;

/**
 * Created by Dev on 08/10/2017.
 */

public interface CatCreatedPresenter {
    void present(CreateCatResponse response);
    void showValidationError(String errorMessage);
}
