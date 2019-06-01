package com.cinema.client.data;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.cinema.client.data.movie.Movie;
import com.cinema.client.ui.adapters.MoviesAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    List<Movie> movies = new ArrayList<>();
    List<Movie> soon = new ArrayList<>();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    int j = 0;


    public void createMovie() {
        db.collection("Movie").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for(QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
                    Movie movie = documentSnapshot.toObject(Movie.class);
                    String name = movie.getTitle();
                    String p = movie.getPosterUrl();
                    System.out.println(name);
                    System.out.println(p);

                    Intent i = new Intent("NEW_MOVIES");

                    movies.add(movie);

                    Bundle b = new Bundle();

                    b.putSerializable("movies", movies.get(j));
                    i.putExtra("bundle",b);

                    db.getApp().getApplicationContext().sendBroadcast(i);
                    System.out.println(movies);
                    j++;

                }

            }
        });
    }

    public List<Movie> getMovies() {
        createMovie();
        System.out.println(movies.isEmpty());
        return movies;
    }

    public void createSoon() {
        db.collection("Soon").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for(QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
                    Movie movie = documentSnapshot.toObject(Movie.class);
                    String name = movie.getTitle();
                    String p = movie.getPosterUrl();
                    System.out.println(name);
                    System.out.println(p);

                    Intent i = new Intent("SOON_MOVIES");

                    soon.add(movie);

                    Bundle bundle = new Bundle();

                    bundle.putSerializable("soon", soon.get(j));
                    i.putExtra("bundle2",bundle);

                    db.getApp().getApplicationContext().sendBroadcast(i);
                    System.out.println(soon);
                    j++;

                }

            }
        });
    }

}
