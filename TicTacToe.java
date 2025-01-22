import java.util.*;
 public class TicTacToe {
    private static String[] board;
    private static String turn;
    public static String checkWinner() {
        for (int i = 0; i < 8; i++) {
            String line = null;
            switch (i) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            // For X winner
            if (line.equals("XXX")) {
                System.out.println("Player X Wins!");
                return "X";
            }
            // For O winner
            else if (line.equals("OOO")) {
                System.out.println("Player O Wins!");
                return "O";
            }
        }
        // Check for draw
        for (int j = 0; j < board.length; j++) {
            if (board[j].equals(String.valueOf(j + 1))) {
                return null; // Game is ongoing
            }
        }
        System.out.println("Draw!");
        return "draw";
    }
    public static void printBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|---|---|---|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|---|---|---|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");
    }
    public static void main(String[] args) {
        String winner = null;
        Scanner scanner = new Scanner(System.in);
        board = new String[9];
        for (int i = 0; i < board.length; i++) {
            board[i] = String.valueOf(i + 1);
        }
        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        printBoard();
        turn = "X"; // Start with uppercase X for consistency
        System.out.println("X will play first. Enter the slot to place X:");
        while (winner == null) {
            int slotInput;
            try {
                slotInput = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter a number between 1 and 9.");
                scanner.next(); // Clear invalid input
                continue;
            }
            if (slotInput < 1 || slotInput > 9) {
                System.out.println("Invalid input. Slots are only between 1 and 9. Try again:");
                continue;
            }
            if (board[slotInput - 1].equals(String.valueOf(slotInput))) {
                board[slotInput - 1] = turn;
                turn = turn.equals("X") ? "O" : "X"; // Switch turns
                printBoard();
                winner = checkWinner();
            } else {
                System.out.println("Slot already taken. Re-enter slot number:");
            }
        }
    }
}