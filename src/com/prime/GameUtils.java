package com.prime;

import java.util.ArrayList;

public class GameUtils {

    public static ArrayList<Integer> getPlaysFor(int num) {
        ArrayList<Integer> plays = new ArrayList<Integer>();
        ArrayList<Integer> primeFactors = getPrimeFactors(num);
        int lastNum = num;
        int lastFactor = 1;

        for (int primeFactor : primeFactors) {
            if (primeFactor == lastFactor) {
                plays.add(lastNum /= primeFactor);
            } else {
                lastFactor = primeFactor;
                lastNum = num / primeFactor;
                plays.add(lastNum);
            }
        }

        return plays;
    }

    public static ArrayList<Integer> getPrimeFactors(int num) {
        ArrayList<Integer> primeFactors = new ArrayList<Integer>();

        while (num % 2 == 0) {
            primeFactors.add(2);
            num /= 2;
        }

        for (int i = 3; i <= Math.sqrt(num); i+= 2) {
            while (num % i == 0) {
                primeFactors.add(i);
                num /= i;
            }
        }

        if (num > 2) primeFactors.add(num);

        return primeFactors;
    }
}
