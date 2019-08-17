package com.example.wi_fijoyapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {

    public static String address="";
    public static String ip="";
    public static int port=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        if (getIntent().hasExtra("address")){

            address = getIntent().getStringExtra("address");
        }


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        Constants.SCREEN_HEIGHT = dm.heightPixels;
        Constants.SCREEN_WIDTH = dm.widthPixels;
        setContentView(new App(this,this));
        Toast.makeText(getApplicationContext(), address,
                Toast.LENGTH_LONG).show();

    }


    public static void getIp()
    {
        String list[] = address.split(":");
        ip = list[0];
        port = Integer.valueOf(list[1]);
    }

    public void exit()
    {
        System.exit(0);
    }



}


