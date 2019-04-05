package com.skilldistillery.cards.common;

import java.util.Scanner;

public class BlackjackApp {
	Player mav = new Player();
	Dealer bob = new Dealer();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		BlackjackApp bj = new BlackjackApp();
		System.out.print("Welcome to the Blackjack Table\n\n");
		bj.run();
		
			

	}

		public void run() {

//			//Cards dealt to player
//			mav.getHand().addCard(bob.deal());
//			//show player their cards
//			
//			bob.getHand().addCard(bob.deal());
//			bob.getHand().addCard(bob.deal());
//			System.out.println(bob.getHand().getCards().toString());
//
//			System.out.println(bob.getHand().getHandValue());
//			System.out.println(bob.showFaceUp());
//			System.out.println("Mav " + mav.getHand().getHandValue());
//			System.out.println("Mav " + mav.showFaceUp());
			cardBattle();
			
			
			sc.close();
		
		}
		
		public void cardBattle() {
			int choice
			//Deal dealers cards
			bob.getHand().addCard(bob.deal());
			bob.getHand().addCard(bob.deal());
			System.out.println(bob.getHand().getCards().toString());
			System.out.println("Dealer " + bob.getHand().getHandValue()+"\n\n");
			
			//Deal two cards to player
			mav.getHand().addCard(bob.deal());
			mav.getHand().addCard(bob.deal());
			//Show their cards and total sum
			System.out.println(mav.getHand().getCards().toString());
			System.out.println("Player has  " + mav.getHand().getHandValue());
			
			
			if ((mav.getHand().getHandValue()) < 21) {
				
			}
			
			//if the dealer has less than 17 dealer hits until dealer is over 17
			if((bob.getHand().getHandValue()) < 17){
				for (int i = 0; i < 17 ; ) {
					bob.getHand().addCard(bob.deal());
					i = bob.getHand().getHandValue();
				}
			System.out.println("Dealer " + bob.getHand().getHandValue() + "\n\n");					
					
			}
					
			
			
		}
}
