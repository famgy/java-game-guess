package game;

import java.util.*;

public class DotComBust {
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	private int numOfGuesses = 0;
	
	private void setupGame() {
		DotCom one = new DotCom();
		one.setName("Pets.com");
		
		DotCom two = new DotCom();
		one.setName("eToys.com");
		
		DotCom three = new DotCom();
		one.setName("Go2.com");
		
		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);
		
		System.out.println("Your goal is to sink three dot coms.");
		System.out.println("Pets.com, eToys.com, Go2.com");
		System.out.println("Try to sink them all in the fewest number of guesses.");
		
		for (DotCom dotComToSet : dotComsList) {
			ArrayList<String> newLocaltion = helper.placeDotCom(3);
			dotComToSet.setLocationCell(newLocaltion);
		}
	}
	
	private void checkUserGuess(String userGuess) {
		numOfGuesses++;
		
		String result = "miss";
		
		for (DotCom dotComToTest : dotComsList) {
			result = dotComToTest.checkYourself(userGuess);
			
			if (result.equals("hit")) {
				break;
			}
			
			if (result.equals("kill")) {
				dotComsList.remove(dotComToTest);
				break;
			}
		}
	}
	
	private void finishGame() {
		System.out.println("All Dot Coms are dead! your stock is now worthless.");
		
		if (numOfGuesses <= 18) {
			System.out.println("It only took you " + numOfGuesses + " guesses.");
			System.out.println(" You got out before you options sank.");
		} else {
			System.out.println("Took you long enough. " + numOfGuesses + " guesses");
			System.out.println("Fish are dancing with you options.");
		}
	}
	
	private void startPlaying() {
		while(!dotComsList.isEmpty()) {
			String userGuess = helper.getUserInput("Enter a guess");
			checkUserGuess(userGuess);
		}
		
		finishGame();
	}

	public static void main(String[] args) {
		DotComBust game = new DotComBust();
		game.setupGame();
		game.startPlaying();
	}
}
