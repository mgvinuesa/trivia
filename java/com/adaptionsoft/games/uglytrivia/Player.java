package com.adaptionsoft.games.uglytrivia;

public class Player {

	private String name;
	private int purse;

	public Player(String playerName) {
		this.name = playerName;
		purse = 0;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPurse() {
		return purse;
	}

	public void setPurse(int purse) {
		this.purse = purse;
	}

}
