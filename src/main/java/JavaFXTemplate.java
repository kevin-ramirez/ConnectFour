import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	private EventHandler<ActionEvent> closeHandler;
	private GridPane gameBoard = new GridPane();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Welcome to Connect Four!");

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

		// End Handlers

		// Assign Handlers
		exitGameBtn.setOnAction(closeHandler);

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

		pane.setStyle("-fx-background-color: lightsalmon;"); vBox.setAlignment(Pos.CENTER);
		hBox.setAlignment(Pos.CENTER);
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(15, 12, 15, 12)); vBox.setPadding(new Insets(15, 12, 15, 12));
		startGameBtn.setMinSize(70, 25);
		exitGameBtn.setMinSize(70,25);

		return new Scene(pane, 500, 500);
	}
}
