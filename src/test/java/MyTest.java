import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyTest {

	/*
	Since we can not test because our GameLogic class uses JavaFx elements and due to time constraints we ran out
	of time to make a new class and data structure just for the sake of testing, I have done a layout for what we would
	test for.

	validMoveTest
	the method returns true or false for a valid move by checking to see if there is a button that belongs to player
	one or two below it. If the button below it belongs to player 0 it means that no one owns that square and thus
	a button being placed above it would be invalid. This check is only done for rows above the final row because
	buttons placed at the bottom of the board are always valid.

	would make test to assert true when buttons are being placed in the bottom most row or when buttons are placed
	above a button that another player owns.

	would make test to assert false when moves are placed above squares where there is no button that is owned by
	player one ot two.
	 */

	GameButton[][] gameArray = new GameButton[ROWS][COLUMNS];
	static final int COLUMNS = 7;
	static final int ROWS = 6;

	@BeforeEach
	void init() {
		for (int x = 0; x < COLUMNS; x++) {
			for (int y = 0; y < ROWS; y++) {
				GameButton button = new GameButton(x, y);
				gameArray[y][x] = button;
			}
		}
	}

	@Test
	void testValidMove() {
		GameButton button = new GameButton(5, 1);
		gameArray[5][0].player = 1;
		assertTrue(GameLogic.determineValidMove(button, gameArray), "Move should be valid");
	}

}
