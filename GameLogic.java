import java.util.Random;

public class GameLogic {
	private static int randomChar;
	private static char ch;

	public static final int CHAR_GREATER = 1;
	public static final int CHAR_SMALLER = 2;
	public static final int CHAR_EQUAL = 3;

	//Method to Generate Random Alphabet
	public static void randomNumberGeneration(){
		Random rand = new Random();
		randomChar = rand.nextInt((90 - 65) + 1) + 65;
		ch = (char)randomChar;
	}

	public static char getChar(){
		return ch;
	}
	
	//Method to Check Alphabet is Smaller or Greater
	public static int getResult(char userChar) {

		if(userChar > ch)
			return CHAR_GREATER;
		else if(userChar < ch)
			return CHAR_SMALLER;
		else
			return CHAR_EQUAL;
	}
}
