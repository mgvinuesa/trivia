package com.adaptionsoft.games.uglytrivia;

public class Game {

	private QuestionBox questionBox;
	private PlayerRegistry playerRegistry;
	private Board board;

	public Game(QuestionBox questionBox, PlayerRegistry playerRegistry, Board board) {
		this.questionBox = questionBox;
		this.playerRegistry = playerRegistry;
		this.board = board;
	}

	public boolean add(String playerName) {
		Player player = this.playerRegistry.addPlayer(playerName);
		this.board.initPlayerInBoard(player.getId());
		System.out.println(playerName + " was added");
		System.out.println("They are player number " + this.playerRegistry.numberOfPlayers());
		return true;
	}

	public boolean roll(int roll) {
		boolean gettingOutOfPenaltyBox = false;
		Player player = this.playerRegistry.getCurrentPlayer();
		String currentPlayerName = player.getName();
		int currentPlayerId = player.getId();
		int newPosition = 0;
		System.out.println(currentPlayerName + " is the current player");
		System.out.println("They have rolled a " + roll);

		if (this.board.isInPenaltyBox(currentPlayerId)) {

			if (roll % 2 != 0) {
				gettingOutOfPenaltyBox = true;
				System.out.println(currentPlayerName + " is getting out of the penalty box");
				newPosition = this.board.movePlayerInBoard(currentPlayerId, roll);

				System.out.println(currentPlayerName + "'s new location is " + newPosition);
				System.out.println("The category is " + currentCategory());
				askQuestion();
			} else {
				System.out.println(currentPlayerName + " is not getting out of the penalty box");
				gettingOutOfPenaltyBox = false;
			}

		} else {
			newPosition = this.board.movePlayerInBoard(currentPlayerId, roll);
			System.out.println(currentPlayerName + "'s new location is " + newPosition);
			System.out.println("The category is " + currentCategory());
			askQuestion();
		}
		return gettingOutOfPenaltyBox;

	}

	private void askQuestion() {
		this.questionBox.getQuestionByCategory(this.currentCategory());
	}

	// randomly return a category
	private String currentCategory() {
		int currentPlayer = this.playerRegistry.getCurrentPlayer().getId();
		return this.board.getCategoryByPlayerPosition(currentPlayer);
	}

	public boolean wasCorrectlyAnswered(boolean gettingOutOfPenaltyBox) {
		Player player = this.playerRegistry.getCurrentPlayer();
		String currentPlayerName = player.getName();
		int currentPlayerId = player.getId();
		boolean resultOfAnswer = false;
		if (this.board.isInPenaltyBox(currentPlayerId)) {
			if (gettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				int currentPurses = player.addPurse();
				System.out.println(currentPlayerName + " now has " + currentPurses + " Gold Coins.");
				resultOfAnswer = didPlayerWin();
			} else {
				resultOfAnswer = true;
			}

		} else {
			System.out.println("Answer was corrent!!!!");
			int currentPurses = player.addPurse();
			System.out.println(currentPlayerName + " now has " + currentPurses + " Gold Coins.");
			resultOfAnswer = didPlayerWin();
		}
		this.playerRegistry.advancePlayer();
		return resultOfAnswer;
	}

	public boolean wrongAnswer() {
		Player player = this.playerRegistry.getCurrentPlayer();
		String currentPlayerName = player.getName();
		int currentPlayerId = player.getId();
		System.out.println("Question was incorrectly answered");
		System.out.println(currentPlayerName + " was sent to the penalty box");
		this.board.setPlayerToPenalyBox(currentPlayerId);
		this.playerRegistry.advancePlayer();
		return true;
	}

	/**
	 * Tells if the last player won.
	 */
	private boolean didPlayerWin() {
		return !(this.playerRegistry.getCurrentPlayer().getPurse() == 6);
	}
}
