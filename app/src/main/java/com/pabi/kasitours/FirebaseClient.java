package com.pabi.kasitours;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

/**
 * Created by Admin on 4/29/2017.
 */

public class FirebaseClient {

    Context c;
    String DB_URL;
    RecyclerView recyclerView;

    Firebase firebase;
    ArrayList<Parks> parks= new ArrayList<>();
    MyAdapter adapter;


    public FirebaseClient(Context c, String DB_URL, RecyclerView recyclerView)
    {
        this.c= c;
        this.DB_URL= DB_URL;
        this.recyclerView= recyclerView;

        Firebase.setAndroidContext(c);
        firebase=new Firebase(DB_URL);
    }

    public  void savedata (String name,String description, String url)
    {
        Parks b= new Parks();
        b.setName(name);
        b.setDescription(description);
        b.setUrl(url);

        firebase.child("Parks").push().setValue(b);

    }

    public  void refreshdata() {
        /**firebase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                getupdates(dataSnapshot);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });**/
    //}
        firebase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                getupdates(dataSnapshot);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                getupdates(dataSnapshot);

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    public void getupdates(DataSnapshot dataSnapshot){
        parks.clear();
        for(DataSnapshot ds :dataSnapshot.getChildren()){
            Parks b= new Parks();
            b.setName(ds.getValue(Parks.class).getName());
            b.setDescription(ds.getValue(Parks.class).getDescription());
            b.setUrl(ds.getValue(Parks.class).getUrl());
            parks.add(b);
        }
        if(parks.size()>0)
        {
            adapter=new MyAdapter(c, parks);
            recyclerView.setAdapter(adapter);
        }else
        {
            Toast.makeText(c, "No data", Toast.LENGTH_SHORT).show();
        }
    }


}
