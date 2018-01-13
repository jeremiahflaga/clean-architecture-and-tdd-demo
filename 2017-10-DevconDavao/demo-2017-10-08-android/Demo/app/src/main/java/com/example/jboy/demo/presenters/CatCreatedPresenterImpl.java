package com.example.jboy.demo.presenters;

import com.example.interactors.createcat.CatCreatedPresenter;
import com.example.interactors.createcat.CreateCatResponse;
import com.example.jboy.demo.R;

/**
 * Created by Dev on 18/10/2017.
 */

public class CatCreatedPresenterImpl implements CatCreatedPresenter {

    private final CatCreatedView view;

    public CatCreatedPresenterImpl(CatCreatedView view) {
        this.view = view;
    }

    @Override
    public void present(CreateCatResponse response) {
        CatCreatedViewModel viewModel = new CatCreatedViewModel();
        viewModel.grandioseName = response.grandioseName;

        if (response.isImportant) {
            viewModel.colorOfGrandioseName = R.color.red;
        } else {
            viewModel.colorOfGrandioseName = R.color.blue;
        }

        view.show(viewModel);
    }

    @Override
    public void showValidationError(String errorMessage) {
        view.showErrorMessage(errorMessage);
    }
}
