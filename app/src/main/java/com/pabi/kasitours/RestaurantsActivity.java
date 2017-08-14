package com.pabi.kasitours;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Admin on 8/4/2017.
 */

public class RestaurantsActivity extends AppCompatActivity {

    final static  String DB_URL= "https://kasitours-c6166.firebaseio.com/";
    EditText nameeditText,urleditText,deseditText;
    Button btnsave;
    RecyclerView recyclerView;
    FirebaseClient firebaseClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        recyclerView=(RecyclerView)findViewById(R.id.Recylcerview);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        firebaseClient= new FirebaseClient(this, DB_URL,recyclerView);
        firebaseClient.refreshdata();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                displayDialog();

            }
        });
    }

    private void displayDialog()
    {
        Dialog d= new Dialog(this);
        d.setTitle("SaveData");
        d.setContentView(R.layout.customdialog_layout);
        nameeditText= (EditText)d.findViewById(R.id.nameEditText);
        urleditText=(EditText)d.findViewById(R.id.urlEditText);
        deseditText=(EditText)findViewById(R.id.desEditText);
        btnsave= (Button)d.findViewById(R.id.saveBtn);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseClient.savedata(nameeditText.getText().toString(),urleditText.getText().toString(),nameeditText.getText().toString());

                nameeditText.setText("");
                urleditText.setText("");
                deseditText.setText("");
            }
        });

        d.show();

    }

}
