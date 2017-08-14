package com.pabi.kasitours;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Admin on 4/29/2017.
 */

public class MyHolder extends RecyclerView.ViewHolder {

    TextView nameTxt;
    TextView nameDes;
    TextView addressTxt;
    ImageView img;
    //ImageView Image;
    //ImageView restaurantsImage;
    //ImageView entertainmentImage;

    public MyHolder(View itemView) {
        super(itemView);

        nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);
        nameDes = (TextView) itemView.findViewById(R.id.nameDes);
        addressTxt = (TextView) itemView.findViewById(R.id.addressTxt);
        img=(ImageView) itemView.findViewById(R.id.ImageV);
       // parksImage = (ImageView)itemView.findViewById(R.id.parksImage);
        //restaurantsImage = (ImageView)itemView.findViewById(R.id.restaurantsImage);
        //entertainmentImage = (ImageView)itemView.findViewById(R.id.entertainmentImage);
        //itemView.setClickable(true);
        //itemView.setOnClickListener((View.OnClickListener) this);
    }
}
