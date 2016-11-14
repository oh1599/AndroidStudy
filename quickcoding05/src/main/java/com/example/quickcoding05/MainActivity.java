package com.example.quickcoding05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static List<Integer> arrayInt = new ArrayList<Integer>();
    static List<String> arrayStr = new ArrayList<String>();

    static EditText get ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick01(View view) {
        get = (EditText) findViewById(R.id.get) ;

        if (isStringInteger(get.getText().toString())) {
            arrayInt.add(Integer.parseInt(get.getText().toString()));
        } else {
            arrayStr.add(get.getText().toString()) ;
        }

        get.setText("");
    }

    public void onClick02(View view) {
        TextView showInteger = (TextView) findViewById(R.id.showInteger) ;
        TextView showStrings = (TextView) findViewById(R.id.showStrings) ;

        showInteger.setText(arrayInt.toString() + " ");

        showStrings.setText(arrayStr.toString() + " ");
    }
    public  boolean isStringInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
