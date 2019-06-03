package com.cinema.client.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cinema.client.R;
import com.cinema.client.data.hall.Place;

import java.util.ArrayList;

public class BookTicketActivity extends AppCompatActivity {

    private ArrayList<Place> bookedPlaces = new ArrayList<>();
    private Button btnBookPlaces;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ticket);

        btnBookPlaces = (Button)findViewById(R.id.btn_boock);
        btnBookPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookTickets();
            }
        });
    }

    private void updatePlaces(){

    }

    private void bookTickets(){

    }
}
