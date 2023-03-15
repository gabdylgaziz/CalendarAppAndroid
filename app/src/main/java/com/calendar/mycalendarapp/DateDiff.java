package com.calendar.mycalendarapp;

import static java.lang.Math.abs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

public class DateDiff extends AppCompatActivity {
    CalendarView calendar_diff;
    TextView res_txt;
    String s = "", t = "";
    //String txtName = getIntent().getStringExtra("data")
    long res = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datediff);
        s = getIntent().getExtras().getString("data");
        calendar_diff = findViewById(R.id.calendar_diff);
        res_txt = findViewById(R.id.result_date);
        calendar_diff.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendar_diff, int i, int i1, int i2) {
                //Toast.makeText(DateDiff.this, "Год : "+i+"\n"+"Месяц : "+i1+"\n"+"День : "+i2, Toast.LENGTH_LONG).show();
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
                t = i + "-" + a + "-" + b;
                res = getDifference();
                res_txt.setText("Расстояние: " + res + " дней");
            }
        });


    }
    public long getDifference() {
        int y1 = (s.charAt(0) - '0') * 1000 + (s.charAt(1) - '0') * 100 + (s.charAt(2) - '0') * 10 + (s.charAt(3) - '0');
        int m1 = (s.charAt(5) - '0') * 10 + (s.charAt(6) - '0');
        int d1 = (s.charAt(8) - '0') * 10 + (s.charAt(9) - '0');
        int y2 = (t.charAt(0) - '0') * 1000 + (t.charAt(1) - '0') * 100 + (t.charAt(2) - '0') * 10 + (t.charAt(3) - '0');
        int m2 = (t.charAt(5) - '0') * 10 + (t.charAt(6) - '0');
        int d2 = (t.charAt(8) - '0') * 10 + (t.charAt(9) - '0');
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int a = 0, b = 0;
        for(int i = 0; i < m1 - 1; i++){
            a+=months[i];
        }
        for(int i = 0; i < m2 - 1; i++){
            b+=months[i];
        }
        return (abs((d1 + a) - (d2 + b)) + 365 * abs((y1 - y2)));
    }
}