package testCardGame;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import robinsonWar.basicWarGame;
import robinsonWar.warGame;

public class basicWarGameTest {
	private static Logger logger = LogManager.getLogger();
	private basicWarGame testGame;
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBasicWarGame() throws Exception {
		logger.info("Running: testBasicWarGame");
		testGame = new basicWarGame();
	}

	@Test
	public void testPlayGame() throws Exception {
		logger.info("Running: testPlayGame");
		testGame = new basicWarGame();
		testGame.playGame();
	}

	@Test
	public void testDrawDeckForTwoPlayer() {
		logger.info("Running: testDrawDeckForTwoPlayer");
		testGame = new basicWarGame();
		testGame.drawDeckForTwoPlayer();
	}

	@Test
	public void testSetTwoPlayerNames() {
		logger.info("Running: testSetTwoPlayerNames");
		String testName1 = "Test1";
		String testName2 = "Test2";
		testGame = new basicWarGame();
		testGame.setTwoPlayerNames(testName1, testName2);
	}

	@Test
	public void testPrintFinalScoresForTwo() throws Exception {
		logger.info("Running: testPrintFinalScoresForTwo");
		testGame = new basicWarGame();
		testGame.printFinalScoresForTwo();
	}

}
