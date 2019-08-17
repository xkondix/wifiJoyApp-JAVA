package com.example.wi_fijoyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    EditText et;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 =  findViewById(R.id.button);
        b2 =  findViewById(R.id.button2);
        et =   findViewById(R.id.editText);


        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String address = et.getText().toString();
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                i.putExtra("address", address);
                startActivity(i);
            }
        });



    }
}
