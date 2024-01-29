package com.example.quizapp;

import static com.example.quizapp.MainActivity.listofQ;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Dashboard extends AppCompatActivity {

    CountDownTimer countDownTimer;
    int timerValue=30;
    ProgressBar progressBar;

    List<ModelClass> allQuestionlist;
    ModelClass modelClass;
    int index=0;
    TextView card_question,card_option1,card_option2,card_option3,card_option4;
    CardView cardView1,cardView2,cardView3,cardView4;
    int correctCount=0;
    int wrongCount=0;
    LinearLayout nextbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        hooks();

        allQuestionlist = listofQ;
        Collections.shuffle(allQuestionlist);
        modelClass=listofQ.get(index);

        cardView1.setBackgroundColor(getResources().getColor(R.color.white));
        cardView2.setBackgroundColor(getResources().getColor(R.color.white));
        cardView3.setBackgroundColor(getResources().getColor(R.color.white));
        cardView4.setBackgroundColor(getResources().getColor(R.color.white));

        nextbutton.setClickable(false);

        setAlldata();

        countDownTimer=new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerValue=timerValue-1;
                progressBar.setProgress(timerValue);

            }

            @Override
            public void onFinish() {
                Dialog dialog=new Dialog(Dashboard.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.timeout);


                dialog.findViewById(R.id.tryagain_button).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Dashboard.this,MainActivity.class);
                        startActivity(intent);
                    }
                });
                dialog.show();
            }
        }.start();
    }

    private void setAlldata() {

        card_question.setText(modelClass.getQuestion());
        card_option1.setText(modelClass.getOptiA());
        card_option2.setText(modelClass.getOptiB());
        card_option3.setText(modelClass.getOptiC());
        card_option4.setText(modelClass.getOptiD());
    }

    private void hooks() {

        progressBar=findViewById(R.id.quiz_timer);
        card_question=findViewById(R.id.card_question);
        card_option1=findViewById(R.id.card_option1);
        card_option2=findViewById(R.id.card_option2);
        card_option3=findViewById(R.id.card_option3);
        card_option4=findViewById(R.id.card_option4);

        cardView1=findViewById(R.id.cardview1);
        cardView2=findViewById(R.id.cardview2);
        cardView3=findViewById(R.id.cardview3);
        cardView4=findViewById(R.id.cardview4);

        nextbutton=findViewById(R.id.nextbutton);
    }

    public void correct(CardView cardView) {
        cardView.setBackgroundColor(getResources().getColor(R.color.green));

        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctCount++;
                index++;
                if (index < listofQ.size()) {
                    modelClass = listofQ.get(index);
                    setAlldata();
                    resetColor();
                    enableButton();  // Ensure buttons are enabled for the next question
                } else {
                    GameWon();
                }
            }
        });
    }


    public void wrong(CardView cardView) {
        cardView.setBackgroundColor(getResources().getColor(R.color.red));

        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrongCount++;
                if (index < listofQ.size() - 1) {
                    index++;
                    modelClass = listofQ.get(index);
                    setAlldata();
                    resetColor();
                    enableButton();  // Ensure buttons are enabled for the next question
                } else {
                    GameWon();
                }
            }
        });
    }


    private void GameWon() {
        Intent intent=new Intent(Dashboard.this,WonActivity.class);
        intent.putExtra("correct",correctCount);
        intent.putExtra("wrong",wrongCount);
        startActivity(intent);

    }

    public void enableButton(){
        cardView1.setClickable(true);
        cardView2.setClickable(true);
        cardView3.setClickable(true);
        cardView4.setClickable(true);
    }

    public void disableButton(){
        cardView1.setClickable(false);
        cardView2.setClickable(false);
        cardView3.setClickable(false);
        cardView4.setClickable(false);
    }

    public void resetColor(){
        cardView1.setBackgroundColor(getResources().getColor(R.color.white));
        cardView2.setBackgroundColor(getResources().getColor(R.color.white));
        cardView3.setBackgroundColor(getResources().getColor(R.color.white));
        cardView4.setBackgroundColor(getResources().getColor(R.color.white));


    }

    public void optiAClick(View view) {
        disableButton();
        nextbutton.setClickable(true);
        if(modelClass.getOptiA().equals(modelClass.getAnswer())){
            cardView1.setBackgroundColor(getResources().getColor(R.color.green));

            if(index<listofQ.size() - 1 ){
                correct(cardView1);
            }else{
                GameWon();
            }
        } else {
            wrong(cardView1);
        }
    }

    public void optiBClick(View view) {
        disableButton();
        nextbutton.setClickable(true);
        if(modelClass.getOptiB().equals(modelClass.getAnswer())){
            cardView2.setBackgroundColor(getResources().getColor(R.color.green));

            if(index<listofQ.size() - 1 ){
                correct(cardView2);
            }else{
                GameWon();
            }
        } else {
            wrong(cardView2);
        }
    }

    public void optiCClick(View view) {
        disableButton();
        nextbutton.setClickable(true);
        if(modelClass.getOptiC().equals(modelClass.getAnswer())){
            cardView3.setBackgroundColor(getResources().getColor(R.color.green));

            if(index<listofQ.size() - 1 ){
                correct(cardView3);
            }else{
                GameWon();
            }
        } else {
            wrong(cardView3);
        }
    }

    public void optiDClick(View view)   {
        disableButton();
        nextbutton.setClickable(true);
        if(modelClass.getOptiD().equals(modelClass.getAnswer())){
            cardView4.setBackgroundColor(getResources().getColor(R.color.green));

            if(index<listofQ.size() - 1 ){
                correct(cardView4);
            }else{
                GameWon();
            }
        } else {
            wrong(cardView4);
        }
    }


}