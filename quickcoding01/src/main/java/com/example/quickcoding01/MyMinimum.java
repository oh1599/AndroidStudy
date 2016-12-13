package com.example.quickcoding01;

public class MyMinimum  extends MyValues{
    int getResult()
    {
        result=value[0];
        for(int i=0;i<value.length;i++)
        {

            if(result>value[i])
            {
                result=value[i];
            }
        }
        return result;
    }
}