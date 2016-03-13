package com.adaptionsoft.games.trivia.runner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameRunnerTest {
	
	private static final String EXPECTED_RESULT = "Chet was added\r\n" + "They are player number 1\r\n"
			+ "Pat was added\r\n" + "They are player number 2\r\n" + "Sue was added\r\n"
			+ "They are player number 3\r\n" + "Chet is the current player\r\n" + "They have rolled a 5\r\n"
			+ "Chet's new location is 5\r\n" + "The category is Science\r\n" + "Science Question 0\r\n"
			+ "Answer was corrent!!!!\r\n" + "Chet now has 1 Gold Coins.\r\n" + "Pat is the current player\r\n"
			+ "They have rolled a 1\r\n" + "Pat's new location is 1\r\n" + "The category is Science\r\n"
			+ "Science Question 1\r\n" + "Question was incorrectly answered\r\n" + "Pat was sent to the penalty box\r\n"
			+ "Sue is the current player\r\n" + "They have rolled a 4\r\n" + "Sue's new location is 4\r\n"
			+ "The category is Pop\r\n" + "Pop Question 0\r\n" + "Answer was corrent!!!!\r\n"
			+ "Sue now has 1 Gold Coins.\r\n" + "Chet is the current player\r\n" + "They have rolled a 5\r\n"
			+ "Chet's new location is 10\r\n" + "The category is Sport\r\n" + "Sport Question 0\r\n"
			+ "Question was incorrectly answered\r\n" + "Chet was sent to the penalty box\r\n"
			+ "Pat is the current player\r\n" + "They have rolled a 5\r\n" + "Pat is getting out of the penalty box\r\n"
			+ "Pat's new location is 6\r\n" + "The category is Sport\r\n" + "Sport Question 1\r\n"
			+ "Answer was correct!!!!\r\n" + "Pat now has 1 Gold Coins.\r\n" + "Sue is the current player\r\n"
			+ "They have rolled a 1\r\n" + "Sue's new location is 5\r\n" + "The category is Science\r\n"
			+ "Science Question 2\r\n" + "Answer was corrent!!!!\r\n" + "Sue now has 2 Gold Coins.\r\n"
			+ "Chet is the current player\r\n" + "They have rolled a 3\r\n"
			+ "Chet is getting out of the penalty box\r\n" + "Chet's new location is 1\r\n"
			+ "The category is Science\r\n" + "Science Question 3\r\n" + "Answer was correct!!!!\r\n"
			+ "Chet now has 2 Gold Coins.\r\n" + "Pat is the current player\r\n" + "They have rolled a 2\r\n"
			+ "Pat is not getting out of the penalty box\r\n" + "Sue is the current player\r\n"
			+ "They have rolled a 2\r\n" + "Sue's new location is 7\r\n" + "The category is Rock\r\n"
			+ "Rock Question 0\r\n" + "Answer was corrent!!!!\r\n" + "Sue now has 3 Gold Coins.\r\n"
			+ "Chet is the current player\r\n" + "They have rolled a 2\r\n"
			+ "Chet is not getting out of the penalty box\r\n" + "Pat is the current player\r\n"
			+ "They have rolled a 2\r\n" + "Pat is not getting out of the penalty box\r\n"
			+ "Sue is the current player\r\n" + "They have rolled a 1\r\n" + "Sue's new location is 8\r\n"
			+ "The category is Pop\r\n" + "Pop Question 1\r\n" + "Answer was corrent!!!!\r\n"
			+ "Sue now has 4 Gold Coins.\r\n" + "Chet is the current player\r\n" + "They have rolled a 4\r\n"
			+ "Chet is not getting out of the penalty box\r\n" + "Pat is the current player\r\n"
			+ "They have rolled a 3\r\n" + "Pat is getting out of the penalty box\r\n" + "Pat's new location is 9\r\n"
			+ "The category is Science\r\n" + "Science Question 4\r\n" + "Answer was correct!!!!\r\n"
			+ "Pat now has 2 Gold Coins.\r\n" + "Sue is the current player\r\n" + "They have rolled a 2\r\n"
			+ "Sue's new location is 10\r\n" + "The category is Sport\r\n" + "Sport Question 2\r\n"
			+ "Answer was corrent!!!!\r\n" + "Sue now has 5 Gold Coins.\r\n" + "Chet is the current player\r\n"
			+ "They have rolled a 4\r\n" + "Chet is not getting out of the penalty box\r\n"
			+ "Pat is the current player\r\n" + "They have rolled a 3\r\n" + "Pat is getting out of the penalty box\r\n"
			+ "Pat's new location is 0\r\n" + "The category is Pop\r\n" + "Pop Question 2\r\n"
			+ "Answer was correct!!!!\r\n" + "Pat now has 3 Gold Coins.\r\n" + "Sue is the current player\r\n"
			+ "They have rolled a 3\r\n" + "Sue's new location is 1\r\n" + "The category is Science\r\n"
			+ "Science Question 5\r\n" + "Answer was corrent!!!!\r\n" + "Sue now has 6 Gold Coins.\r\n" + "";
	
	private PrintStream sysOutPrintStream;
	private ByteArrayOutputStream baos;
	
	@Before
	public void setUp() throws Exception {
		sysOutPrintStream = System.out;
		
		baos = new ByteArrayOutputStream();
		PrintStream currentPrintStream = new PrintStream(baos);
		System.setOut(currentPrintStream);
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(sysOutPrintStream);
	}

	@Test
	public void testRun() {
		List<String> players = new ArrayList<String>();
		players.add("Chet");
		players.add("Pat");
		players.add("Sue");

		GameRunner gameRunner = new GameRunner();
		gameRunner.runWithSeed(3, players);
		Assert.assertEquals(EXPECTED_RESULT, baos.toString());
		
	}

}
