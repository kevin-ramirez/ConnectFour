import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaFXTemplate extends Application {

	// Pic dimensions for welcomeScreen() and img1.png
	private static final int picHeight = 500;
	private static final int picWidth = 500;

	// Game board dimensions
	private static final int ROWS = 6;
	private static final int COLUMNS = 7;

	private Button startGameBtn, exitGameBtn;
	private EventHandler<ActionEvent> closeHandler, gameButtonHandler;
	private GridPane gameBoard;
	private BorderPane gamePane;
	private Text whichPlayer;
	private ListView<String> gameLog;
	private GameButton [][] gameArray = new GameButton[ROWS][COLUMNS];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Welcome to Connect Four!");

		gamePane = new BorderPane();

		// Button declarations
		startGameBtn = new Button("Play");
		exitGameBtn = new Button("Exit");

		// Handlers
		closeHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				System.exit(0);
			}
		};

		gameButtonHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				GameButton button = (GameButton)actionEvent.getSource();

				gameLog.getItems().add(whichPlayer.getText() + " Placed a piece at Cords: " + button.row + ", " + button.column);
				System.out.println("Cords: " + button.row + ", " + button.column + " " + button.player);

				GameLogic.something();
				GameLogic.something2(gameArray);

				if (whichPlayer.getText().equals("Player One")) {
					button.player = 1;
					button.setStyle("-fx-background-color: orange");
					whichPlayer.setText("Player Two");
				} else {
					button.player = 2;
					button.setStyle("-fx-background-color: purple");
					whichPlayer.setText("Player One");
				}

			}
		};

		// End Handlers

		// Assign Handlers
		exitGameBtn.setOnAction(closeHandler);
		startGameBtn.setOnAction(e -> primaryStage.setScene(gamePlayScreen()));

		// End Assign Handlers

		primaryStage.setScene(welcomeScreen());
		primaryStage.show();
	}

	// Sets the welcome screen
	private Scene welcomeScreen() {
		BorderPane pane = new BorderPane();
		Text welcomeScreenText = new Text();
		welcomeScreenText.setText("Welcome! Press PLAY to play or EXIT to exit");
		Image pic = new Image("img1.jpg");
		ImageView view = new ImageView(pic);
		view.setFitHeight(picHeight);
		view.setFitWidth(picWidth);
		view.setPreserveRatio(true);
		HBox hBox = new HBox();
		VBox vBox = new VBox(); vBox.getChildren().add(welcomeScreenText);
		hBox.getChildren().addAll(startGameBtn, exitGameBtn);
		pane.setTop(vBox);
		pane.setCenter(view);
		pane.setBottom(hBox);

		pane.setStyle("-fx-background-color: lightsalmon;");
		vBox.setAlignment(Pos.CENTER);
		hBox.setAlignment(Pos.CENTER);
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(15, 12, 15, 12));
		vBox.setPadding(new Insets(15, 12, 15, 12));
		startGameBtn.setMinSize(70, 25);
		exitGameBtn.setMinSize(70,25);

		return new Scene(pane, 500, 500);
	}

	// Creates the game play screen
	private Scene gamePlayScreen() {
		HBox hBox = new HBox();
		gameLog = new ListView<>();
		whichPlayer = new Text();
		whichPlayer.setText("Player One");
		gameBoard = new GridPane();

		gameBoard.setMinWidth(300);
		gameBoard.setMaxWidth(400);
		addGrid(gameBoard);

		gameLog.setEditable(true);
		gameLog.setMaxSize(400, 200);
		hBox.setAlignment(Pos.CENTER);
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(15, 12, 15, 12));
		hBox.getChildren().addAll(gameLog, whichPlayer);
		gameBoard.setAlignment(Pos.CENTER);
		gamePane.setCenter(gameBoard);
		gamePane.setBottom(hBox);
		gamePane.setStyle("-fx-background-color: lightsalmon;");

		return new Scene(gamePane, 700, 700);
	}

	// Loads the game buttons into the grid pane and into an internal 2d array to be used for game logic
	private void addGrid(GridPane pane) {
		for (int x = 0; x < COLUMNS; x++) {
			for (int y = 0; y < ROWS; y++) {
				GameButton button = new GameButton(x, y);
				button.setOnAction(gameButtonHandler);

				button.setMinSize(50, 50);
				button.setStyle("-fx-background-color: transparent");
				button.setStyle("-fx-border-color: black; -fx-border-width: 2px");
				gameArray[y][x] = button;
				pane.add(button, x, y);
			}
		}
		pane.setHgap(10);
		pane.setVgap(10);
	}
}
