import java.util.Scanner;

public class Driver
{
    public static void main(String[] args)
    {
        TicTacToe game = new TicTacToe();

        char player = 'X';
        Scanner input = new Scanner(System.in);

        while(!game.gameOver())
        {
            System.out.println(game);

            System.out.println("Player " + player + ", choose a space: ");



            if(game.move(player, input.nextInt()))
            {
                if(player == 'X')
                {
                    player = 'O';
                }
                else
                    player = 'X';
            }
        }

        System.out.println(game);
        System.out.println("Game Over!");

    }
}
