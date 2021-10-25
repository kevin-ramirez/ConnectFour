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

        int count = 1;
        //Check vertical
        for (int i = row + 1; i < ROWS; i++){
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

        //Check horizontal
        count = 1;
        for (int i = column-1; i >=0; i--){
            if (arr[row][i].player != player){
                break;
            }
            else {
                count += 1;
            }
            if (count == 4){
                return true;
            }
        }

        for (int i = column+1; i < COLUMNS; i++){
            if (arr[row][i].player != player){
                break;
            }
            else {
                count += 1;
            }
            if (count == 4){
                return true;
            }
        }

        //Check diagonal
        //Going SW

        count = 1;

        outerloop1:
        for (int i = row + 1; i < ROWS; i++){
            for (int j = column - 1; j >= 0; j--){
                if (arr[i][j].player != player){
                    break outerloop1;
                }
                else {
                    count += 1;
                }
                if (count == 4) {
                    return true;
                }
                i++;
            }
        }

        //Going NE
        outerloop2:
        for (int i = row - 1; i >= 0; i--){
            for (int j = column + 1; j < COLUMNS; j++){
                if (arr[i][j].player != player){
                    break outerloop2;
                }
                else {
                    count += 1;
                }
                if (count == 4) {
                    return true;
                }
                i++;
            }
        }

        count = 1;

        //SE
        outerloop3:
        for (int i = row + 1; i < ROWS; i++){
            for (int j = column + 1; j < COLUMNS; j++){
                if (arr[i][j].player != player){
                    break outerloop3;
                }
                else {
                    count += 1;
                }
                if (count == 4) {
                    return true;
                }
                i++;
            }

        }



        //NW
        outerloop4:
        for (int i = row - 1; i >= 0; i--){
            for (int j = column - 1; j >= 0; j--){
                if (arr[i][j].player != player){
                    break outerloop4;
                }
                else {
                    count += 1;
                }
                if (count == 4) {
                    return true;
                }
                i++;
            }
        }

        return false;


    }


    //x  x x  x
    //easier way
    // check from only last user input button

}
