package com.bonusteam.roomexcersise.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bonusteam.roomexcersise.Classes.AppDatabase;
import com.bonusteam.roomexcersise.Classes.Movie;
import com.bonusteam.roomexcersise.R;

public class AddMovieActivity extends AppCompatActivity {
    EditText name,studio,category;
    Button addMovie;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_movie);

        name = findViewById(R.id.edit_name);
        studio = findViewById(R.id.edit_studio);
        category = findViewById(R.id.edit_category);
        addMovie = findViewById(R.id.btn_add);

        addMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("RETURNED_MOVIE",new Movie(name.getText().toString(),studio.getText().toString(),category.getText().toString()));
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });

    }
}
