package BlackJackGame;
public class Card {
	
	private Suit suit; 
	private cVal val;
	
	
	public Card(cVal val, Suit suit){
		this.val = val;
		this.suit = suit;
	}
	public Suit getSuit(){
		return suit;
	}
	
	public cVal getcVal(){
		return val;
	}


}
