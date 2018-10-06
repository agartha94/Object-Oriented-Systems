package testCardGame;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import robinsonWar.basicWarGame;
import robinsonWar.pointsPileGame;

public class pointsPileGameTest {
	private static Logger logger = LogManager.getLogger();
	private pointsPileGame testGame;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPointsPileGame() {
		logger.info("Running: testPointsPileGame");
		testGame = new pointsPileGame();
	}

	@Test
	public void testPlayGame() throws Exception {
		logger.info("Running: testPlayGame");
		testGame = new pointsPileGame();
		testGame.playGame();
	}

	@Test
	public void testPrintFinalWinPileForTwo() throws Exception {
		logger.info("Running: testPrintFinalWinPileForTwo");
		testGame = new pointsPileGame();
		testGame.playGame();
		testGame.printFinalWinPileForTwo();
	}
	
	@Test
	public void testDrawDeckForTwoPlayer() {
		logger.info("Running: testDrawDeckForTwoPlayer");
		testGame = new pointsPileGame();
		testGame.drawDeckForTwoPlayer();
	}

	@Test
	public void testSetTwoPlayerNames() {
		logger.info("Running: testSetTwoPlayerNames");
		String testName1 = "Test1";
		String testName2 = "Test2";
		testGame = new pointsPileGame();
		testGame.setTwoPlayerNames(testName1, testName2);
	}

	@Test
	public void testPrintFinalScoresForTwo() throws Exception {
		logger.info("Running: testPrintFinalScoresForTwo");
		testGame = new pointsPileGame();
		testGame.printFinalScoresForTwo();
	}

}
