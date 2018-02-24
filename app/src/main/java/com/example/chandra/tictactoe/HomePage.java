package com.example.chandra.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class HomePage extends AppCompatActivity {


    Button play,exit,how,about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        play=(Button)findViewById(R.id.b1);
        exit=(Button)findViewById(R.id.b3);
        how=(Button)findViewById(R.id.b2);
        about=(Button)findViewById(R.id.b4);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent info =new Intent(HomePage.this,MainActivity.class);
                startActivity(info);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

        how.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent info =new Intent(HomePage.this,HowToPlay.class);
                startActivity(info);
            }
        });


        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent info =new Intent(HomePage.this,AboutUs.class);
                startActivity(info);
            }
        });
    }
}
