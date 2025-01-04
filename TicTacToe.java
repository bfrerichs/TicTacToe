/*
* Names: Benjamin Frerichs
* netID: bfrerich
* G#: 01449931
* Lecture section: 001
* Lab section: 202
*/

public class TicTacToe {
    private char[][] board;
    private Player x;
    private Player o;

    public TicTacToe(Player x, Player o)  {
        this.x = x;
        this.o = o;
        this.board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = '_';
            }
        }
    }

    public char[][] getBoard()  {
        return board;
    }

    public void setBoard(char[][] board)    {
        this.board = board;
    }

    public Player getX()    {
        return x;
    }

    public void setX(Player x) {
        this.x = x;
    }  

    public Player getO()    {
        return o;
    }

    public void setO(Player o)  {
        this.o = o;
    }

    public int countBlanks()    {

        int numBlanks = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '_') {
                    numBlanks += 1;
                }
            }
        }

        return numBlanks;
    }

    public char markerForPlayer(Player player)   {
        if (player == x)   {
            return 'X';
        }
        else    {
            return 'O';
        }
    }

    public boolean checkWin(Player player)  {
        char mark = markerForPlayer(player);

        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == mark && board[i][1] == mark && board[i][2] == mark) || 
            (board[0][i] == mark && board[1][i] == mark && board[2][i] == mark))    {
                return true;
            }
        }

        if ((board[0][0] == mark && board[1][1] == mark && board[2][2] == mark) || 
            (board[0][2] == mark && board[1][1] == mark && board[2][0] == mark))    {
                return true;
            }

        return false;
    }

    public boolean checkLose(Player player) {
        if (player == x)    {
            return checkWin(o);
        }
        else    {
            return checkWin(x);
        }
    }

    public boolean checkDraw()  {
        return countBlanks() == 0 && !checkWin(x) && !checkWin(o);
    }

    @Override
    public String toString()    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public TicTacToe[] possibleMoves(Player player) {
        
        TicTacToe[] moves = new TicTacToe[countBlanks()];
        int index = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '_') {
                    TicTacToe board2 = new TicTacToe(x, o);

                    for (int k = 0; k < 3; k++) {
                        System.arraycopy(this.board[k], 0, board2.board[k], 0, 3);
                    }
                    board2.board[i][j] = markerForPlayer(player);
                    moves[index++] = board2;
                }
                
                
            }
        }
        
        return moves;
    }
}
