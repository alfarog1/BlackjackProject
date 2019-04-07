package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Hand;

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
