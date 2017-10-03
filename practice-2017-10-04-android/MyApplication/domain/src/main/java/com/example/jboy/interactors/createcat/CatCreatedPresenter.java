package com.example.jboy.interactors.createcat;

/**
 * Created by Dev on 04/10/2017.
 */

class CatCreatedPresenter {
    public CatCreatedViewModel present(CreateCatResponse response) {

        CatCreatedViewModel viewModel = new CatCreatedViewModel();
        viewModel.grandioseName = response.grandioseName;
        return viewModel;
    }
}
