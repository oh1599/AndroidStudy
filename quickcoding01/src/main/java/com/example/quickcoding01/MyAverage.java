package com.example.quickcoding01;



public class MyAverage extends MyValues {

    int getResult () {

        ans = 0 ;

        for (int tmp : value) {

            ans += tmp ;
        }

        ans /= value.length ;

        return ans ;
    }
}
