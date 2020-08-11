package com.example.vanshul.btrainer;

import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> answers=new ArrayList<Integer>();
    int ca=-1;
    TextView t,tv3;
    int answerCount=0;
    int ttlquestions=0;
    public void tim(){
        new CountDownTimer(31000,1000){
            @Override
            public void onTick(long l){
                TextView tv1=findViewById(R.id.tv1);
                tv1.setText(String.valueOf(l/1000)+"s");

            }
            @Override
            public void onFinish(){
                Button b1=findViewById(R.id.button1);
                Button b2=findViewById(R.id.button2);
                Button b3=findViewById(R.id.button3);
                Button b4=findViewById(R.id.button4);
                b1.setEnabled(false);
                b2.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(false);
                Button b=findViewById(R.id.button6);
                b.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(), "you scored : " + Integer.toString(answerCount) + " out of " + Integer.toString(ttlquestions) + " in 30 seconds" , Toast.LENGTH_LONG).show();

            }

        }.start();
    }
    public void strt(View view){
        TextView hi1=findViewById(R.id.hi1);
        TextView hi2=findViewById(R.id.hi2);
        hi1.setVisibility(View.INVISIBLE);
        hi2.setVisibility(View.INVISIBLE);
        Button bb=findViewById(R.id.button12);
        bb.setVisibility(View.INVISIBLE);
        ConstraintLayout g=findViewById(R.id.constraintLayout);
        g.setVisibility(View.VISIBLE);
        reset(view);
    }
    public void disp(){
        answers.clear();
        Random rand=new Random();
        t=(TextView)(findViewById(R.id.tv2));
        int a=rand.nextInt(21);
        int b=rand.nextInt(21);
        int r=rand.nextInt(4);
        ca=r;
        for(int i=0;i<4;i++){
            if(i==r){
                answers.add(a+b);
            }
            else{
                int nn=rand.nextInt(41);
                while(nn==a+b){
                    nn=rand.nextInt(41);
                }
                answers.add(nn);
            }
        }
        t.setText(Integer.toString(a) + " + " + Integer.toString(b));
        Button b1=findViewById(R.id.button1);
        Button b2=findViewById(R.id.button2);
        Button b3=findViewById(R.id.button3);
        Button b4=findViewById(R.id.button4);
        b1.setText(Integer.toString(answers.get(0)));
        b2.setText(Integer.toString(answers.get(1)));
        b3.setText(Integer.toString(answers.get(2)));
        b4.setText(Integer.toString(answers.get(3)));

    }
    public void reset(View view){
        Button b=findViewById(R.id.button6);
        b.setVisibility(View.INVISIBLE);
        Button b1=findViewById(R.id.button1);
        Button b2=findViewById(R.id.button2);
        Button b3=findViewById(R.id.button3);
        Button b4=findViewById(R.id.button4);
        answers.clear();
        answerCount=0;
        ttlquestions=0;
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        tv3=findViewById(R.id.tv3);
        tv3.setText("SCORE: 0");
        disp();
        tim();
    }
    public void clk(View view){
        int clkd=(Integer.parseInt(view.getTag().toString()));
        if(clkd==ca ){
            answerCount++;
        }
        ttlquestions++;
        tv3=findViewById(R.id.tv3);
        tv3.setText("SCORE: " + Integer.toString(answerCount));
        disp();
        Button b=findViewById(R.id.button6);
        b.setVisibility(View.INVISIBLE);
        answers.clear();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //disp();
        Button b=findViewById(R.id.button6);
        b.setVisibility(View.INVISIBLE);

    }
}
