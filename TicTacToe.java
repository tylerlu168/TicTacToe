public class TicTacToe
{
    private char [][] board;

    public TicTacToe()
    {
        board = new char[3][3];
    }


    /**
     * Inserts player at the corresponding space if
     *      the space is available.
     *
     * Precondition: player is 'X' or 'O'
     *               1 <= space <= 9
     *
     * @param player
     * @param space
     * @return true id move is successful; false otherwise
     */
    public boolean move(char player, int space)
    {
        space--;

        int row = space / 3;
        int col = space % 3;

        if(board[row][col] != 'X' && board[row][col] != 'O')
        {
            board[row][col] = player;
            return true;
        }

        return false;
    }

    public String toString()
    {
        String str = "";

        int space = 1;

        for (int r = 0; r < board.length; r++)
        {
            for (int c = 0; c < board[r].length; c++)
            {
                str += " ";

                if(board[r][c] == 'X' || board[r][c] == 'O')
                {
                    str += board[r][c];
                }
                else
                {
                    str += space;
                }
                str += " ";

                if(space % 3 != 0)
                {
                    str += "|";
                }

                space++;
            }
            if(r != board.length - 1)
            str += "\n-----------\n";
        }
        return str;
    }

    public boolean gameOver()
    {
        return gameOverZontal() || gameOverVert() || gameOverDiagonal() || gameOverTie();
    }

    private boolean gameOverTie()
    {
        for (int r = 0; r < board.length; r++)
        {
            for (int c = 0; c < board[r].length; c++)
            {
                if(board[r][c] == 0)
                    return false;
            }
        }
        return true;
    }


    private boolean gameOverDiagonal()
    {
        if(board[1][1] == 0)
        {
            return false;
        }

        if(board[0][0] == board[1][1] && board[1][1] == board[2][2])
        {
            return true;
        }
        if(board[0][2] == board[1][1] && board[1][1] == board[2][0])
        {
            return true;
        }
        return false;
    }

    private boolean gameOverVert()
    {
        for (int c = 0; c < board[0].length; c++)
        {
            if(board[0][c] != 0 && board[0][c] == board[1][c] && board[1][c] == board[2][c])
            {
                return true;
            }

        }
        return false;
    }

    private boolean gameOverZontal()
    {
        for (int r = 0; r < board.length; r++)
        {
            if(board[r][0] != 0 && board[r][0] == board[r][1] && board[r][1] == board[r][2])
            {
                return true;
            }

        }
        return false;
    }
}
