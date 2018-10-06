package robinsonWar;

import java.util.ArrayList;

/*
 * THIS game uses a Win Pile. Won cards are placed in a player's win pile.
 * At the end of the game, player with the largest Win Pile wins the game.
 */
public class pointsPileGame extends warGame {
	//two players here. 
	private card faceDownCardP1;
	private card faceUpCardP1;
	
	private card faceDownCardP2;
	private card faceUpCardP2;
	
	private ArrayList <card> tiedCards = new ArrayList<>();
	
	private int roundWinner = -1;

	public pointsPileGame() {
		//super(player1, player2, deck);
		// TODO Auto-generated constructor stub
		super(player1, player2, deck);
	}
	
	public void playGame() throws Exception
	{
		setTwoPlayerNames("Kyle", "Sarah");
		drawDeckForTwoPlayer();
		System.out.println("Start Game: -----------------------");
		//30 was max rounds allowed.
		for(int j = 0; j < 30; j++)
		{
			if(player1.getDeckSize() == 0 || player2.getDeckSize() == 0)
				break;
			
			try{
				playRound();
			}catch(Exception e){
				System.exit(0); 
			}
		}
		printFinalWinPileForTwo();
	}//end playGame()
	
	private void playRound() throws Exception
	{
		drawInitalCards();
		if(faceUpCardP1.getRank() > faceUpCardP2.getRank() ){
			player1.addToWinPile(this.faceUpCardP1);
			player1.addToWinPile(this.faceUpCardP2); //Win player takes both cards
			System.out.println("Player 1 won");
		}else if(faceUpCardP1.getRank() < faceUpCardP2.getRank() ){
			player2.addToWinPile(this.faceUpCardP1);
			player2.addToWinPile(this.faceUpCardP2); //Win player takes both cards
			System.out.println("Player 2 won");
		}else if(faceUpCardP1.getRank() == faceUpCardP2.getRank()){
			System.out.println("War!");
			//add both player cards to tiedCards arrayList / pile.
			tiedCards.add(faceUpCardP1);
			tiedCards.add(faceUpCardP2);
			tiedRound();
			addTiedCardsToPlayerWP(roundWinner);
			tiedCards.clear(); //clear that pile. 
		}
	
	}//END  
	
	private void drawInitalCards() throws Exception
	{
		try{
			this.faceUpCardP1 = player1.drawCard();	
			this.faceUpCardP2 = player2.drawCard();
			//FORMAT OUTPUT: Bob plays EIGHT of DIAMONDS
			System.out.println(player1.getName()+" plays " + this.faceUpCardP1 + " as up card");
			System.out.println(player2.getName()+" plays " + this.faceUpCardP2 + " as up card");
		}catch(Exception e){
			throw e;
		}
	}
	
	private void tiedRound() throws Exception{	
		try{
			faceDownCardP1 = player1.drawCard();
			faceUpCardP1 = player1.drawCard();
			faceDownCardP2 = player2.drawCard();
			faceUpCardP2 = player2.drawCard();
		}catch(Exception e){
			System.out.println("Player decks are empty. Game will now end");
			printFinalWinPileForTwo();
			throw new Exception();
		}
		if(faceUpCardP1.getRank() > faceUpCardP2.getRank() ){
			addCardsToTiedPile(faceDownCardP1, faceUpCardP1, faceDownCardP2, faceUpCardP2);
			roundWinner = 1;
		}else if(faceUpCardP1.getRank() < faceUpCardP2.getRank() ){
			addCardsToTiedPile(faceDownCardP1, faceUpCardP1, faceDownCardP2, faceUpCardP2);
			roundWinner = 2;
		}else if(faceUpCardP1.getRank() == faceUpCardP2.getRank()){
			addCardsToTiedPile(faceDownCardP1, faceUpCardP1, faceDownCardP2, faceUpCardP2);
			tiedRound();
		}		
}
	
	//WILL USE for tied rounds later. 
	private void addCardsToTiedPile(card card1, card card2, card card3, card card4){
		tiedCards.add(card1);
		tiedCards.add(card2);
		tiedCards.add(card3);
		tiedCards.add(card4);	
	}
	
	
	private void addTiedCardsToPlayerWP(int wonPlayer){
		if(tiedCards.size() > 0){
			givePlayerTheirWinnings(wonPlayer);
		}
	}
	
	private void givePlayerTheirWinnings(int wonPlayer){
		if(wonPlayer == 1){
			for(int i = 0; i < tiedCards.size(); i++)
				player1.addToWinPile(tiedCards.get(i));
			
		}
		if(wonPlayer == 2){
			for(int i = 0; i < tiedCards.size(); i++)
				player2.addToWinPile(tiedCards.get(i)); 	
		}	
	}
	
	public void printFinalWinPileForTwo()
	{
		System.out.println("************** END GAME: ******************************");
		System.out.println("Player 1: Win Pile size is " + player1.getWinPileSize());
		System.out.println("Player 2: Win Pile size is " + player2.getWinPileSize());
		if(player1.getWinPileSize() > player2.getWinPileSize()){
			System.out.println("Player 1: "  + player1.getName() + " has won the game!");
		}else if(player1.getWinPileSize() < player2.getWinPileSize()){
			System.out.println("Player 2: " + player2.getName() + " has won the game!");
		}
		else
			System.out.println("Game has ended in a tie. Max rounds played.");
		System.out.println("************** END GAME: ******************************");
	}
	
}
