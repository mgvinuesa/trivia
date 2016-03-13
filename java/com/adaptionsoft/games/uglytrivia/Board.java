package com.adaptionsoft.games.uglytrivia;

public class Board {

	private int[] places = new int[6];

	public void initPlayerInBoard(int playerNumber) {
		places[playerNumber] = 0;
	}

	public int getPlayerPositionInBoard(int playerNumber) {
		return this.places[playerNumber];
	}

	public int movePlayerInBoard(int playerNumber, int positions) {
		this.places[playerNumber] = this.places[playerNumber] + positions;
		if (this.places[playerNumber] > 11)
			this.places[playerNumber] = this.places[playerNumber] - 12;
		return this.places[playerNumber];

	}

	public String getCategoryByPlayerPosition(int currentPlayer) {
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

}
