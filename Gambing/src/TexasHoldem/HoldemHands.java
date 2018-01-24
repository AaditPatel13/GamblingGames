package TexasHoldem;
import java.util.ArrayList;
import java.util.Collections;
import BlackJackGame.Card;
import BlackJackGame.Suit;
import BlackJackGame.cVal;

public class HoldemHands {
	
	public int getHandValue(ArrayList<cVal> cValArr, ArrayList<Suit> suitArr){
		int score = 0;
		boolean flushobtained = false;
		boolean fullHouseObtained = false;
		boolean twoPairObtained = false;
		if(cValArr.contains(cVal.ACE) && cValArr.contains(cVal.KING) && cValArr.contains(cVal.QUEEN) 
				&& cValArr.contains(cVal.JACK) && cValArr.contains(cVal.TEN)){
			if(getDups(suitArr)){
				//royal flush
				flushobtained = true;
			}
			else{
				//straight
			}
			
		}
		
		if((cValArr.contains(cVal.ACE) && cValArr.contains(cVal.TWO) && cValArr.contains(cVal.THREE) 
				&& cValArr.contains(cVal.FOUR) && cValArr.contains(cVal.FIVE)) || 
			(cValArr.contains(cVal.SIX) && cValArr.contains(cVal.TWO) && cValArr.contains(cVal.THREE) 
				&& cValArr.contains(cVal.FOUR) && cValArr.contains(cVal.FIVE)) || 
			(cValArr.contains(cVal.SIX) && cValArr.contains(cVal.SEVEN) && cValArr.contains(cVal.THREE) 
				&& cValArr.contains(cVal.FOUR) && cValArr.contains(cVal.FIVE)) || 
			(cValArr.contains(cVal.SIX) && cValArr.contains(cVal.SEVEN) && cValArr.contains(cVal.EIGHT) 
				&& cValArr.contains(cVal.FOUR) && cValArr.contains(cVal.FIVE)) || 
			(cValArr.contains(cVal.SIX) && cValArr.contains(cVal.SEVEN) && cValArr.contains(cVal.EIGHT) 
				&& cValArr.contains(cVal.NINE) && cValArr.contains(cVal.FIVE)) ||
			(cValArr.contains(cVal.SIX) && cValArr.contains(cVal.SEVEN) && cValArr.contains(cVal.EIGHT) 
				&& cValArr.contains(cVal.NINE) && cValArr.contains(cVal.TEN))  || 
			(cValArr.contains(cVal.JACK) && cValArr.contains(cVal.SEVEN) && cValArr.contains(cVal.EIGHT) 
				&& cValArr.contains(cVal.NINE) && cValArr.contains(cVal.TEN))  || 
			(cValArr.contains(cVal.JACK) && cValArr.contains(cVal.QUEEN) && cValArr.contains(cVal.EIGHT) 
				&& cValArr.contains(cVal.NINE) && cValArr.contains(cVal.TEN))  ||
			(cValArr.contains(cVal.JACK) && cValArr.contains(cVal.QUEEN) && cValArr.contains(cVal.KING) 
				&& cValArr.contains(cVal.NINE) && cValArr.contains(cVal.TEN))){
				if(getDups(suitArr)){
					//straight flush
					flushobtained = true;
				}
				else{
					//straight
				}
		}
		
		if(getPair(cValArr, 4)){
			//four of a kind
		}
		
		if(getPair(cValArr, 3) && getPair(cValArr, 2)){
			//full house
			fullHouseObtained = true;
		}
		
		if(getDups(suitArr) && flushobtained == false){
			//flush
		}
		
		if(getPair(cValArr, 3) && fullHouseObtained == false){
			//three of a kind
		}
		
		if(twoPair(cValArr)){
			//two pair
			twoPairObtained = true;
		}
		
		if(getPair(cValArr, 2) && twoPairObtained == false){
			//normal Pair
		}
		

				
		return score;
		
	}
	public boolean getDups(ArrayList<Suit> suitArr){
		boolean flush = false;
		int dups = 0;
		int temp = 0;
		for(Suit suitVals : Suit.values()){
			for(Suit suitArrVals : suitArr){
				if(suitVals == suitArrVals){
					temp += 1;
				}
			}
			if(dups < temp){
				dups = temp;
			}
			temp = 0;
		}
		if(dups >= 5){
			flush = true;
		}
		return flush;
	}
	
	public boolean getPair(ArrayList<cVal> cValArr, int pairKind){
		boolean exist = false;
		ArrayList<Integer> pairArr = new ArrayList<>();
		for(cVal vals : cValArr){
			pairArr.add(Collections.frequency(cValArr, vals));
		}
		if(pairArr.contains(pairKind)){
			exist = true;
		}
		return exist;
	}
	
	public boolean twoPair(ArrayList<cVal> cValArr){
		boolean exist = false;
		ArrayList<Integer> pairArr = new ArrayList<>();
		for(cVal vals : cValArr){
			pairArr.add(Collections.frequency(cValArr, vals));
		}
		if(Collections.frequency(pairArr, 2) >= 2){
			exist = true;
		}
		return exist;
	}


	public static void main(String[] args){
		ArrayList<cVal> bag = new ArrayList<>();
		Card c = new Card(cVal.ACE, Suit.HEART);
		bag.add(c.getcVal());
		bag.add(c.getcVal());
		bag.add(c.getcVal());
		bag.add(c.getcVal());
		bag.add(cVal.EIGHT);
		bag.add(cVal.NINE);
		bag.add(cVal.EIGHT);
		bag.add(cVal.SEVEN);


	}

}



