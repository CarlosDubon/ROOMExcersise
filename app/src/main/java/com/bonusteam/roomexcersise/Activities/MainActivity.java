package com.bonusteam.roomexcersise.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bonusteam.roomexcersise.Adapter.MoviesAdapter;
import com.bonusteam.roomexcersise.Classes.AppDatabase;
import com.bonusteam.roomexcersise.Classes.Movie;
import com.bonusteam.roomexcersise.R;
import com.bonusteam.roomexcersise.Threads.Thread;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static int ADD_MOVIE_RESULT = 1;
    private RecyclerView rv;
    private MoviesAdapter adapter;
    private List<Movie> movieList;
    private FloatingActionButton fab;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.recyclerview_movies);
        adapter = new MoviesAdapter(movieList);
        rv.setLayoutManager(new LinearLayoutManager(this));

        db = AppDatabase.getAppDatabase(getApplicationContext());
        movieList = db.moviesDAO().getAll();

        new Thread(movieList,rv,adapter,db).execute();
        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AddMovieActivity.class);
                startActivityForResult(i,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == ADD_MOVIE_RESULT ){
            if(resultCode == Activity.RESULT_OK){
                Movie movie = data.getParcelableExtra("RETURNED_MOVIE");
                db.moviesDAO().insertMovie(movie);
                movieList = db.moviesDAO().getAll();
                adapter.notifyDataSetChanged();
            }
        }
    }
}
