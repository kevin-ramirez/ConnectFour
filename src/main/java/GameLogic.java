public class GameLogic {
    public static final int ROWS = 6;
    public static final int COLUMNS = 7;

    public static boolean determineValidMove(GameButton button, GameButton[][] board) {
        // We only need to check buttons that are not in the bottom row
        if (button.row != 5) {
            return board[button.row + 1][button.column].player != 0;
        }
        return true;
    }

    public static void clearBoard(GameButton[][] board) {
        for (int x = 0; x < COLUMNS; x++) {
            for (int y = 0; y < ROWS; y++) {
                board[y][x].setDisable(false);
                board[y][x].player = 0;
                board[y][x].setStyle("-fx-background-color: transparent");
                board[y][x].setStyle("-fx-border-color: black; -fx-border-width: 2px");
            }
        }
    }

}
