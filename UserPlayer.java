/*
* Names: Benjamin Frerichs
* netID: bfrerich
* G#: 01449931
* Lecture section: 001
* Lab section: 202
*/

import java.util.Scanner;

public class UserPlayer extends Player{

    private String name;
    private Scanner input;
    
    public UserPlayer(Scanner input, String name)   {
        this.name = name;
        this.input = input;
    }

    @Override
    public String toString()    {
        return name;
    }

    @Override 
    public TicTacToe chooseMove(TicTacToe board) {
        System.out.println(board.toString());

        TicTacToe[] possibleMoves = board.possibleMoves(this);

        

        if (possibleMoves.length == 0)  {
            return board;
        }

        for (int i = 0; i < possibleMoves.length; i++) {
            System.out.println(i + ":");
            System.out.println(possibleMoves[i].toString());
        }

        System.out.println("Select a move (0 to " + (possibleMoves.length -1) + "): ");
        int choice = input.nextInt();

        return possibleMoves[choice];
    }

    
}
