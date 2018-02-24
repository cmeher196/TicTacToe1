package com.example.chandra.tictactoe;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView tv1;
    Button b[][]=new Button[3][3];
    int c[][] = new int[3][3];
    Button back,result;
    static boolean bool =false;
    static int counter;
    static String op,op1;

    public void buttonEnabled() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b[i][j].isEnabled()) {
                    b[i][j].setVisibility(View.INVISIBLE);
                }
            }
        }
    }

    public void alertForX()
    {
        op1="CONGRATULATIONS";
        op="Player 'X' Wins";
        tv1.setBackgroundColor(Color.parseColor("#a14d1b"));
        tv1.setText("Player 'X' WINS\n(click on the result button)");
        result.setVisibility(View.VISIBLE);
    }



    public void alertForO()
    {
        op1="CONGRATULATIONS";
        op="Player 'O' Wins";
        tv1.setBackgroundColor(Color.parseColor("#a14d1b"));
        tv1.setText("Player 'O' WINS\n(click on the result button)");
        result.setVisibility(View.VISIBLE);
    }

    public void alertForDraw()
    {

        op1="OOPS.. ;)";
        op=" ITS DRAW....";
        tv1.setBackgroundColor(Color.parseColor("#a14d1b"));
        tv1.setText("DRAW\n(click on the result button)");
        result.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b[0][0]=(Button)findViewById(R.id.b1);
        b[0][1]=(Button)findViewById(R.id.b2);
        b[0][2]=(Button)findViewById(R.id.b3);
        b[1][0]=(Button)findViewById(R.id.b4);
        b[1][1]=(Button)findViewById(R.id.b5);
        b[1][2]=(Button)findViewById(R.id.b6);
        b[2][0]=(Button)findViewById(R.id.b7);
        b[2][1]=(Button)findViewById(R.id.b8);
        b[2][2]=(Button)findViewById(R.id.b9);
        back=(Button)findViewById(R.id.b21);
        result=(Button)findViewById(R.id.b22);
        tv1=(TextView)findViewById(R.id.tv1);

        counter=0;

        for (int i=0;i<3;i++)
        {
            for (int j=0;j<3;j++)
            {
                c[i][j]=2;
            }
        }

        result.setOnClickListener(new View.OnClickListener() {  //to view results in ALERT BOX
            @Override
            public void onClick(View v) {

                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                b.setTitle(op1);
                b.setMessage(op);
                b.setCancelable(false);
                b.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog ob = b.create();
        ob.show();
            }
        });

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {  // GOTO MAIN MENU.....
                bool=false;
                counter=0;
               /*Intent info = new Intent(MainActivity.this,HomePage.class);
                startActivity(info);*/
               finish();
            }
        });


        b[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bool == false) {
                    b[0][0].setBackgroundResource(R.drawable.x1x);
                    bool = true;
                    counter+=1;
                    b[0][0].setEnabled(false);
                    c[0][0] = 1;

                }
                else {
                    b[0][0].setBackgroundResource(R.drawable.wodoo);
                    bool = false;
                    counter+=1;
                    b[0][0].setEnabled(false);
                    c[0][0] = 0;

                }

                if((c[0][0]==1 &&c[0][1]==1 && c[0][2]==1)|| (c[1][0]==1 &&c[1][1]==1 && c[1][2]==1)|| (c[2][0]==1 &&c[2][1]==1 && c[2][2]==1)|| (c[0][0]==1 &&c[1][0]==1 && c[2][0]==1)|| (c[0][1]==1 &&c[1][1]==1 && c[2][1]==1)|| (c[0][2]==1 &&c[1][2]==1 && c[2][2]==1)|| (c[0][2]==1 &&c[1][1]==1 && c[2][0]==1)|| (c[0][0]==1 &&c[1][1]==1 && c[2][2]==1))
                {
                    buttonEnabled();
                    alertForX();
                }

              else  if((c[0][0]==0 &&c[0][1]==0 && c[0][2]==0)|| (c[1][0]==0 &&c[1][1]==0 && c[1][2]==0)|| (c[2][0]==0 &&c[2][1]==0 && c[2][2]==0)|| (c[0][0]==0 &&c[1][0]==0 && c[2][0]==0)|| (c[0][1]==0 &&c[1][1]==0 && c[2][1]==0)|| (c[0][2]==0 &&c[1][2]==0 && c[2][2]==0)|| (c[0][2]==0 &&c[1][1]==0 && c[2][0]==0)|| (c[0][0]==0 &&c[1][1]==0 && c[2][2]==0))
                {
                    buttonEnabled();
                    alertForO();
                }
              else  if (counter==9)
                {

                    alertForDraw();
                }
            }


        });

        b[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bool==false)
                {
                    b[0][1].setBackgroundResource(R.drawable.x1x);
                    bool=true;
                    b[0][1].setEnabled(false);
                    c[0][1]=1;
                    counter+=1;

                }
                else{

                    b[0][1].setBackgroundResource(R.drawable.wodoo);
                    bool=false;
                    b[0][1].setEnabled(false);
                    c[0][1]=0;
                    counter+=1;

                }
                if((c[0][0]==1 &&c[0][1]==1 && c[0][2]==1)|| (c[1][0]==1 && c[1][1]==1 && c[1][2]==1)|| (c[2][0]==1 && c[2][1]==1 && c[2][2]==1)|| (c[0][0]==1 &&c[1][0]==1 && c[2][0]==1)|| (c[0][1]==1 &&c[1][1]==1 && c[2][1]==1)|| (c[0][2]==1 &&c[1][2]==1 && c[2][2]==1)|| (c[0][2]==1 &&c[1][1]==1 && c[2][0]==1)|| (c[0][0]==1 &&c[1][1]==1 && c[2][2]==1))
                {
                    buttonEnabled();
                   alertForX();
                }

               else if((c[0][0]==0 &&c[0][1]==0 && c[0][2]==0)|| (c[1][0]==0 &&c[1][1]==0 && c[1][2]==0)|| (c[2][0]==0 &&c[2][1]==0 && c[2][2]==0)|| (c[0][0]==0 &&c[1][0]==0 && c[2][0]==0)|| (c[0][1]==0 &&c[1][1]==0 && c[2][1]==0)|| (c[0][2]==0 &&c[1][2]==0 && c[2][2]==0)|| (c[0][2]==0 &&c[1][1]==0 && c[2][0]==0)|| (c[0][0]==0 &&c[1][1]==0 && c[2][2]==0))
                {
                    buttonEnabled();
                  alertForO();
                }
              else  if (counter==9)
                {
                    alertForDraw();
                }
                }

        });

        b[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bool==false)
                {
                    b[0][2].setBackgroundResource(R.drawable.x1x);
                    bool=true;
                    b[0][2].setEnabled(false);
                    c[0][2]=1;
                    counter+=1;

                }
                else{
                    b[0][2].setBackgroundResource(R.drawable.wodoo);
                    bool=false;
                    b[0][2].setEnabled(false);
                    c[0][2]=0;
                    counter+=1;

                }
                if((c[0][0]==1 &&c[0][1]==1 && c[0][2]==1)|| (c[1][0]==1 &&c[1][1]==1 && c[1][2]==1)|| (c[2][0]==1 &&c[2][1]==1 && c[2][2]==1)|| (c[0][0]==1 &&c[1][0]==1 && c[2][0]==1)|| (c[0][1]==1 &&c[1][1]==1 && c[2][1]==1)|| (c[0][2]==1 &&c[1][2]==1 && c[2][2]==1)|| (c[0][2]==1 &&c[1][1]==1 && c[2][0]==1)|| (c[0][0]==1 &&c[1][1]==1 && c[2][2]==1))
                {
                    buttonEnabled();
                  alertForX();
                }
               else if((c[0][0]==0 &&c[0][1]==0 && c[0][2]==0)|| (c[1][0]==0 &&c[1][1]==0 && c[1][2]==0)|| (c[2][0]==0 &&c[2][1]==0 && c[2][2]==0)|| (c[0][0]==0 &&c[1][0]==0 && c[2][0]==0)|| (c[0][1]==0 &&c[1][1]==0 && c[2][1]==0)|| (c[0][2]==0 &&c[1][2]==0 && c[2][2]==0)|| (c[0][2]==0 &&c[1][1]==0 && c[2][0]==0)|| (c[0][0]==0 &&c[1][1]==0 && c[2][2]==0))
                {
                    buttonEnabled();
                  alertForO();
                }
              else  if (counter==9)
                {
                    alertForDraw();
                }
                }

        });

        b[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
            if (bool == false) {
                b[1][0].setBackgroundResource(R.drawable.x1x);
                bool = true;
                b[1][0].setEnabled(false);
                c[1][0] = 1;
                counter+= 1;
            }
            else {
                b[1][0].setBackgroundResource(R.drawable.wodoo);
                bool = false;
                b[1][0].setEnabled(false);
                c[1][0] = 0;
                counter+= 1;
            }

            if ((c[0][0] == 1 && c[0][1] == 1 && c[0][2] == 1) || (c[1][0] == 1 && c[1][1] == 1 && c[1][2] == 1) || (c[2][0] == 1 && c[2][1] == 1 && c[2][2] == 1) || (c[0][0] == 1 && c[1][0] == 1 && c[2][0] == 1) || (c[0][1] == 1 && c[1][1] == 1 && c[2][1] == 1) || (c[0][2] == 1 && c[1][2] == 1 && c[2][2] == 1) || (c[0][2] == 1 && c[1][1] == 1 && c[2][0] == 1) || (c[0][0] == 1 && c[1][1] == 1 && c[2][2] == 1))
            {
                buttonEnabled();
               alertForX();
            }

              else  if((c[0][0]==0 &&c[0][1]==0 && c[0][2]==0)|| (c[1][0]==0 &&c[1][1]==0 && c[1][2]==0)|| (c[2][0]==0 &&c[2][1]==0 && c[2][2]==0)|| (c[0][0]==0 &&c[1][0]==0 && c[2][0]==0)|| (c[0][1]==0 &&c[1][1]==0 && c[2][1]==0)|| (c[0][2]==0 &&c[1][2]==0 && c[2][2]==0)|| (c[0][2]==0 &&c[1][1]==0 && c[2][0]==0)|| (c[0][0]==0 &&c[1][1]==0 && c[2][2]==0))
            {
                buttonEnabled();
              alertForO();
            }
          else  if (counter == 9) {
                alertForDraw();
            }
            }
        });

        b[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bool==false)
                {
                    b[1][1].setBackgroundResource(R.drawable.x1x);

                    bool=true;
                    b[1][1].setEnabled(false);
                    c[1][1]=1;
                    counter+=1;
                }
                else{
                    b[1][1].setBackgroundResource(R.drawable.wodoo);
                    bool=false;
                    b[1][1].setEnabled(false);
                    c[1][1]=0;
                    counter+=1;
                }

                if((c[0][0]==1 &&c[0][1]==1 && c[0][2]==1)|| (c[1][0]==1 &&c[1][1]==1 && c[1][2]==1)|| (c[2][0]==1 &&c[2][1]==1 && c[2][2]==1)|| (c[0][0]==1 &&c[1][0]==1 && c[2][0]==1)|| (c[0][1]==1 &&c[1][1]==1 && c[2][1]==1)|| (c[0][2]==1 &&c[1][2]==1 && c[2][2]==1)|| (c[0][2]==1 &&c[1][1]==1 && c[2][0]==1)|| (c[0][0]==1 &&c[1][1]==1 && c[2][2]==1))
                {
                    buttonEnabled();
                  alertForX();
                }
               else if((c[0][0]==0 &&c[0][1]==0 && c[0][2]==0)|| (c[1][0]==0 &&c[1][1]==0 && c[1][2]==0)|| (c[2][0]==0 &&c[2][1]==0 && c[2][2]==0)|| (c[0][0]==0 &&c[1][0]==0 && c[2][0]==0)|| (c[0][1]==0 &&c[1][1]==0 && c[2][1]==0)|| (c[0][2]==0 &&c[1][2]==0 && c[2][2]==0)|| (c[0][2]==0 &&c[1][1]==0 && c[2][0]==0)|| (c[0][0]==0 &&c[1][1]==0 && c[2][2]==0))
                {
                    buttonEnabled();
                 alertForO();
                }
              else  if (counter==9)
                {
                    alertForDraw();
                }
                }

        });

        b[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bool==false)
                {
                    b[1][2].setBackgroundResource(R.drawable.x1x);
                    bool=true;
                    b[1][2].setEnabled(false);
                    c[1][2]=1;
                    counter+=1;
                }
                else{
                    b[1][2].setBackgroundResource(R.drawable.wodoo);
                    bool=false;
                    b[1][2].setEnabled(false);
                    c[1][2]=0;
                    counter+=1;
                }
                if((c[0][0]==1 &&c[0][1]==1 && c[0][2]==1)|| (c[1][0]==1 &&c[1][1]==1 && c[1][2]==1)|| (c[2][0]==1 &&c[2][1]==1 && c[2][2]==1)|| (c[0][0]==1 &&c[1][0]==1 && c[2][0]==1)|| (c[0][1]==1 &&c[1][1]==1 && c[2][1]==1)|| (c[0][2]==1 &&c[1][2]==1 && c[2][2]==1)|| (c[0][2]==1 &&c[1][1]==1 && c[2][0]==1)|| (c[0][0]==1 &&c[1][1]==1 && c[2][2]==1))
                {
                    buttonEnabled();
                  alertForX();
                }
              else  if((c[0][0]==0 &&c[0][1]==0 && c[0][2]==0)|| (c[1][0]==0 &&c[1][1]==0 && c[1][2]==0)|| (c[2][0]==0 &&c[2][1]==0 && c[2][2]==0)|| (c[0][0]==0 &&c[1][0]==0 && c[2][0]==0)|| (c[0][1]==0 &&c[1][1]==0 && c[2][1]==0)|| (c[0][2]==0 &&c[1][2]==0 && c[2][2]==0)|| (c[0][2]==0 &&c[1][1]==0 && c[2][0]==0)|| (c[0][0]==0 &&c[1][1]==0 && c[2][2]==0))
                {
                    buttonEnabled();
                  alertForO();
                }
              else  if (counter==9)
                {
                    alertForDraw();
                }
                }
       //     }
        });

        b[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bool==false) {
                    b[2][0].setBackgroundResource(R.drawable.x1x);
                    bool = true;
                    b[2][0].setEnabled(false);
                    c[2][0] = 1;
                    counter+=1;
                }
                else
                {
                    b[2][0].setBackgroundResource(R.drawable.wodoo);
                    bool=false;
                    b[2][0].setEnabled(false);
                    c[2][0]=0;
                    counter+=1;
                }
                if((c[0][0]==1 &&c[0][1]==1 && c[0][2]==1)|| (c[1][0]==1 &&c[1][1]==1 && c[1][2]==1)|| (c[2][0]==1 &&c[2][1]==1 && c[2][2]==1)|| (c[0][0]==1 &&c[1][0]==1 && c[2][0]==1)|| (c[0][1]==1 &&c[1][1]==1 && c[2][1]==1)|| (c[0][2]==1 &&c[1][2]==1 && c[2][2]==1)|| (c[0][2]==1 &&c[1][1]==1 && c[2][0]==1)|| (c[0][0]==1 &&c[1][1]==1 && c[2][2]==1))
                {
                    buttonEnabled();
                   alertForX();
                }
                else if((c[0][0]==0 &&c[0][1]==0 && c[0][2]==0)|| (c[1][0]==0 &&c[1][1]==0 && c[1][2]==0)|| (c[2][0]==0 &&c[2][1]==0 && c[2][2]==0)|| (c[0][0]==0 &&c[1][0]==0 && c[2][0]==0)|| (c[0][1]==0 &&c[1][1]==0 && c[2][1]==0)|| (c[0][2]==0 &&c[1][2]==0 && c[2][2]==0)|| (c[0][2]==0 &&c[1][1]==0 && c[2][0]==0)|| (c[0][0]==0 &&c[1][1]==0 && c[2][2]==0))
                {
                    buttonEnabled();
                alertForO();
                }
               else if (counter==9)
                {
                    alertForDraw();
                }
                }
         //   }
        });

        b[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bool==false)
                {
                    b[2][1].setBackgroundResource(R.drawable.x1x);
                    bool=true;
                    b[2][1].setEnabled(false);
                    c[2][1]=1;
                    counter+=1;
                }
                else{
                    b[2][1].setBackgroundResource(R.drawable.wodoo);
                    bool=false;
                    b[2][1].setEnabled(false);
                    c[2][1]=0;
                    counter+=1;
                }
                if((c[0][0]==1 &&c[0][1]==1 && c[0][2]==1)|| (c[1][0]==1 &&c[1][1]==1 && c[1][2]==1)|| (c[2][0]==1 &&c[2][1]==1 && c[2][2]==1)|| (c[0][0]==1 &&c[1][0]==1 && c[2][0]==1)|| (c[0][1]==1 &&c[1][1]==1 && c[2][1]==1)|| (c[0][2]==1 &&c[1][2]==1 && c[2][2]==1)|| (c[0][2]==1 &&c[1][1]==1 && c[2][0]==1)|| (c[0][0]==1 &&c[1][1]==1 && c[2][2]==1))
                {
                    buttonEnabled();
                  alertForX();
                }
              else  if((c[0][0]==0 &&c[0][1]==0 && c[0][2]==0)|| (c[1][0]==0 &&c[1][1]==0 && c[1][2]==0)|| (c[2][0]==0 &&c[2][1]==0 && c[2][2]==0)|| (c[0][0]==0 &&c[1][0]==0 && c[2][0]==0)|| (c[0][1]==0 &&c[1][1]==0 && c[2][1]==0)|| (c[0][2]==0 &&c[1][2]==0 && c[2][2]==0)|| (c[0][2]==0 &&c[1][1]==0 && c[2][0]==0)|| (c[0][0]==0 &&c[1][1]==0 && c[2][2]==0))
                {
                    buttonEnabled();
                  alertForO();
                }
              else  if (counter==9)
                {
                    alertForDraw();
                }
                }
      //      }
        });

        b[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bool==false)
                {
                    b[2][2].setBackgroundResource(R.drawable.x1x);
                    bool=true;
                    b[2][2].setEnabled(false);
                    c[2][2]=1;
                    counter+=1;

                }
                else{
                    b[2][2].setBackgroundResource(R.drawable.wodoo);
                    bool=false;
                    b[2][2].setEnabled(false);
                    c[2][2]=0;
                    counter+=1;
                }
                if((c[0][0]==1 &&c[0][1]==1 && c[0][2]==1)|| (c[1][0]==1 &&c[1][1]==1 && c[1][2]==1)|| (c[2][0]==1 &&c[2][1]==1 && c[2][2]==1)|| (c[0][0]==1 &&c[1][0]==1 && c[2][0]==1)|| (c[0][1]==1 &&c[1][1]==1 && c[2][1]==1)|| (c[0][2]==1 &&c[1][2]==1 && c[2][2]==1)|| (c[0][2]==1 &&c[1][1]==1 && c[2][0]==1)|| (c[0][0]==1 &&c[1][1]==1 && c[2][2]==1))
                {
                    buttonEnabled();
                  alertForX();
                }
              else  if((c[0][0]==0 &&c[0][1]==0 && c[0][2]==0)|| (c[1][0]==0 &&c[1][1]==0 && c[1][2]==0)|| (c[2][0]==0 &&c[2][1]==0 && c[2][2]==0)|| (c[0][0]==0 &&c[1][0]==0 && c[2][0]==0)|| (c[0][1]==0 &&c[1][1]==0 && c[2][1]==0)|| (c[0][2]==0 &&c[1][2]==0 && c[2][2]==0)|| (c[0][2]==0 &&c[1][1]==0 && c[2][0]==0)|| (c[0][0]==0 &&c[1][1]==0 && c[2][2]==0))
                {
                    buttonEnabled();
                  alertForO();
                }
               else if (counter==9)
                {
                    alertForDraw();
                }
                }
           // }
        });

    }

    @Override
    protected void onDestroy() {
        bool=false;
        counter=0;
        super.onDestroy();
    }
}