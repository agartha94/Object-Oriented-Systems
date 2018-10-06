package robinsonWar;

import java.util.ArrayList;
import java.util.Collections;

public class deckOfCards {
						//SPADES, HEARTS, CLUBS, DIAMONDS
	public int cardSuit[] = {0, 1, 2, 3};
	public int cardRank[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}; 
	
	public ArrayList <card> deck = new ArrayList<>(52);
	public deckOfCards() {
		//constructors 
	}
	
	public void createDeck()
	{
		int i,j;
		for(i = 0; i< this.cardSuit.length; i++){
			for(j = 0; j<this.cardRank.length; j++){ 
				//	public card(int rank, int suite)
				card newCard = new card(cardRank[j] ,cardSuit[i]);
				deck.add(newCard); 
			
			}
		}//end nested for loops. 
		//We should only shuffle when we explicitly want to 
		this.shuffleDeck();
	}//end createDeck.
	
	public void shuffleDeck(){
		Collections.shuffle(deck);
	}
	
	public void toString(card printCard){
		printCard.toString();
	}
	
	public ArrayList<card> getDeck(){
		return deck;
	}
	
	public card getPlayerCard()
	{
		if( this.deck.size() > 0){
			card pCard = deck.remove(0);
			return pCard;
		}else{
			card blankCard = new card(-1, -1);
			System.out.println("ERROR: bad card.\n");
			return blankCard; 
		}
	}
	
	public ArrayList<card> getPlayerDeck(){
		ArrayList<card> playerDeck = new ArrayList<card>();
		for(int i = 0; i < 26; i++){
			playerDeck.add(this.getPlayerCard());
		}
		return playerDeck;
	}
	
	//special for 3-player verison of the game
	public ArrayList<card> getThreePlayerDeck(){
		ArrayList<card> playerDeck = new ArrayList<card>();
		for(int i = 0; i < 17; i++){
			playerDeck.add(this.getPlayerCard());
		}
		return playerDeck;
	}
	
	public int getSize(){
		return this.deck.size();
	}
	
}

