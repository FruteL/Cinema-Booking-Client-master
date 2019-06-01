package com.cinema.client.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.cinema.client.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MoviePage extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private ImageView ImageView;
    private TextView MvName;
    private TextView AboutMv;
    private TextView MvInfo;
    private TextView MvLabel;
    private Button BuyBtn;
    private VideoView MvTrailer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_page);

        mAuth = FirebaseAuth.getInstance();

        ImageView = (ImageView)findViewById(R.id.movie_poster);
        MvName = (TextView)findViewById(R.id.movie_name);
        AboutMv = (TextView)findViewById(R.id.about_movie);
        MvInfo = (TextView)findViewById(R.id.movie_info);
        MvLabel = (TextView)findViewById(R.id.movie_trailer_label);
        BuyBtn = (Button)findViewById(R.id.movie_buy_ticket);
        MvTrailer = (VideoView)findViewById(R.id.movie_trailer_video);

    }

}
