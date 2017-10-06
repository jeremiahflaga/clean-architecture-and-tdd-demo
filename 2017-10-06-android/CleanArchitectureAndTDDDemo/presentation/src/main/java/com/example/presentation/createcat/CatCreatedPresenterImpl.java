package com.example.presentation.createcat;


import com.example.interactors.createcat.CatCreatedPresenter;
import com.example.interactors.createcat.CreateCatResponse;

/**
 * Created by MyndDev on 06/10/2017.
 */

public class CatCreatedPresenterImpl implements CatCreatedPresenter {
    private final CatCreatedView view;

    public CatCreatedPresenterImpl(CatCreatedView view) {
        this.view = view;
    }

    @Override
    public void present(CreateCatResponse response) {
        CatCreatedViewModel viewModel = new CatCreatedViewModel();
        viewModel.grandioseName = "Kang Kang 'The Great'";

        view.showNewlyCreatedCat(viewModel);
    }
}
