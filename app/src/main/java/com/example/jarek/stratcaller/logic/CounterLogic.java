package com.example.jarek.stratcaller.logic;

import com.example.jarek.stratcaller.R;

public class CounterLogic {

    private int myCount;

    //Construct a counter whose value is zero
    public CounterLogic() {
        myCount = 0;
    }

    //Construct a counter with given initial value
    public CounterLogic(int initValue) {
        myCount = initValue;
    }

    //Get counter value
    public int getValue() {
        return myCount;
    }

    //Set counter value to zero
    public void clear() {
        myCount = 0;
    }

    //Increment counter value
    public void increment() {
        myCount++;
    }

    //Returns string value of counter
    public String toString() {
        return ""+myCount;
    }

    //Check for win
    public boolean checkForWin() {
        return myCount == 16;
    }

    //Check for draw
    public boolean checkForDraw(CounterLogic ct, CounterLogic tt){
        return ct.myCount == 15 && tt.myCount == 15;
    }
}