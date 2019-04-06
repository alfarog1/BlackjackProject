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

		initialCardBattle();

		sc.close();

	}

	public void initialCardBattle() {
			
			//Deal dealers cards
			bob.getHand().addCard(bob.deal());
			bob.getHand().addCard(bob.deal());
			System.out.println(bob.getHand().getCards().toString());
			int bobAmount = bob.getHand().getHandValue();
			System.out.println("Dealer " + bobAmount +"\n\n");
			
			//Deal two cards to player
			mav.getHand().addCard(bob.deal());
			mav.getHand().addCard(bob.deal());
			//Show their cards and total sum
			System.out.println(mav.getHand().getCards().toString());
			int playerAmount = mav.getHand().getHandValue();
			System.out.println("Player has  " + playerAmount);
			
			//if ()
			
			
			//add logic to continue playing or quit
			
			continueCardBattle();
			
		}
	
	public void continueCardBattle() {
		// if player did not hit blackjack offer choices to hit or stay
		if ((mav.getHand().getHandValue()) < 21) {
			
		}
	}
	
	public void dealerHit() {	
		//if the dealer has less than 17 dealer hits until dealer is over 17
		if((bob.getHand().getHandValue()) < 17){
			for (int i = 0; i < 17 ; ) {
				bob.getHand().addCard(bob.deal());
				i = bob.getHand().getHandValue();
		System.out.println("Dealer " + bob.getHand().getHandValue() + "\n\n");					
			}
				
		}	
	}

	public void hitOrStayMenu() {
		System.out.println("Do you want to hit or stay?");
		System.out.println("1. Hit\n" + 
				"2. Stay\n" + 
				"3. Quit Game\n" + 
				"4. Get Help");
		
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			mav.getHand().addCard(bob.deal());
			System.out.println(mav.getHand().getCards().toString());
			System.out.println("Player has  " + mav.getHand().getHandValue());
			break;
		case 2: 
			
			break;
			
		case 3:
			
			break;
			
		case 4:
			
			break;
		default:
			break;
		}
	}
}
