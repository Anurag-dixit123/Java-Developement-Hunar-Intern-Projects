import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X'; // 'X' starts the game
        initializeBoard();
    }

    // Initialize the board with empty cells
    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Print the current state of the board
    public void printBoard() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Check if the board is full
    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    // Check if the current player has won
    public boolean checkWin() {
        return (checkRows() || checkColumns() || checkDiagonals());
    }

    // Check rows for a win
    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return true;
            }
        }
        return false;
    }

    // Check columns for a win
    private boolean checkColumns() {
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
                return true;
            }
        }
        return false;
    }

    // Check diagonals for a win
    private boolean checkDiagonals() {
        return ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-')
                || (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-'));
    }

    // Switch player
    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Place a move on the board
    public void placeMove(int row, int col) {
        board[row][col] = currentPlayer;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Player X will start the game.");

        while (!game.isBoardFull() && !game.checkWin()) {
            game.printBoard();
            System.out.println("Player " + game.currentPlayer + ", enter your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // Check if the move is valid
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && game.board[row][col] == '-') {
                game.placeMove(row, col);
                if (game.checkWin()) {
                    System.out.println("Player " + game.currentPlayer + " wins!");
                } else if (game.isBoardFull()) {
                    System.out.println("It's a draw!");
                } else {
                    game.switchPlayer();
                }
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
        game.printBoard();
        System.out.println("Game over.");
        scanner.close();
    }
}
