package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;

public class PlayerRegistry {

	private ArrayList<Player> players = new ArrayList<Player>();
	private int currentPlayer = 0;

	public Player addPlayer(String playerName) {
		Player player = new Player(this.players.size(), playerName);
		this.players.add(player);
		return player;
	}

	public Player getCurrentPlayer() {
		return this.players.get(this.currentPlayer);
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
