package com.example.quickcoding05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> arrayString=new ArrayList<String>();
    ArrayList<Integer> arrayInteger=new ArrayList<Integer>();
    EditText edit;
    Button send;
    Button result;
    TextView number,string;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number=(TextView)findViewById(R.id.number);
        string=(TextView)findViewById(R.id.string);

        edit=(EditText)findViewById(R.id.input);

        send=(Button)findViewById(R.id.send);
        result=(Button)findViewById(R.id.result);

        send.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if(isIntegerTrue(edit.getText().toString()))
                {
                    arrayInteger.add(Integer.parseInt(edit.getText().toString()));
                }
                else
                {
                    arrayString.add(edit.getText().toString());
                }
                edit.setText("");
            }
        });

        result.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                number.setText(arrayInteger.toString()+" ");
                string.setText(arrayString.toString()+" ");
            }
        });
    }

    public boolean isIntegerTrue(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e)
        {
            return false;
        }
    }



}
