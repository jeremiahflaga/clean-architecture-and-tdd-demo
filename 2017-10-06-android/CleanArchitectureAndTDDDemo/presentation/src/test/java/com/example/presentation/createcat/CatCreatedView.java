package com.example.presentation.createcat;

/**
 * Created by MyndDev on 06/10/2017.
 */

class CatCreatedView {
    private CatCreatedViewModel viewModelReceived;

    public CatCreatedViewModel theViewModelReceived() {
        return viewModelReceived;
    }

    public void showNewlyCreatedCat(CatCreatedViewModel viewModel) {
        this.viewModelReceived = viewModel;
    }
}
