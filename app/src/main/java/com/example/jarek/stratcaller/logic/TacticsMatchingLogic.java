package com.example.jarek.stratcaller.logic;

public class TacticsMatchingLogic {

    //Decision about side swap
    public boolean sideSwapCheck(CounterLogic rounds){
        return rounds.getValue() == 16;
    }

    //Decision about strat swap
    public boolean styleSwapCheck(CounterLogic streak){
        return streak.getValue() == 5;
    }

    //Do side swap
    public String sideSwap(String currentSide){
        if(currentSide == "CT") { currentSide = "TT";}
        else if(currentSide == "TT") { currentSide = "CT";}
        return currentSide;
    }
}
