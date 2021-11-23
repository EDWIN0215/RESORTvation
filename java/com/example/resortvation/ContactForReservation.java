package com.example.resortvation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ContactForReservation extends AppCompatActivity {


    Button mbutton;
    Button mbutton1;
    Button mbutton2;
    Button mbutton3;

    Button mConfirmbtn;
    Button mbackbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_for_reservation);

        mbutton = findViewById(R.id.buttoncolor);
        mbutton1 = findViewById(R.id.buttoncolor1);
        mbutton2 = findViewById(R.id.buttoncolor2);
        mbutton3 = findViewById(R.id.buttoncolor3);

        mbackbtn = findViewById(R.id.backbtn);

        mbackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Page3.class));
            }
        });

        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mbutton.isSelected()==true){
                    mbutton.setSelected(false);
                }else if(mbutton.isSelected()==false){
                    mbutton.setSelected(true);
                }
            }
        });
        mbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mbutton1.isSelected()==true){
                    mbutton1.setSelected(false);
                }else if(mbutton1.isSelected()==false){
                    mbutton1.setSelected(true);
                }
            }
        });
        mbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mbutton2.isSelected()==true){
                    mbutton2.setSelected(false);
                }else if(mbutton2.isSelected()==false){
                    mbutton2.setSelected(true);
                }
            }
        });
        mbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mbutton3.isSelected()==true){
                    mbutton3.setSelected(false);
                }else if(mbutton3.isSelected()==false){
                    mbutton3.setSelected(true);
                }
            }
        });

        mConfirmbtn = findViewById(R.id.confirmbtn);

        mConfirmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ContactForReservation.this);

                builder.setTitle("Confirm");
                builder.setMessage("Are you sure?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing but close the dialog
                        dialog.dismiss();

                        Intent i = new Intent(getApplicationContext(), Proceedtoconfirm.class);
                        startActivity(i);
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Do nothing
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}