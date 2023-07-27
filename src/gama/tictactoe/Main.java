package gama.tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void menu() {
        System.out.println("********************TicTacToe********************"
        +"\nSELECT YOUR OPPONONENT\n1. Friend \n2. Computer");
    }

    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        menu();
        Scanner sc = new Scanner(System.in);
        HumanPlayer p1 = new HumanPlayer("Puvi", 'X');
        int opt = sc.nextInt();
        Player cp = p1;
        switch (opt) {
            case 1:
                System.out.println("Enter  name:");
                String name = sc.next();
                HumanPlayer p2 = new HumanPlayer(name, 'O');
                startGame(cp,p1,p2);
                break;
            case 2:
                AIPlayer p3 = new AIPlayer("Computer", 'O');
                startGame(cp,p1,p3);
                break;
            default:
                System.out.println("enter valid option");
        }
    }
       public static void startGame(Player cp,Player p1,Player p2){
        while (true) {
            TicTacToe.printBoard();
            System.out.println(cp.name + " please enter row and column");
            cp.makeMove();

            if (TicTacToe.rowWin() || TicTacToe.colWin() || TicTacToe.diaWin()) {
                System.out.println("player " + cp.name + " has won...");
                TicTacToe.printBoard();
                break;
            } else if (TicTacToe.drawMatch()) {
                System.out.println("Match draw...");
                break;
            } else {
                if (cp == p1) cp = p2;
                else cp = p1;

            }
        }

    }
}



