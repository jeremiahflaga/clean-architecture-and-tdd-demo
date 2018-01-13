package com.example.jboy.demo.presenters;

/**
 * Created by Dev on 19/10/2017.
 */

public interface CatCreatedView {
    void show(CatCreatedViewModel viewModel);
    void showErrorMessage(String errorMessage);
}
