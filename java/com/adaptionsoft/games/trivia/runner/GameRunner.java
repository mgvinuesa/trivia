
package com.adaptionsoft.games.trivia.runner;

import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;


public class GameRunner {

	private static boolean notAWinner;

	public static void main(String[] args) {
		GameRunner gameRunner = new GameRunner();
		gameRunner.run();
	}

	public void run(){
		Random rand = new Random();
		this.runRandomGame(rand);
	}

	public void runWithSeed(int seed) {
		Random rand = new Random(seed);
		this.runRandomGame(rand);
	}

	private void runRandomGame(Random rand) {
		Game aGame = new Game();

		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");

		do {

			aGame.roll(rand.nextInt(5) + 1);

			if (rand.nextInt(9) == 7) {
				notAWinner = aGame.wrongAnswer();
			} else {
				notAWinner = aGame.wasCorrectlyAnswered();
			}



		} while (notAWinner);
	}
}
