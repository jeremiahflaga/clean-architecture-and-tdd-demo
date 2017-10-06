package com.example.jboy.cleanarchitectureandtdddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.interactors.createcat.CatCreatedPresenter;
import com.example.interactors.createcat.CreateCatInteractor;
import com.example.presentation.createcat.CatCreatedPresenterImpl;
import com.example.presentation.createcat.CatCreatedView;
import com.example.presentation.createcat.CatCreatedViewModel;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements CatCreatedView {

    TextView nameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextView = (TextView) findViewById(R.id.name_textview);

        CatCreatedPresenter presenter = new CatCreatedPresenterImpl(this);
        CreateCatInteractor interactor = new CreateCatInteractor(presenter);
        interactor.execute();
    }

    @Override
    public void showNewlyCreatedCat(CatCreatedViewModel viewModel) {
        nameTextView.setText(viewModel.grandioseName);
    }
}
