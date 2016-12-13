package com.example.quickcoding02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    BinarySearch bs = new BinarySearch();
    int targetNum = 0 ;

    EditText edit;
    TextView text,result;
    Button send,bigger,smaller,bingo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit=(EditText)findViewById(R.id.editText);
        text=(TextView)findViewById(R.id.TextNum);
        result=(TextView)findViewById(R.id.result);

        send=(Button)findViewById(R.id.BtnSend);
        bigger=(Button)findViewById(R.id.BtnBig);
        smaller=(Button)findViewById(R.id.BtnSmall);
        bingo=(Button)findViewById(R.id.BtnBingo);

        send.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                 targetNum= Integer.parseInt(edit.getText().toString());
            }
        });

        smaller.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(targetNum<bs.getMid())
                {
                    bs.getResult(targetNum);
                }
                text.setText("당신의 숫자는 "+bs.getMid()+"입니까?");
            }
        });

        bigger.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(targetNum>bs.getMid())
                {
                    bs.getResult(targetNum);
                }
                text.setText("당신의 숫자는 "+bs.getMid()+"입니까?");
            }

        });


        bingo.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if(targetNum==bs.getMid())
                {
                    result.setText("정답!!");
                }
                else
                {
                    result.setText("정답이 아닙니다.");
                }
            }
        });
    }


}
