import java.util.Scanner;

public class Main {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String[][] board = new String[ROW][COL];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean playAgain;
        do {
            clearBoard();
            String player = "X";
            boolean gameWon = false;
            boolean gameTie = false;

            while (!gameWon && !gameTie) {
                display();
                int rowMove = SafeInput.getRangedInt(in, "Enter row (1-3) for " + player, 1, 3) - 1;
                int colMove = SafeInput.getRangedInt(in, "Enter column (1-3) for " + player, 1, 3) - 1;

                while (!isValidMove(rowMove, colMove)) {
                    System.out.println("Invalid move! Cell already taken.");
                    rowMove = SafeInput.getRangedInt(in, "Enter row (1-3) for " + player, 1, 3) - 1;
                    colMove = SafeInput.getRangedInt(in, "Enter column (1-3) for " + player, 1, 3) - 1;
                }

                board[rowMove][colMove] = player;
                gameWon = isWin(player);
                gameTie = isTie();

                if (gameWon) {
                    display();
                    System.out.println("Player " + player + " wins!");
                } else if (gameTie) {
                    display();
                    System.out.println("The game is a tie!");
                } else {
                    player = player.equals("X") ? "O" : "X";
                }
            }

            playAgain = SafeInput.getYNConfirm(in, "Do you want to play again?");
        } while (playAgain);
    }

    private static void clearBoard() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                board[row][col] = " ";
            }
        }
    }

    private static void display() {
        System.out.println("Current Board:");
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                System.out.print(board[row][col]);
                if (col < COL - 1) System.out.print(" | ");
            }
            System.out.println();
            if (row < ROW - 1) System.out.println("---------");
        }
    }

    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }

    private static boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    private static boolean isRowWin(String player) {
        for (int row = 0; row < ROW; row++) {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isColWin(String player) {
        for (int col = 0; col < COL; col++) {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    private static boolean isTie() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                if (board[row][col].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
}
