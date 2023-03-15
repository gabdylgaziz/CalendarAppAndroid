package com.calendar.mycalendarapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CalendarView calendarView;
    TextView myDate;
    Button btn_saved;
    Button btn_diff;
    String s = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.calendar);
        myDate = findViewById(R.id.my_date);
        btn_saved = findViewById(R.id.btn_saved);
        btn_diff = findViewById(R.id.btn_diff);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                //Выбранный день
                String a = "", b = "";
                if(i1 + 1 < 10){
                    a = "0" + (i1 + 1);
                }else{
                    a = "" + (i1 + 1);
                }
                if(i2 < 10){
                    b = "0" + (i2);
                }else{
                    b = "" + (i2);
                }
                s = i + "-" + a + "-" + b;
                //Toast.makeText(MainActivity.this, "Год : "+i+"\n"+"Месяц : "+i1+"\n"+"День : "+i2, Toast.LENGTH_LONG).show();
                System.out.println(s);
            }
        });

        btn_saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NotesActivity.class);
                startActivity(intent);
            }
        });

        btn_diff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DateDiff.class);
                intent.putExtra("data", s);
                startActivity(intent);
            }
        });
    }
}