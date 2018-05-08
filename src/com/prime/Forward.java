package com.prime;

import java.util.ArrayList;

public class Forward implements Strategy {
    @Override
    public boolean isWinner(int num) {
        boolean [] winners = new boolean[num + 1];
        ArrayList<Integer> plays = new ArrayList<Integer>();

        winners[0] = false;
        winners[1] = true;

        for (int i = 2; i <= num; i++) {
            plays = GameUtils.getPlaysFor(num);

            for (int play : plays) {
                if (winners[play]) {
                    winners[i] = false;
                    break;
                }
                winners[i] = true;
            }
        }

        return winners[num];
    }
}
