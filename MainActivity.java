package com.example.android.taxtimereset;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button gasBtn = (Button) findViewById(R.id.gasBtn);
        Button resBtn = (Button) findViewById(R.id.resBtn);
        Button supBtn = (Button) findViewById(R.id.supBtn);
        Button rentBtn = (Button) findViewById(R.id.rentBtn);
        Button maiBtn = (Button) findViewById(R.id.maiBtn);
        Button utiBtn = (Button) findViewById(R.id.utiBtn);
        Button invBtn = (Button) findViewById(R.id.invBtn);
        Button marBtn = (Button) findViewById(R.id.marBtn);

        gasBtn.setOnClickListener(this);
        resBtn.setOnClickListener(this);
        supBtn.setOnClickListener(this);
        rentBtn.setOnClickListener(this);
        maiBtn.setOnClickListener(this);
        utiBtn.setOnClickListener(this);
        invBtn.setOnClickListener(this);
        marBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.gasBtn:
                Intent GasIntent = new Intent(this,GasTrackerMain.class);
                startActivity(GasIntent);
                break;
            case R.id.resBtn:
                Intent ResIntent = new Intent(this,restaurant.class);
                startActivity(ResIntent);
                break;
            case R.id.supBtn:
                Intent supIntent = new Intent(this,supplies.class);
                startActivity(supIntent);
                break;
            case R.id.rentBtn:
                Intent rentIntent = new Intent(this,rent.class);
                startActivity(rentIntent);
                break;
            case R.id.maiBtn:
                Intent maiIntent = new Intent(this,maintanance.class);
                startActivity(maiIntent);
                break;
            case R.id.utiBtn:
                Intent utiIntent = new Intent(this,utilities.class);
                startActivity(utiIntent);
                break;
            case R.id.invBtn:
                Intent invIntent = new Intent(this,inventory.class);
                startActivity(invIntent);
                break;
            case R.id.marBtn:
                Intent marIntent = new Intent(this,marketing.class);
                startActivity(marIntent);
                break;

        }
    }
}
