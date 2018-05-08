package com.prime;

import java.util.ArrayList;

public class Backward implements Strategy {
    @Override
    public boolean isWinner(int num) {
        boolean winner;
        ArrayList<Integer> plays = new ArrayList<Integer>();

        if (num == 1) {
            winner = true;
        } else {
            plays = GameUtils.getPlaysFor(num);
            winner = true;

            for (int play : plays) {
               if (isWinner(play)) {
                  winner = false;
                  break;
               }
            }
        }
        return winner;
    }
}
