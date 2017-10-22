package com.example.interactors.createcat;

import com.example.entities.Cat;
import com.example.repositories.CatsRepository;

import java.util.UUID;

/**
 * Created by Dev on 08/10/2017.
 */

public class CreateCatInteractor {

    private final CatCreatedPresenter presenter;
    private final CatsRepository repository;
    private final CreateCatValidator validator;

    public CreateCatInteractor(
            CatCreatedPresenter presenter,
            CatsRepository repository,
            CreateCatValidator validator) {
        this.presenter = presenter;
        this.repository = repository;
        this.validator = validator;
    }

    public void execute(CreateCatRequest request) {
         CreateCatValidator.ValidationResult validationResult =
                 validator.validate(request);

        if (!validationResult.isValid()) {
            presenter.showValidationError(validationResult.errorMessage);
            return;
        }

        Cat cat = new Cat(UUID.randomUUID(), request.name);
        cat.setTitle(request.title);
        repository.save(cat);

        CreateCatResponse response = new CreateCatResponse();
        response.id = cat.getId();
        response.grandioseName = cat.grandioseName();
        response.isImportant = cat.isImportant();

        presenter.present(response);
    }
}
