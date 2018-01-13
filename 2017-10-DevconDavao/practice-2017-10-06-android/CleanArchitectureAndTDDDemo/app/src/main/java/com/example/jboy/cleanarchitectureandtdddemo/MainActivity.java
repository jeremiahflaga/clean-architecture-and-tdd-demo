package com.example.jboy.cleanarchitectureandtdddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.data.CatsRepositoryImpl;
import com.example.interactors.createcat.CatCreatedPresenter;
import com.example.interactors.createcat.CreateCatInteractor;
import com.example.interactors.createcat.CreateCatRequest;
import com.example.jboy.cleanarchitectureandtdddemo.presenters.createcat.CatCreatedPresenterImpl;
import com.example.jboy.cleanarchitectureandtdddemo.presenters.createcat.CatCreatedView;
import com.example.jboy.cleanarchitectureandtdddemo.presenters.createcat.CatCreatedViewModel;

public class MainActivity extends AppCompatActivity implements CatCreatedView {

    TextView nameTextView;
    EditText nameEditText;
    EditText titleEditText;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextView = (TextView) findViewById(R.id.grandios_name_textview);
        nameEditText = (EditText) findViewById(R.id.name_edittext);
        titleEditText = (EditText) findViewById(R.id.title_edittext);
        saveButton = (Button) findViewById(R.id.save_button);

        CatCreatedPresenter presenter = new CatCreatedPresenterImpl(this);
        CatsRepositoryImpl repository = new CatsRepositoryImpl();
        final CreateCatInteractor interactor = new CreateCatInteractor(presenter, repository);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateCatRequest request = new CreateCatRequest();
                request.name = nameEditText.getText().toString();
                request.title = titleEditText.getText().toString();

                interactor.execute(request);
            }
        });
    }

    @Override
    public void showNewlyCreatedCat(CatCreatedViewModel viewModel) {
        nameTextView.setText(viewModel.grandioseName);
    }
}
