package robinsonWar;

import java.util.ArrayList;
public class basicWarGame extends warGame {
	//two players here. 
	private card faceDownCardP1;
	private card faceUpCardP1;
	
	private card faceDownCardP2;
	private card faceUpCardP2;
	
	private ArrayList <card> tiedCards = new ArrayList<>();
	
	private int roundWinner = -1;
	
	public basicWarGame() {
		super(player1, player2, deck);
	}
	public void playGame() throws Exception{
		setTwoPlayerNames("Bob", "Joe");
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
				printErrorGameEND();
				System.exit(0); 
			}
		}
		printFinalScoresForTwo();
	}
	
	private void playRound() throws Exception
	{
		drawInitalCards(); 
		if(faceUpCardP1.getRank() > faceUpCardP2.getRank() ){
			player1.addToDeck(this.faceUpCardP1);
			player1.addToDeck(this.faceUpCardP2); //Win player takes both cards
			
		}else if(faceUpCardP1.getRank() < faceUpCardP2.getRank() ){
			player2.addToDeck(this.faceUpCardP1);
			player2.addToDeck(this.faceUpCardP2); //Win player takes both cards
		}else if(faceUpCardP1.getRank() == faceUpCardP2.getRank()){
			System.out.println("War!");
			tiedCards.add(faceUpCardP1);
			tiedCards.add(faceUpCardP2);
			tiedRound();
			addTiedCardsToPlayer(roundWinner);
			tiedCards.clear(); //clear that pile. 
		}
	}
	
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
			//Now, both players draw two card and compare second card.
			try{
				faceDownCardP1 = player1.drawCard();
				faceUpCardP1 = player1.drawCard();
				faceDownCardP2 = player2.drawCard();
				faceUpCardP2 = player2.drawCard();
			}catch(Exception e){
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
	
	private void addCardsToTiedPile(card card1, card card2, card card3, card card4){
		tiedCards.add(card1);
		tiedCards.add(card2);
		tiedCards.add(card3);
		tiedCards.add(card4);	
	}
	
	private void addTiedCardsToPlayer(int wonPlayer){
		if(tiedCards.size() > 0){
			givePlayerTheirWinnings(wonPlayer);
		}
	}
	
	private void givePlayerTheirWinnings(int wonPlayer){
		if(wonPlayer == 1){
			for(int i = 0; i < tiedCards.size(); i++)
				player1.addToDeck(tiedCards.get(i)); 
			
		}
		if(wonPlayer == 2){
			for(int i = 0; i < tiedCards.size(); i++)
				player2.addToDeck(tiedCards.get(i)); 	
		}	
	}
	
	private void printErrorGameEND(){
		System.out.println("Hi there. ERROR handled.");
		System.out.println("----------------------------------------");
		System.out.println("TiedCards size is : " + tiedCards.size());
		System.out.println("----------------------------------------");
	}

}