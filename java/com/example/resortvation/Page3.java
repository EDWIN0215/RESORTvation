package com.example.resortvation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class Page3 extends AppCompatActivity {
    private Spinner spinner;

    private Button logout;

    private ViewPager2 viewPager2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        logout = findViewById(R.id.logoutbtn);

        spinner = findViewById(R.id.spinner);

        viewPager2 = findViewById(R.id.viewPagerImageSlider);

        //here im preparingl list of images from drawable,
        //you can get it from APi as well

        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.lislandpic));
        sliderItems.add(new SliderItem(R.drawable.urdanetagardenpic));
        sliderItems.add(new SliderItem(R.drawable.springlandpic));
        sliderItems.add(new SliderItem(R.drawable.aljenpic));
        sliderItems.add(new SliderItem(R.drawable.goldlandpic));

        viewPager2.setAdapter(new SliderAdapter(sliderItems, viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0 ).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.5f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);





        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });

        List<String> categories = new ArrayList<>();
        categories.add(0, "Choose Resort");
        categories.add("Lisland Resort");
        categories.add("Goldland Resort");
        categories.add("Springland Resort");
        categories.add("Urdaneta Garden Resort");
        categories.add("Aljen Resort");

        //Style and populate the spinner
        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,categories);

        //Dropdown layout style
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getItemAtPosition(position).equals("Choose Categories"))
                {
                    //do nothing
                }
                if (parent.getItemAtPosition(position).equals("Lisland Resort"))
                {
                    Intent intent = new Intent(Page3.this, Lisland.class);
                    startActivity(intent);
                }
                if (parent.getItemAtPosition(position).equals("Goldland Resort"))
                {
                    Intent intent = new Intent(Page3.this, Goldland.class);
                    startActivity(intent);
                }
                if (parent.getItemAtPosition(position).equals("Springland Resort"))
                {
                    Intent intent = new Intent(Page3.this, Springland.class);
                    startActivity(intent);
                }
                if (parent.getItemAtPosition(position).equals("Urdaneta Garden Resort"))
                {
                    Intent intent = new Intent(Page3.this, UrdanetaGarden.class);
                    startActivity(intent);
                }

                if (parent.getItemAtPosition(position).equals("Aljen Resort"))
                {
                    Intent intent = new Intent(Page3.this, Aljen.class);
                    startActivity(intent);
                }

                else
                {
                    //on selsecting a spinner item
                    String item =  parent.getItemAtPosition(position).toString();

                    //show selected spinner item
                    Toast.makeText(parent.getContext(),"Selected:" +item,Toast.LENGTH_SHORT).show();

                    //anything else you want to do on item selection do here



                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                //TODO Auto-generated method

            }
        });

    }
}