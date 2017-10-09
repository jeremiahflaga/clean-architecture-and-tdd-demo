package com.example.jboy.cleanarchitectureandtdddemo.presenters.createcat;

/**
 * Created by MyndDev on 06/10/2017.
 */

class FakeCatCreatedView implements CatCreatedView {
    private CatCreatedViewModel viewModelReceived;

    public CatCreatedViewModel theViewModelReceived() {
        return viewModelReceived;
    }

    public void showNewlyCreatedCat(CatCreatedViewModel viewModel) {
        this.viewModelReceived = viewModel;
    }
}
