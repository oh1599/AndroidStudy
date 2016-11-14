package com.example.quickcoding01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyMinimum MyMin = new MyMinimum() ;
    MyAverage MyAvg = new MyAverage() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void onClick(View V) {

        switch(V.getId()) {
            case R.id.BtnMin :
                Toast.makeText(this, "MyMinimum = " + MyMin.getResult(), Toast.LENGTH_LONG).show() ;
                break ;

            case R.id.BtnAvg :
                Toast.makeText(this, "MyAverage = " + MyAvg.getResult(), Toast.LENGTH_LONG).show(); ;
                break ;
        }
    }
}
