package com.pabi.kasitours;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Admin on 4/29/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Parks> parks;

    public MyAdapter(Context c, ArrayList<Parks> parks){
        this.c= c;
        this.parks=parks;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.parks_layout,parent,false);
        MyHolder holder= new MyHolder(v);
        holder.addressTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c,MapsActivity.class);
                c.startActivity(intent);
            }
        });
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intImg = new Intent(c,ParksActivity.class);
                c.startActivity(intImg);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.nameTxt.setText(parks.get(position).getName());
        holder.nameDes.setText(parks.get(position).getDescription());
       // holder.txt.setText(parks.get(position).getTxt());

        PicassoClient.downloadimg(c, parks.get(position).getUrl(),holder.img);
        //PicassoClient.downloadimage(c,holder.parksImage,holder.restaurantsImage,holder.restaurantsImage);

       /** Picasso.with(c)
                .load(parks.get(position)
                        .getImage()).resize(120,60)
                .into(holder.img);**/
    }


    @Override
    public int getItemCount() {
        return parks.size();
    }

}

