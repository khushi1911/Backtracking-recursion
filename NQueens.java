public class NQueens {

    static int N = 4;

    static boolean isSafe(int[][] board, int row, int col) {

        // Check upper column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }

        // Check upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    static boolean solveNQueens(int[][] board, int row) {

        if (row == N) {
            return true;
        }

        for (int col = 0; col < N; col++) {

            if (isSafe(board, row, col)) {

                board[row][col] = 1;

                if (solveNQueens(board, row + 1))
                    return true;

                board[row][col] = 0; // Backtrack
            }
        }

        return false;
    }

    static void printBoard(int[][] board) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] board = new int[N][N];

        if (solveNQueens(board, 0)) {
            System.out.println("Solution Found:");
            printBoard(board);
        } else {
            System.out.println("No Solution Exists");
        }
    }
}