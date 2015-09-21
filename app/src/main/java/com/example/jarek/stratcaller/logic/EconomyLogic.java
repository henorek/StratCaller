package com.example.jarek.stratcaller.logic;

public class EconomyLogic {

    private int winMoney = 3250;
    private int loseMoney;
    private int winWithBombDefuseMoney = 3500;
    private int killReward = 300;

    public int getWinMoney() {
        return winMoney;
    }

    public int getWinWithBombDefuseMoney() {
        return winWithBombDefuseMoney;
    }

    public int getKillReward() {
        return killReward;
    }

    public int moneyOnLoseStreak(CounterLogic streak, boolean bomb){
        switch(streak.getValue()){
            case 1:
                loseMoney = 1400;
                break;
            case 2:
                loseMoney = 1900;
                break;
            case 3:
                loseMoney = 2400;
                break;
            case 4:
                loseMoney = 2900;
                break;
            case 5:
                loseMoney = 3400;
                break;
            default:
                loseMoney = 3400;
                break;
        }
        if(bomb){ return loseMoney + 800; }
        else return loseMoney;
    }
}
