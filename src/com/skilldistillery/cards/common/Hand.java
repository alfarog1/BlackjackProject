package com.skilldistillery.cards.common;

import java.util.List;

public abstract class Hand {

	public Hand() {
		super();
		
	}
	
	public int getHandValue() {
		return 0;
	}
	
	public void addCard(Card card) {
		
	}
	public void clearHand() {
		
	}
	
	public List<Card> getCards() {
		return null;
		
	}

	@Override
	public String toString() {
		return "Hand []";
	}
	
	
		

}
