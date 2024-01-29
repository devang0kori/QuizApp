package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<ModelClass> listofQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listofQ = new ArrayList<>();

        listofQ.add(new ModelClass("which of the biggest continent in the world?","north America","Asia","Africa","Australia","Asia"));
        listofQ.add(new ModelClass("which is India's first super computer?","Param8000","Param80000","Param800","Param8","Param8000"));
        listofQ.add(new ModelClass("which bank is called bankers Bank of India?","Reserve Bank of India","Panjab National Bank","State Bank of India","ICICI Bank","Reserve Bank of India"));
        listofQ.add(new ModelClass("Which planet is known as the Red Planet","Venus","Mars","Jupiter","Saturn","Mars"));
        listofQ.add(new ModelClass("Who wrote the play Romeo and Juliet","Charles Dickens","William Shakespeare","Jane Austen","Mark Twain","William Shakespeare"));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,Dashboard.class);
                startActivity(intent);
            }
        },1500);
    }
}