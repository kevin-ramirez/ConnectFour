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

	checkForWinTest
    This method returns true or false based on which checkwin method there is. There are 3 checkwin methods we are dealing with:
    vertical method, horizontal method and diagonal method. Again, the method is a boolean method, and it loops through the
    gameboard array in a different way based upon which gamewin method we are searching for.

    This is the toughest method of the program to test. The reason for this is because there are many edge cases we have initially
    not thought of. These include checking corner edge cases to make sure out looping is not out of bounds, thus
    we would make test to assert true when the buttons would make connect 4 in the 3 following ways:

    Assert true if the last connect 4 pattern is of vertical shape thus all the 3 buttons on the bottom of it would
    be highlighted to make sure the winner is announced and gameplay ends.

    Assert true if the last connect 4 patter is of horizontal shape either going from left to right or right to left and
    all of 3 buttons either to the left or to the right of the last button clicked would be highlighted and gameplay would end.

    Assert true if the last connect 4 patter is of diagonal shape either going in SW, SE, NE or NW direction depending upon
    where the last winner button was clicked. The 4 connect buttons would be highlighted to display the winner and end the
    gameplay scene.

    On the other hand for the assert false patterns we would look for different edge cases where the checkwin method would fail.
    These involve diagonal method going out of bounds due to our constructed for loop. As looping would go out of bounds
    assert false would be returned.

    Assert false would also appear on many incomplete connect 4 cases such as only having 3,2,or 1 button of the same color,
    thus not completing the requirement and returning false.
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

//	@Test
//	void checkforWn() {
//		int player = 0;
//		GameButton button = new GameButton(5, 1);
//		assertTrue(GameLogic.checkForWin(player, button, gameArray), "This is a win");
//	}

}
