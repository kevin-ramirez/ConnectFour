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

    public static boolean checkForWin(int player, GameButton button, GameButton[][] arr) {

        int row = button.row;
        int column = button.column;

        int count = 0;
        for (int i = row; i >=0; i--){
            if (arr[i][column].player != player){
                break;
            }
            else {
                count += 1;
            }
            if (count == 4){
                return true;
            }
        }

        return false;



        /*
        for (int i = column; i >= 0; i--){
            if (arr[i][row].player != button.player){
                break;
            }
            else {
                count += 1;
            }

            if (count == 4) {
                return true;
            }

        }







        for (int x = row; x < COLUMNS; x++) {

            int count = 0;
            for (int y = 0; y < ROWS; y++) {
                if (arr[y][x].player == 1) {
                    count += 1;
                }
                else {
                    break;
                }
                if (count == 4) {
                    return true;
                }
            }

            return false;
        }

        return  false;


        int count = 0;
        if (arr[button.row][button.column].player != 0){
            return;
        }
        else{
            count +=1;
        }
        return false;

        */
    }


    //x  x x  x
    //easier way
    // check from only last user input button

}
