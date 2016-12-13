package com.example.quickcoding01;



public class MyAverage extends MyValues {
    int getResult()
    {
        for(int i=0;i<value.length;i++)
        {
            result+=value[i];
        }

        result/=value.length;
        return result;
    }
}
