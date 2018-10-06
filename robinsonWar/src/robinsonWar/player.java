package robinsonWar;

import java.util.ArrayList;

public class player {
	//hand 
	private String name;
	private ArrayList <card> playerDeck = new ArrayList<card>();

	private int score = 0;
	 
	private ArrayList <card> winPile = new ArrayList<>();
	
	public player(String name){
		this.name = name;
	}
	
	public void setPlayerDeck(ArrayList<card> playerDeck){
		this.playerDeck = playerDeck;
	}

	public void setName(String str){
		this.name = str;		
	}

	public card drawCard() throws Exception {
	//System.out.println("Player DRAWCARD Deck size is " + playerDeck.size());
		if(playerDeck.size() > 0){
			return playerDeck.remove(0);
		}
		//System.out.println("DRAWCARD: DeckSize less than 0!!!!");
		throw new Exception();
	}//end drawCard()
	
	public void incrementScore(){
		this.score = this.score + 1;
	}
	
	public int getScore(){
		return this.score;
	}
	
	public void addToDeck(card addedCard){
		this.playerDeck.add(addedCard);
	}
	
	public int getDeckSize(){
		return this.playerDeck.size();
	}
	
	public void addToWinPile(card addedCard){
		this.winPile.add(addedCard);
	}
	
	public int getWinPileSize(){
		return winPile.size();
	}
	
	public void clearWinPile(){
		this.winPile.clear();
	}

	public String getName() {
		//System.out.println("Player.getName did trigger!!!");
		return this.name;
	}
}
