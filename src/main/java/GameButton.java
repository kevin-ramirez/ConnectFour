import javafx.scene.control.Button;

public class GameButton extends Button {
    public int row;
    public int column;
    public int player;

    GameButton(int column, int row) {
        this.column = column;
        this.row = row;
        player = 0;
    }

}
