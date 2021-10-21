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

}
