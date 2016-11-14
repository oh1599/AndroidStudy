package com.example.quickcoding02;

/**
 * Created by Oh on 2016-11-14.
 */

public class BinarySearch {

    int low = 0, high = 500 ;
    int mid = 500 ;

    void getResult (int target) {

        if (target > mid) {
            low = mid ;
            setMid() ;
        }
        else if (target < mid) {
            high = mid ;
            setMid() ;
        }
    }

    int getMid () {
        return mid ;
    }

    void setMid () {
        mid = (low + high) / 2;
    }
}
