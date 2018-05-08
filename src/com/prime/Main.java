package com.prime;

import java.util.Scanner;

public class Main {
    public static Scanner read = new Scanner (System.in);

    public static void main(String[] args) {
        Game game;
        String winner = "";

        System.out.println("Bienvenid@.\n¿Qué estrategia quieres usar?\n1.- Backward\n2.- Forward");
        byte strategyElection = read.nextByte();

        System.out.println("Selecciona el número a jugar");
        int num = read.nextInt();

        switch (strategyElection) {
            case 1:
                game = new Game(new Backward(), num);
                winner = game.run();
                break;
            case 2:
                game = new Game(new Forward(), num);
                winner = game.run();
                break;
        }

        System.out.println("El ganador es: " + winner);
    }
}
