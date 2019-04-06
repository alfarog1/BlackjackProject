package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
List<Card> cards = new ArrayList<>();
	public Hand() {
		super();
		
	}
	
	public int getHandValue() {
		int c = 0;
		for (Card card : cards) {
			c += card.getValue();
		}
		return c;
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	public void clearHand() {
		cards = new ArrayList<>();
		
	}
	
	public List<Card> getCards() {
		
		return cards;
		
	}

	@Override
	public String toString() {
		return " 🂠 " + cards + " 🂠 " ;
	}

	
	
	
		

}
