package com.example.jboy.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.interactors.createcat.CatCreatedPresenter;
import com.example.interactors.createcat.CreateCatInteractor;
import com.example.interactors.createcat.CreateCatRequest;
import com.example.interactors.createcat.CreateCatResponse;
import com.example.interactors.createcat.CreateCatValidator;
import com.example.jboy.data.InMemoryCatsRepository;
import com.example.jboy.demo.presenters.CatCreatedPresenterImpl;
import com.example.jboy.demo.presenters.CatCreatedView;
import com.example.jboy.demo.presenters.CatCreatedViewModel;
import com.example.repositories.CatsRepository;

public class MainActivity extends AppCompatActivity implements CatCreatedView {

    EditText catNameEditText;
    EditText catTitleEditText;
    Button createCatButton;
    TextView grandioseNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        catNameEditText = (EditText) findViewById(R.id.cat_name_edittext);
        catTitleEditText = (EditText) findViewById(R.id.cat_title_edittext);
        createCatButton = (Button) findViewById(R.id.create_cat_button);
        grandioseNameTextView = (TextView) findViewById(R.id.grandiose_name_textview);


        createCatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CatCreatedPresenter presenter = new CatCreatedPresenterImpl(MainActivity.this);
                CatsRepository repository = new InMemoryCatsRepository();
                CreateCatValidator validator = new CreateCatValidator();

                CreateCatInteractor interactor = new CreateCatInteractor(presenter, repository, validator);

                CreateCatRequest request = new CreateCatRequest();
                request.name = catNameEditText.getText().toString();
                request.title = catTitleEditText.getText().toString();

                interactor.execute(request);
            }
        });
    }

    @Override
    public void show(CatCreatedViewModel viewModel) {
        grandioseNameTextView.setText(viewModel.grandioseName);
        grandioseNameTextView.setTextColor(getResources().getColor(viewModel.colorOfGrandioseName));
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG);
    }
}
