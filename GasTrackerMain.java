package com.example.android.taxtimereset;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class GasTrackerMain extends AppCompatActivity implements View.OnClickListener {


    public static final int CAMERA_REQUEST = 1;
    private ImageView imgTaken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas_tracker_main);

        String FileName = "Gas Receipt";
        TextView outdata = (TextView) findViewById(R.id.LocAwn);

        try {
            FileInputStream file_in = openFileInput(FileName);
            String FileData = "";
            int count;
            while ((count = file_in.read()) !=-1){
                FileData += Character.toString((char)count);
            }
            outdata.setText(FileData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        View HistoryBtn = (View) findViewById(R.id.HistoryBtn);
        Button camBtn = (Button) findViewById(R.id.camBtn);
        HistoryBtn.setOnClickListener(this);
        camBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.camBtn:
            String taxTimeImageDir = "Tax Time";
            Intent camIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            File pictureDirectory = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), taxTimeImageDir);
            String pictureName = getPictrueName();
            File imageFile = new File(pictureDirectory, pictureName);
            Uri pictureUri = Uri.fromFile(imageFile);
            camIntent.putExtra(MediaStore.EXTRA_OUTPUT, pictureUri);
            startActivityForResult(camIntent, CAMERA_REQUEST);
            break;
            case R.id.HistoryBtn:
                Intent showHistory = new Intent(this, history_view.class);
                startActivity(showHistory);
                break;

        }
    }


    private String getPictrueName() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timeStamp = sdf.format(new Date());
        return "Receipt " + timeStamp + ".jpg";
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == CAMERA_REQUEST) {
                startActivity(new Intent(this, gas_tracker_summary.class));
            }
        }

    }

}