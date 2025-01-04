/*
* Names: Benjamin Frerichs
* netID: bfrerich
* G#: 01449931
* Lecture section: 001
* Lab section: 202
*/

public abstract class Player    {
    

    public abstract TicTacToe chooseMove(TicTacToe board);

    public double boardValue(TicTacToe game)    {
        if (game.checkWin(this))    {
            return 1.0;
        }
        else if (game.checkLose(this))  {
            return -1.0;
        }
        else    {
            return 0.0;
        }
        
    }


}
