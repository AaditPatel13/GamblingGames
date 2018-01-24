package BlackJackGame;
import java.util.ArrayList;
import java.util.Collections;



public class Deck {

	public void createDeck(ArrayList<Card> deck){
		for(Suit suit : Suit.values()){
			for(cVal val : cVal.values()){
				deck.add(new Card(val, suit));
			}
		}
	}
	
	public void shuffle(ArrayList<Card> deck){
		Collections.shuffle(deck);
	}
	
	public void addDeck(ArrayList<Card> deck, int times){
		for(int i = 0; i < times; i++){
			createDeck(deck);
		}
	}
	
	public Card draw(ArrayList<Card> deck){
		return deck.remove(0);
	}
	
	/*public static void main(String[] args){
		ArrayList<Card> bag = new ArrayList<>();
		Deck d1 = new Deck();
		d1.createDeck(bag);
		System.out.println(bag.size());
		System.out.println(bag.get(5).getcVal());
		d1.shuffle(bag);
		System.out.println(bag.get(5).getcVal());
		d1.addDeck(bag, 3);
		System.out.println(bag.size());
		System.out.println(bag.get(0).getcVal());
		System.out.println(d1.draw(bag));
		System.out.println(bag.get(0).getcVal());
		System.out.println(bag.get(0).getcVal().getVal());
	}*/
	
}

