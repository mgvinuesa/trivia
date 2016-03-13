package com.adaptionsoft.games.uglytrivia;

public class Game {

	private QuestionBox questionBox;
	private PlayerRegistry playerRegistry;

	private int[] places = new int[6];
	private int[] purses = new int[6];
	private boolean[] inPenaltyBox = new boolean[6];
	private boolean isGettingOutOfPenaltyBox;

	public Game(QuestionBox questionBox, PlayerRegistry playerRegistry) {
		this.questionBox = questionBox;
		this.playerRegistry = playerRegistry;
	}

	public boolean add(String playerName) {
		this.playerRegistry.addPlayer(playerName);
		places[this.playerRegistry.playerNumber()] = 0;
		purses[this.playerRegistry.playerNumber()] = 0;
		inPenaltyBox[this.playerRegistry.playerNumber()] = false;
		System.out.println(playerName + " was added");
		System.out.println("They are player number " + this.playerRegistry.playerNumber());
		return true;
	}

	public void roll(int roll) {
		String currentPlayerName = this.playerRegistry.getCurrentPlayerName();
		int currentPlayer = this.playerRegistry.getCurrentPlayer();

		System.out.println(currentPlayerName + " is the current player");
		System.out.println("They have rolled a " + roll);

		if (inPenaltyBox[currentPlayer]) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;

				System.out.println(currentPlayerName + " is getting out of the penalty box");
				places[currentPlayer] = places[currentPlayer] + roll;
				if (places[currentPlayer] > 11)
					places[currentPlayer] = places[currentPlayer] - 12;

				System.out.println(currentPlayerName + "'s new location is " + places[currentPlayer]);
				System.out.println("The category is " + currentCategory());
				askQuestion();
			} else {
				System.out.println(currentPlayerName + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
			}

		} else {
			places[currentPlayer] = places[currentPlayer] + roll;
			if (places[currentPlayer] > 11)
				places[currentPlayer] = places[currentPlayer] - 12;

			System.out.println(currentPlayerName + "'s new location is " + places[currentPlayer]);
			System.out.println("The category is " + currentCategory());
			askQuestion();
		}

	}

	private void askQuestion() {
		this.questionBox.getQuestionByCategory(this.currentCategory());
	}

	// randomly return a category
	private String currentCategory() {
		int currentPlayer = this.playerRegistry.getCurrentPlayer();
		if (places[currentPlayer] == 0)
			return "Pop";
		if (places[currentPlayer] == 4)
			return "Pop";
		if (places[currentPlayer] == 8)
			return "Pop";
		if (places[currentPlayer] == 1)
			return "Science";
		if (places[currentPlayer] == 5)
			return "Science";
		if (places[currentPlayer] == 9)
			return "Science";
		if (places[currentPlayer] == 2)
			return "Sport";
		if (places[currentPlayer] == 6)
			return "Sport";
		if (places[currentPlayer] == 10)
			return "Sport";
		return "Rock";
	}

	public boolean wasCorrectlyAnswered() {
		String currentPlayerName = this.playerRegistry.getCurrentPlayerName();
		int currentPlayer = this.playerRegistry.getCurrentPlayer();

		if (inPenaltyBox[currentPlayer]) {
			if (isGettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				purses[currentPlayer]++;
				System.out.println(currentPlayerName + " now has " + purses[currentPlayer] + " Gold Coins.");

				boolean winner = didPlayerWin();
				this.playerRegistry.advancePlayer();
				return winner;
			} else {
				this.playerRegistry.advancePlayer();
				return true;
			}

		} else {

			System.out.println("Answer was corrent!!!!");
			purses[currentPlayer]++;
			System.out.println(currentPlayerName + " now has " + purses[currentPlayer] + " Gold Coins.");

			boolean winner = didPlayerWin();
			this.playerRegistry.advancePlayer();
			return winner;

		}
	}

	public boolean wrongAnswer() {
		String currentPlayerName = this.playerRegistry.getCurrentPlayerName();
		int currentPlayer = this.playerRegistry.getCurrentPlayer();
		System.out.println("Question was incorrectly answered");
		System.out.println(currentPlayerName + " was sent to the penalty box");
		inPenaltyBox[currentPlayer] = true;
		this.playerRegistry.advancePlayer();
		return true;
	}

	/**
	 * Tells if the last player won.
	 */
	private boolean didPlayerWin() {
		return !(purses[this.playerRegistry.getCurrentPlayer()] == 6);
	}
}
