package com.skilldistillery.cards.common;



public class Dealer {
	Deck deck;
	Hand hand;
	
	public Dealer() {
		deck = new Deck();
		hand = new BlackjackHand();
	}
	
	public Card deal() {
		if(deck.checkDeckSize() < 15) {
			deck = new Deck();
		}
	Card card = deck.dealCard();
	return card;
		
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public Hand getHand() {
		
		return hand;
	}
	
	public Card showFaceUp() {
		return hand.getCards().get(0);
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	

	
}
