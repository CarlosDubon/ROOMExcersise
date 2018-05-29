package com.bonusteam.roomexcersise.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bonusteam.roomexcersise.Classes.Movie;
import com.bonusteam.roomexcersise.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.moviesViewHolder> {
    private List<Movie> movies;
    public MoviesAdapter(List<Movie> movieList) {
        movies = movieList;
    }

    public static class moviesViewHolder extends RecyclerView.ViewHolder{
        TextView name,studio,category;
        public moviesViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text_movie_name);
            studio = itemView.findViewById(R.id.text_studio);
            category = itemView.findViewById(R.id.text_category);
        }
    }


    @NonNull
    @Override
    public moviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview,parent,false);
        return new moviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull moviesViewHolder holder, int position) {
        holder.name.setText(movies.get(position).getNomMovie());
        holder.studio.setText(movies.get(position).getNomEstudio());
        holder.category.setText(movies.get(position).getNomCategory());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
