package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.BuildConfig;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class WonActivity extends AppCompatActivity {

    CircularProgressBar circularProgressBar;
    TextView resulttext;
    int correct, wrong;
    LinearLayout buttonshare;
    ImageView back;
    TextView exit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);

        correct = getIntent().getIntExtra("correct", 0);
        wrong = getIntent().getIntExtra("wrong", 0);

        circularProgressBar = findViewById(R.id.circular_progressbar);
        resulttext = findViewById(R.id.result_text);
        buttonshare = findViewById(R.id.buttonshare);
         exit= findViewById(R.id.exit);
         back= findViewById(R.id.back);

        circularProgressBar.setProgress(correct);
        resulttext.setText(correct + "/5");

        buttonshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareResults();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitApp();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectToSplashScreen();
            }
        });
    }

    private void shareResults() {
        try {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My Application Name");
            String shareMessage = "\n I got " + correct + " out of 5 You Can Also Try";
            shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.BUILD_TYPE + "\n\n";
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            startActivity(Intent.createChooser(shareIntent, "choose one"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void exitApp() {
        // Close the app
        finishAffinity();
    }

    private void redirectToSplashScreen() {
        // Redirect to the splash screen (or any other desired screen)
        Intent intent = new Intent(WonActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
