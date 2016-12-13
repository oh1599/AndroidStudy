package com.example.quickcoding02;

/**
 * Created by Oh on 2016-11-14.
 */

public class BinarySearch
{
    int low = 0;
    int high = 1000 ;
    int mid = 500 ;

    int getMid ()
    {
        return mid ;
    }

    void setMid ()
    {
        mid = (low + high) / 2;
    }

    void getResult (int target)
    {
        if (target > mid)
        {
            low = mid ;
            setMid() ;
        }
        else if (target < mid)
        {
            high = mid ;
            setMid() ;
        }
    }

}
