/*
* Names: Benjamin Frerichs
* netID: bfrerich
* G#: 01449931
* Lecture section: 001
* Lab section: 202
*/

public class AIPlayer extends Player {
    private String name;
    private Player opponent;

    public Player getOpponent() {
        return opponent;
    }

    public void setOpponent(Player opponent)    {
        this.opponent = opponent;
    }

    @Override
    public String toString()    {
        return name + " (AI)";
    }

    public AIPlayer(String name, Player opponent)   {
        this.name = name;
        this.opponent = opponent;
    }

    public double minValue(TicTacToe currentGame)   {
        if (currentGame.checkWin(this))  {
            return 1.0;
        }
        else if (currentGame.checkWin(opponent))    {
            return -1.0;
        }
        else if (currentGame.checkDraw())   {
            return 0.0;
        }

        double bestVal = Double.POSITIVE_INFINITY;
        TicTacToe[] possibleMoves = currentGame.possibleMoves(opponent);
        for (TicTacToe move : possibleMoves)    {
            bestVal = Math.min(bestVal, maxValue(move));
        }
        return bestVal;
    }

    public double maxValue(TicTacToe currentGame)   {
        if (currentGame.checkWin(this))  {
            return 1.0;
        }
        else if (currentGame.checkWin(opponent))    {
            return -1.0;
        }
        else if (currentGame.checkDraw())   {
            return 0.0;
        }

        double bestVal = Double.NEGATIVE_INFINITY;
        TicTacToe[] possibleMoves = currentGame.possibleMoves(this);
        for (TicTacToe move : possibleMoves)    {
            bestVal = Math.max(bestVal, minValue(move));
        }
        return bestVal;
    }

    @Override
    public TicTacToe chooseMove(TicTacToe game) {
        TicTacToe[] possibleMoves = game.possibleMoves(this);

        if (possibleMoves.length == 0)  {
            System.out.println("No more valid moves.");
            return null;
        }

        double bestVal = Double.NEGATIVE_INFINITY;
        TicTacToe bestMove = null;

        for (TicTacToe move : possibleMoves)    {
            double moveVal = minValue(move);
            if (moveVal > bestVal)  {
                bestVal = moveVal;
                bestMove = move;
            }
        }
        
        return bestMove != null ? bestMove : game;
    }

    @Override
    public double boardValue(TicTacToe board)   {
        return maxValue(board);
    }
    
}
