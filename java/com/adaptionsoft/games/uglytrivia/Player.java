package com.adaptionsoft.games.uglytrivia;

public class Player {

	private int id;
	private String name;
	private int purse;

	public Player(int id, String playerName) {
		this.id = id;
		this.name = playerName;
		purse = 0;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int addPurse() {
		return ++this.purse;
	}

}
