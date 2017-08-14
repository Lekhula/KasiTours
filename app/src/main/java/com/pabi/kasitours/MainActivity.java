package com.pabi.kasitours;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Admin on 8/7/2017.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);


    /**private final String nameTxt[] = {
            "Parks",
            "Restaurants",
            "Entertainment"
    };

    private final String image[] = {
            "https://firebasestorage.googleapis.com/v0/b/kasilami-7996f.appspot.com/o/Parks.jpg?alt=media&token=469a45c5-35b3-49f4-96f1-4c72bc2b6e3b",
            "https://firebasestorage.googleapis.com/v0/b/kasilami-7996f.appspot.com/o/Restaurants.jpg?alt=media&token=11d343f3-d1ff-44e7-b72e-adb3c46121ee",
            "https://firebasestorage.googleapis.com/v0/b/kasilami-7996f.appspot.com/o/Entertainment.jpg?alt=media&token=edfd0caa-8fdc-4e2c-bfa8-3e31dc3cfa67"
    };

    Context c;

    // CardView cl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        initView();
    }

    private void initView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList list = prepareData();
        MyAdapter adapter = new MyAdapter(getApplicationContext(), list);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList prepareData() {
        ArrayList list = new ArrayList<>();
        for (int i = 0; i < nameTxt.length; i++) {
            Parks parks = new Parks();
            parks.setTxt(nameTxt[i]);
            parks.setImage(image[i]);
            list.add(parks);

        }
        return list;
    }
}**/

        ImageView park = (ImageView)findViewById(R.id.parksImage);
        ImageView rest = (ImageView)findViewById(R.id.restaurantsImage);
        //final CardView cl = (CardView)findViewById(R.id.cl);
        ImageView enter = (ImageView)findViewById(R.id.entertainmentImage);

        Glide.with(getApplicationContext())
                .load("https://firebasestorage.googleapis.com/v0/b/kasitours-c6166.appspot.com/o/Parks.jpg?alt=media&token=649895be-e22e-4974-8013-e0a085b41d80")
                .into(park);

       park.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPark = new Intent(MainActivity.this, ParksActivity.class);
                startActivity(intentPark);
            }
        });

        Glide.with(getApplicationContext())
                .load("https://firebasestorage.googleapis.com/v0/b/kasitours-c6166.appspot.com/o/Restaurants.jpg?alt=media&token=f09649cf-cab3-4476-9e0a-67f8203fdff8")
                .into(rest);

        rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRest = new Intent(MainActivity.this,RestaurantsActivity.class);
                startActivity(intentRest);
            }
        });

        Glide.with(getApplicationContext())
                .load("https://firebasestorage.googleapis.com/v0/b/kasitours-c6166.appspot.com/o/Entertainment.jpg?alt=media&token=dc92bac1-9025-431e-8384-b6c8e4c8c450")
                .into(enter);


        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEnter = new Intent(MainActivity.this,EntertainmentActivity.class);
                startActivity(intentEnter);
            }
        });
        //setImages();
       /** Glide.with(MainActivity.this).load("https://firebasestorage.googleapis.com/v0/b/kasitours-c6166.appspot.com/o/soweto_towers.jpg?alt=media&token=c62a47c9-c5da-44bf-864d-058b2a579b8e")
                .asBitmap().
                into(new SimpleTarget<Bitmap>(400, 400) {
        @Override
        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
            Drawable drawable = new BitmapDrawable(resource);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                cl.setBackground(drawable);
            }
        }
    });**/
    }
}



