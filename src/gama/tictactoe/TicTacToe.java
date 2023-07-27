package gama.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static char board[][];

    TicTacToe() {
        board = new char[3][3];
        initialBoard();
    }

    public static void initialBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
    }

    public static void printBoard() {
        System.out.println("--------------");
        for (int row = 0; row < board.length; row++) {
            System.out.print("| ");
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
            System.out.println("--------------");

        }
    }
    public static void placeMark(int row,int col,char mark){
        if(row>=0&&row<3&&col>=0&&col<3){
            board[row][col]=mark;
        }
        else {
            System.out.println("invalid move try again...");
        }

    }

    static boolean rowWin() {
        for(int i=0;i<3;i++){
            if(board[i][0]!=' '&&board[i][0]==board[i][1]&&board[i][1]==board[i][2]){
                return true;
            }
        }
        return false;
    }

    static boolean colWin() {
        for (int i=0;i<3;i++){
            if(board[0][i]!=' '&& board[0][i]==board[1][i]&&board[1][i]==board[2][i]){
                return true;
            }
        }
        return false;
    }

    static boolean diaWin() {
        if((board[0][0]!=' '&&board[0][0]==board[1][1]&&board[1][1]==board[2][2])||
                (board[0][2]!=' '&&board[0][2]==board[1][1]&&board[1][1]==board[2][0])){
            return true;
        }
        return false;
    }
    static boolean drawMatch(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
               if(board[i][j]!=' '){
                   return false;
               }
            }
        }
        return  true;
    }
}
    abstract class Player {
        String name;
        char mark;
        Player(String name, char mark) {
            this.name = name;
            this.mark = mark;
        }
         int row;
        int col;
        abstract void makeMove();

        public boolean isValidateMove( int row, int col) {
            if(row>=0 && row<3 && col>=0 &&col <3){
                 if(TicTacToe.board[row][col]==' '){
                    return true;
                }
            }
            System.out.println("invalid row and column try again..");
            return false;
        }

    }

    class HumanPlayer extends Player{

        HumanPlayer(String name, char mark) {
            super(name, mark);
        }

        @Override
        void makeMove() {
            Scanner sc=new Scanner(System.in);
            int row,col;
            do{
                 row= sc.nextInt();
                col=sc.nextInt();
            }while (!isValidateMove(row,col));
            TicTacToe.placeMark(row,col,mark);
        }
    }
    class AIPlayer extends Player{
         AIPlayer(String name,char mark){
             super(name,mark);
         }

        @Override
        void makeMove() {
            Random r=new Random();
            int row,col;
            do{
                 row=r.nextInt(3);
                 col=r.nextInt(3);
            }while(!isValidateMove(row,col));
            TicTacToe.placeMark(row,col,mark);

        }
    }



