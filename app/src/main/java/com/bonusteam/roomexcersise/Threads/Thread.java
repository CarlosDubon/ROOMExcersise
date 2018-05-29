package com.bonusteam.roomexcersise.Threads;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.bonusteam.roomexcersise.Adapter.MoviesAdapter;
import com.bonusteam.roomexcersise.Classes.AppDatabase;
import com.bonusteam.roomexcersise.Classes.Movie;

import java.util.List;

public class Thread extends AsyncTask {
    private List<Movie> movies;
    private RecyclerView rv;
    private MoviesAdapter adapter;
    private AppDatabase db;

    public Thread(List<Movie> movies, RecyclerView rv, MoviesAdapter adapter,AppDatabase db){
        this.movies = movies;
        this.rv = rv;
        this.adapter=adapter;
        this.db = db;
    }
    @Override
    protected Object doInBackground(Object[] objects) {
        addMovies(movies);
        adapter = new MoviesAdapter(movies);
        rv.setAdapter(adapter);
        return null;
    }

    public void addMovies(List<Movie> movies){
        movies.add(new Movie("Valerian","sci-fi","MadHouse"));
        movies.add(new Movie("Mama-mia","Drama","IDK"));
    }
}
