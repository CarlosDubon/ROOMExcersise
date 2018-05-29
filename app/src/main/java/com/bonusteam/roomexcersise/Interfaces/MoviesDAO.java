package com.bonusteam.roomexcersise.Interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.bonusteam.roomexcersise.Classes.Movie;

import java.util.List;
import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface MoviesDAO {
    @Query("SELECT * FROM MOVIE ORDER BY idMovie ASC")
    List<Movie> getAll();

    @Insert(onConflict = REPLACE)
    void insertMovie(Movie movie);
}
