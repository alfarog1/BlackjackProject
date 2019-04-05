package com.skilldistillery.cards.common;

public class Player {
	Hand hand;

	public Hand getHand() {
		
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public Player() {
		hand = new BlackjackHand();
	}
	public Card showFaceUp() {
		return hand.getCards().get(0);
	}
}
