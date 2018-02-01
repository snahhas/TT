package com.example.android.taxtimereset;


import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class gas_tracker_summary extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas_tracker_summary);


        Button sendFile =(Button)findViewById(R.id.sendFile);
        sendFile.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String FileName = "Gas Receipt";
        String Fileodo ="Odometer reading";
        EditText Location = (EditText) findViewById(R.id.Location);
        EditText Odometer = (EditText) findViewById(R.id.Odometer);
        String SaveAwnser = Location.getText().toString();
        String SaveOdometer =Odometer.getText().toString();

        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FileName, Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            fos.write(SaveAwnser.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Toast.makeText(this, "message sent", Toast.LENGTH_LONG).show();
        //startActivity(new Intent(this, GasTrackerMain.class));
        Intent backToMain = new Intent(this, GasTrackerMain.class);
        startActivity(backToMain);
    }

}
