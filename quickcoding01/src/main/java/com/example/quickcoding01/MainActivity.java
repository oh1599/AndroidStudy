package com.example.quickcoding01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

    MyMinimum MyMin = new MyMinimum() ;
    MyAverage MyAvg = new MyAverage() ;

    Button min,avg;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text=(TextView)findViewById(R.id.result);
        min= (Button) findViewById(R.id.minimum);
        avg= (Button) findViewById(R.id.average);

        min.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                text.setText("최소값은 "+MyMin.getResult()+"입니다.");
            }
        });

        avg.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                text.setText("평균값은 "+MyAvg.getResult()+"입니다.");
            }
        });
    }


}
