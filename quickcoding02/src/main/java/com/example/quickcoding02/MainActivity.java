package com.example.quickcoding02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int targetNum = 0 ;

    BinarySearch Bs = new BinarySearch() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void onClick(View V) {

        EditText editText = (EditText) findViewById(R.id.editText) ;

        TextView textNum = (TextView) findViewById(R.id.TextNum) ;

        switch (V.getId()) {
            case R.id.BtnSend :
                targetNum = Integer.parseInt(editText.getText().toString()) ;
                break ;

            case R.id.BtnBig :
                if (targetNum > Bs.getMid()) {
                    Bs.getResult(targetNum);
                }

                textNum.setText("Your Number Is " + Bs.getMid() + " ?");
                break ;
            case R.id.BtnSmall :
                if (targetNum < Bs.getMid()) {
                    Bs.getResult(targetNum);
                }

                textNum.setText("Your Number Is " + Bs.getMid() + " ?");
                break ;
            case R.id.BtnBingo :
                if (targetNum == Bs.getMid()) {
                    Toast.makeText(this, "BINGO!!!", Toast.LENGTH_LONG).show() ;
                }
                else {
                    Toast.makeText(this, "NOT BINGO!!!", Toast.LENGTH_LONG).show() ;
                }
        }
    }
}
