
package com.adaptionsoft.games.trivia.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Board;
import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.PlayerRegistry;
import com.adaptionsoft.games.uglytrivia.QuestionBox;


public class GameRunner {

	private boolean notAWinner;

	public static void main(String[] args) {
		GameRunner gameRunner = new GameRunner();
		List<String> players = new ArrayList<String>();
		players.add("Chet");
		players.add("Pat");
		players.add("Sue");
		gameRunner.run(players);
	}

	public void run(List<String> players) {
		Random rand = new Random();
		this.runRandomGame(rand, players);
	}

	public void runWithSeed(int seed, List<String> players) {
		Random rand = new Random(seed);
		this.runRandomGame(rand, players);
	}

	private void runRandomGame(Random rand, List<String> players) {
		Game aGame = new Game(new QuestionBox(), new PlayerRegistry(), new Board());
		for (String player : players) {
			aGame.add(player);
		}
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
