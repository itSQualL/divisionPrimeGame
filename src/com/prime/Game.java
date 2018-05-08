package com.prime;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private static Scanner read = new Scanner (System.in);
    private Strategy strategy;
    private int num;

    public Game(Strategy strategy, int num) {
        this.strategy = strategy;
        this.num = num;
    }

    public String run() {
        int playNum = num;
        boolean machineTurn= true;
        ArrayList<Integer> plays;

        System.out.println("Comienza el juego");

        while(playNum != 1) {
            System.out.print("\nTurno de: ");

            if (machineTurn) {
                System.out.println("La Máquina");
                plays = GameUtils.getPlaysFor(playNum);
                System.out.println("jugadas posibles: " + plays.toString());

                for (int play : plays) {
                    if (isWinner(play)) {
                        playNum = play;
                        break;
                    }

                    playNum = play;
                }

                System.out.println("Num jugado: " + playNum);

                machineTurn = false;
            } else {
                System.out.println("El Jugador");
                plays = GameUtils.getPlaysFor(playNum);
                System.out.println("jugadas posibles: " + plays.toString());

                System.out.println("Introduce número a jugar");

                playNum = read.nextInt();
                System.out.println("Num jugado: " + playNum);

                machineTurn = true;
            }
        }

        return machineTurn ? "El jugador!!" : "La máquina!!";
    }

    public boolean isWinner(int num) {
        return strategy.isWinner(num);
    }
}
