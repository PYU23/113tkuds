import java.util.Scanner;
public class TicTacToe5x5 {
     static final int SIZE = 5;
    static char[][] board = new char[SIZE][SIZE];
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        initializeBoard();
        char currentPlayer = 'X';
        boolean gameEnded = false;
        while (!gameEnded) {
            printBoard();
            boolean validMove = false;
            int row = -1, col = -1;
            while (!validMove) {
                System.out.print("玩家 " + currentPlayer + " 請輸入 row 和 col（0–4）: ");
                if (scanner.hasNextInt()) {
                    row = scanner.nextInt();
                } else {
                    scanner.next(); // skip invalid token
                    System.out.println("請輸入整數！");
                    continue;
                }
                if (scanner.hasNextInt()) {
                    col = scanner.nextInt();
                } else {
                    scanner.next(); // skip invalid token
                    System.out.println("請輸入整數！");
                    continue;
                }
                if (isValidMove(row, col)) {
                    board[row][col] = currentPlayer;
                    System.out.println("玩家 " + currentPlayer + " 在位置 (" + row + ", " + col + ") 放置棋子");
                    validMove = true;
                } else {
                    System.out.println("無效的輸入，請重新輸入！");
                }
            }
            if (checkWin(currentPlayer)) {
                printBoard();
                System.out.println("玩家 " + currentPlayer + " 獲勝！");
                gameEnded = true;
            } else if (isBoardFull()) {
                printBoard();
                System.out.println("平手！");
                gameEnded = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // 換人
            }
        }
    }
    static void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '.';
            }
        }
    }
    static void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == '.';
    }
    static boolean checkWin(char player) {
        // 檢查每一列
        for (int i = 0; i < SIZE; i++) {
            boolean win = true;
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != player) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        // 檢查每一行
        for (int j = 0; j < SIZE; j++) {
            boolean win = true;
            for (int i = 0; i < SIZE; i++) {
                if (board[i][j] != player) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        // 檢查主對角線
        boolean win = true;
        for (int i = 0; i < SIZE; i++) {
            if (board[i][i] != player) {
                win = false;
                break;
            }
        }
        if (win) return true;
        // 檢查反對角線
        win = true;
        for (int i = 0; i < SIZE; i++) {
            if (board[i][SIZE - 1 - i] != player) {
                win = false;
                break;
            }
        }
        return win;
    }
    static boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == '.')
                    return false;
        return true;
    }
}
    

