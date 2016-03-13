package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;

public class PlayerRegistry {

	private ArrayList<String> players = new ArrayList<String>();
	private int currentPlayer = 0;

	public int addPlayer(String playerName) {
		this.players.add(playerName);
		return this.players.size();
	}

	public String getCurrentPlayerName() {
		return this.players.get(this.currentPlayer);
	}

	public int getCurrentPlayer() {
		return this.currentPlayer;
	}

	public int numberOfPlayers() {
		return this.players.size();
	}

	public void advancePlayer() {
		this.currentPlayer++;
		if (this.currentPlayer == this.numberOfPlayers())
			this.currentPlayer = 0;
	}
}
