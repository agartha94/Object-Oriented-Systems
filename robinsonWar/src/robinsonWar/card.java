package robinsonWar;

public class card {
	private int rank;
	private int suit;
	private String NumEng[] = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT"
			, "NINE", "TEN"};
	public card(int rank, int suit) {
		super();
		this.rank = rank;
		this.suit = suit;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getSuit() {
		return suit;
	}
	public void setSuit(int suit) {
		this.suit = suit;
	} 
	
	public String toString(){
		/*
		System.out.println("card.toString() triggered!!!!!");
		System.out.println("    rank " + this.rank);
		System.out.println("    suit " + this.suit);
		*/
		StringBuilder displayedCard = new StringBuilder(); //nice little string. 
		printRank(displayedCard);
		displayedCard.append(" of "); //setting the format of the output
		printSuit(displayedCard);
		return displayedCard.toString(); 
	}
	
	
	public void printRank(StringBuilder displayedCard)
	{
		switch(rank){
	        case 11:
	            displayedCard.append("JACK");
	            break;
	        case 12:
	            displayedCard.append("QUEEN");
	            break;
	        case 13:
	            displayedCard.append("KING");
	            break;
	        case 14:
	            displayedCard.append("ACE");
	            break;
	        default:
	        	int p = rank; 
	        	//System.out.println("Default rank reached! ");
	        	//System.out.println("What is this element : " + NumEng[p]);
	        	displayedCard.append("" + NumEng[p]);
	            break; 
	      }
	}
	
	public void printSuit(StringBuilder displayedCard)
	{
		//EVERYTHING is spades? Why?
        switch(suit){
	        case 0:
	            displayedCard.append("SPADES");
	            break;
	        case 1:
	            displayedCard.append("HEARTS");
	            break;
	        case 2:
	            displayedCard.append("CLUBS");
	            break;
	        case 3:
	            displayedCard.append("DIAMONDS");
	            break;
	        default: //anything else, do nothing
	            break;
	    }//end suit switch
	}
	

}
