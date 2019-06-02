// Muhammad Usama		FA17-BCS-146
// Assignment Statement
// Create a Game in which user will try to guess an Alphabet which Computer have randomly chosen

import javax.swing.UIManager;

public class GuessGame {


	public static void main(String[] args) {
		
		// Just Changing Appearance
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		Gui game = new Gui();
		
		// Starting Game by calling startGame method of obj  
		game.startGame();
	}

}
