package com.example.resortvation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Goldland extends AppCompatActivity {
    ImageView mbackbtn;
    Button mContactbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goldland);

        mbackbtn = findViewById(R.id.backbtn);
        mContactbtn = findViewById(R.id.reservationbtn);

        mContactbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ContactForReservation.class));
            }
        });

        mbackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Page3.class));
            }
        });
    }
}