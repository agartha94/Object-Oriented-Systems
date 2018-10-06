package robinsonWar;

import java.util.ArrayList;

public abstract class warGame {
	//Why not have an array or list of players so the number can vary
	public static player player1;
	public static player player2;
	private ArrayList <card> tiedCards = new ArrayList<card>();
	protected static deckOfCards deck;
	
	//This is creating its own standard deck and players so i'm unable to test variations of validity of player1, player2, and deck
	//without changing the code
	//Why not pass in a populated array of players and a populated deck?
	//That way we can determine the number of players and the deck type before we choose what type of war game to play
	public warGame(player player1, player player2, deckOfCards deck) {
		// why pass in players as arguments since the child classes already own them?
		this.player1 = new player("Clay");
		this.player2 = new player("Bob");
		//Also why pass in a deck for the same reason?
		this.deck = new deckOfCards();
	}
	
	//If the players were stored in an array we would need to only call the drawDeck function instead of drawDeckForTwoPlayers, drawDeckForThreePlayers
	//This is not supportive of the polymorphism paradigm
	public void drawDeckForTwoPlayer(){
		deck.createDeck();
		//Suggest explicitly shuffling the deck at this point otherwise why have a shuffle function at all?
		player1.setPlayerDeck(deck.getPlayerDeck()); //player1 has 26 cards.
		player2.setPlayerDeck(deck.getPlayerDeck()); //player2 has 26 cards.	
		//need two hands. One for each player. Winpile?
	}
	
	//See note above 
	//This is not supportive of the polymorphism paradigm
	public void drawDeckForThreePlayer(){
		deck.createDeck();
		System.out.println("Did it create 3-Player Deck?");
		
		player1.setPlayerDeck(deck.getThreePlayerDeck()); //player1 has 17 cards.
		player2.setPlayerDeck(deck.getThreePlayerDeck()); //player2 has 17 cards.	
		
	}
	//This is not supportive of the polymorphism paradigm
	public void setTwoPlayerNames(String str1, String str2) {
		player1.setName(str1);
		player2.setName(str2);
	}
	//This is not supportive of the polymorphism paradigm
	public void printFinalScoresForTwo()
	{
		System.out.println("************** END GAME: ******************************");
		System.out.println("Player 1: hand size is " + player1.getDeckSize());
		System.out.println("Player 2: hand size is " + player2.getDeckSize());
		if(player1.getDeckSize() > player2.getDeckSize()){
			System.out.println("Player 1: "  + player1.getName() + " has won the game!");
		}else if(player1.getDeckSize() < player2.getDeckSize()){
			System.out.println("Player 2: " + player2.getName() + " has won the game!");
		}
		else
			System.out.println("Game has ended in a tie. Max rounds played.");
		System.out.println("************** END GAME: ******************************");
	}
}
