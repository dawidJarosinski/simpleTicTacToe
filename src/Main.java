import java.util.Scanner;

public class Main {
    static String[] Board = new String[9];
    static void resetBoard()
    {
        for(int i = 0; i < 9; i++)
        {
            Board[i] = null;
        }
    }

    static String checkWin()
    {
        String winLine = null;
        for(int i = 0; i < 8; i++) {
            switch (i) {
                case 0:
                    winLine = Board[0] + Board[1] + Board[2];
                    break;
                case 1:
                    winLine = Board[3] + Board[4] + Board[5];
                    break;
                case 2:
                    winLine = Board[6] + Board[7] + Board[8];
                    break;
                case 3:
                    winLine = Board[0] + Board[3] + Board[6];
                    break;
                case 4:
                    winLine = Board[1] + Board[4] + Board[7];
                    break;
                case 5:
                    winLine = Board[2] + Board[5] + Board[8];
                    break;
                case 6:
                    winLine = Board[0] + Board[4] + Board[8];
                    break;
                case 7:
                    winLine = Board[2] + Board[4] + Board[6];
                    break;
            }
            if (winLine.equals("XXX"))
                return "X";
            else if (winLine.equals("OOO"))
                return "O";
        }
        for(int j = 0; j < 9; j++)
        {
            if(Board[j]==(null))
                return null;
        }
        return "draw";
    }
    static void printBoard()
    {
        System.out.println("-------------");
        System.out.println("| " + Board[0] + " | " + Board[1] + " | " + Board[2] + " |");
        System.out.println("-------------");
        System.out.println("| " + Board[3] + " | " + Board[4] + " | " + Board[5] + " |");
        System.out.println("-------------");
        System.out.println("| " + Board[6] + " | " + Board[7] + " | " + Board[8] + " |");
        System.out.println("-------------");
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int position;
        System.out.println("Player X starts, type number from 1 to 9");
        resetBoard();
        printBoard();
        for(int i = 0; i < 9; i++)
        {
            position = input.nextInt();
            if(Board[position - 1] == null)
            {
                if(i%2 == 0)
                {
                    Board[position - 1] = "X";
                }
                else if(i%2 == 1)
                {
                    Board[position - 1] = "O";
                }
            }
            else
                i--;
            printBoard();
            if(checkWin()!=null)
                break;
        }
        if(checkWin().equals("draw"))
            System.out.println("draw");
        else
        {
            System.out.println("Player " + checkWin() + " won!");
        }

    }
}