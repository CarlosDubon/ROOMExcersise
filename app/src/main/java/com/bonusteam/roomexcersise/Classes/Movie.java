package com.bonusteam.roomexcersise.Classes;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

@Entity(tableName = "movie")
public class Movie implements Parcelable{

    @PrimaryKey(autoGenerate = true)
    private int idMovie;

    @ColumnInfo(name = "nom_movie")
    private String nomMovie;

    @ColumnInfo(name = "desc_movie")
    private String descMovie;

    @ColumnInfo(name = "nom_category")
    private  String nomCategory;

    @ColumnInfo(name = "nom_studio")
    private String nomEstudio;

    public Movie() {
    }

    public Movie(String nomMovie, String nomCategory, String nomEstudio) {
        this.nomMovie = nomMovie;
        this.nomCategory = nomCategory;
        this.nomEstudio = nomEstudio;
    }

    protected Movie(Parcel in) {
        idMovie = in.readInt();
        nomMovie = in.readString();
        descMovie = in.readString();
        nomCategory = in.readString();
        nomEstudio = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    public String getNomMovie() {
        return nomMovie;
    }

    public void setNomMovie(String nomMovie) {
        this.nomMovie = nomMovie;
    }

    public String getDescMovie() {
        return descMovie;
    }

    public void setDescMovie(String descMovie) {
        this.descMovie = descMovie;
    }

    public String getNomCategory() {
        return nomCategory;
    }

    public void setNomCategory(String nomCategory) {
        this.nomCategory = nomCategory;
    }

    public String getNomEstudio() {
        return nomEstudio;
    }

    public void setNomEstudio(String nomEstudio) {
        this.nomEstudio = nomEstudio;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idMovie);
        dest.writeString(nomMovie);
        dest.writeString(descMovie);
        dest.writeString(nomCategory);
        dest.writeString(nomEstudio);
    }
}
