package com.adaptionsoft.games.uglytrivia;

public class Game {

	private QuestionBox questionBox;
	private PlayerRegistry playerRegistry;
	private Board board;

	private int[] purses = new int[6];
	private boolean[] inPenaltyBox = new boolean[6];
	private boolean isGettingOutOfPenaltyBox;

	public Game(QuestionBox questionBox, PlayerRegistry playerRegistry, Board board) {
		this.questionBox = questionBox;
		this.playerRegistry = playerRegistry;
		this.board = board;
	}

	public boolean add(String playerName) {
		this.playerRegistry.addPlayer(playerName);
		int numberOfPlayers = this.playerRegistry.numberOfPlayers();

		this.board.initPlayerInBoard(numberOfPlayers);
		purses[numberOfPlayers] = 0;
		inPenaltyBox[numberOfPlayers] = false;
		System.out.println(playerName + " was added");
		System.out.println("They are player number " + numberOfPlayers);
		return true;
	}

	public void roll(int roll) {
		String currentPlayerName = this.playerRegistry.getCurrentPlayerName();
		int currentPlayer = this.playerRegistry.getCurrentPlayer();
		int newPosition = 0;
		System.out.println(currentPlayerName + " is the current player");
		System.out.println("They have rolled a " + roll);

		if (inPenaltyBox[currentPlayer]) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;

				System.out.println(currentPlayerName + " is getting out of the penalty box");
				newPosition = this.board.movePlayerInBoard(currentPlayer, roll);

				System.out.println(currentPlayerName + "'s new location is " + newPosition);
				System.out.println("The category is " + currentCategory());
				askQuestion();
			} else {
				System.out.println(currentPlayerName + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
			}

		} else {
			newPosition = this.board.movePlayerInBoard(currentPlayer, roll);
			System.out.println(currentPlayerName + "'s new location is " + newPosition);
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
		return this.board.getCategoryByPlayerPosition(currentPlayer);
	}

	public boolean wasCorrectlyAnswered() {
		String currentPlayerName = this.playerRegistry.getCurrentPlayerName();
		int currentPlayer = this.playerRegistry.getCurrentPlayer();
		boolean resultOfAnswer = false;
		if (inPenaltyBox[currentPlayer]) {
			if (isGettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				purses[currentPlayer]++;
				System.out.println(currentPlayerName + " now has " + purses[currentPlayer] + " Gold Coins.");
				resultOfAnswer = didPlayerWin();
			} else {
				resultOfAnswer = true;
			}

		} else {

			System.out.println("Answer was corrent!!!!");
			purses[currentPlayer]++;
			System.out.println(currentPlayerName + " now has " + purses[currentPlayer] + " Gold Coins.");
			resultOfAnswer = didPlayerWin();
		}
		this.playerRegistry.advancePlayer();
		return resultOfAnswer;
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
