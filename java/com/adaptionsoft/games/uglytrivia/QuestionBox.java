package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class QuestionBox {

	private LinkedList<String> popQuestions = new LinkedList<String>();
	private LinkedList<String> scienceQuestions = new LinkedList<String>();
	private LinkedList<String> sportsQuestions = new LinkedList<String>();
	private LinkedList<String> rockQuestions = new LinkedList<String>();

	public QuestionBox() {
		for (int i = 0; i < 50; i++) {
			popQuestions.addLast("Pop Question " + i);
			scienceQuestions.addLast("Science Question " + i);
			sportsQuestions.addLast("Sport Question " + i);
			rockQuestions.addLast("Rock Question " + i);
		}
	}

	public void getQuestionByCategory(String category) {
		if ("Pop".equals(category))
			System.out.println(popQuestions.removeFirst());
		if ("Science".equals(category))
			System.out.println(scienceQuestions.removeFirst());
		if ("Sport".equals(category))
			System.out.println(sportsQuestions.removeFirst());
		if ("Rock".equals(category))
			System.out.println(rockQuestions.removeFirst());
	}
}
