package com.example.kkk;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TextView time;
    private Button start;
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time = findViewById(R.id.time);
        start = findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(timer!=null){
                    timer.cancel();
                }

                start.setText("старт");
                start.setBackgroundColor(Color.parseColor("#D5462D"));
//                вместо 60000 своё время
                timer = new CountDownTimer(60000, 1000) {
                    @Override
                    public void onTick(long l) {
                        NumberFormat f = new DecimalFormat("00");
                        long sec = l/1000;
                        long min = sec/60;
//                        sec-=min*60;
                        sec = sec % 60;
                        String time1 = f.format(min) + ":" + f.format(sec);
                        time.setText(time1);
                    }

                    @Override
                    public void onFinish() {
                        time.setText("00:00");
                        start.setText("старт");
                        start.setBackgroundColor(Color.parseColor("#1483DC"));

                    }
                };
                timer.start();
            }
        });
    }
}