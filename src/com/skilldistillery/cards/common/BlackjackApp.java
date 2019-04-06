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

		// Deal dealers cards
		bob.getHand().addCard(bob.deal());
		bob.getHand().addCard(bob.deal());
		System.out.println(bob.getHand().getCards().toString());
		int bobAmount = bob.getHand().getHandValue();
		System.out.println("Dealer has " + bobAmount + " but   Only card showing:" + bob.showFaceUp() + "\n\n");

		// Deal two cards to player
		mav.getHand().addCard(bob.deal());
		mav.getHand().addCard(bob.deal());
		// Show their cards and total sum
		System.out.println(mav.getHand().getCards().toString());
		int playerAmount = mav.getHand().getHandValue();
		System.out.println("Player has  " + playerAmount);

		hitOrStayMenu();

		// add logic to continue playing or quit

		continueCardBattle();

	}

	public void playerHit() {
		mav.getHand().addCard(bob.deal());
		System.out.println(mav.getHand().getCards().toString());
		System.out.println("Player has  " + mav.getHand().getHandValue());
		continueCardBattle();
	}

	public void continueCardBattle() {
		// if player did not hit blackjack offer choices to hit or stay
		if ((mav.getHand().getHandValue()) < 21) {
			hitOrStayMenu();
		} else
			dealerHit();
	}

	public void dealerHit() {
		// if the dealer has less than 17 dealer hits until dealer is over 17
		if ((bob.getHand().getHandValue()) < 17) {
			for (int i = 0; i < 17;) {
				bob.getHand().addCard(bob.deal());
				i = bob.getHand().getHandValue();
				System.out.println(bob.getHand().getCards().toString());
				System.out.println("Dealer " + bob.getHand().getHandValue() + "\n\n");
			}

		}
	}

	public void win() {
		if ((bob.getHand().getHandValue()) < (mav.getHand().getHandValue()) && (mav.getHand().getHandValue()) <= 21) {
			System.out.println("\nYou win!!\n");
			playAgain();
		} else
			System.out.println("\nYou lose!!!\n");
			playAgain();

	}

	public void playAgain() {
		System.out.println("\nWant to play again?\n");
		System.out.println("1. Yes\n" + "2. No\n");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			playerHit();
			break;
		case 2:
			System.out.println("Thanks for playing!");
			System.exit(0);
			break;
		default:
			System.out.println("Hey wiseguy, choose from 1 or 2!");
			break;
		}

	}

	public void hitOrStayMenu() {
		System.out.println("\nDo you want to hit or stay?");
		System.out.println("1. Hit\n" + "2. Stay\n" + "3. Quit Game\n" + "4. Get Help\n\n");

		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			playerHit();
			win();
			break;
		case 2:
			dealerHit();
			win();
			break;

		case 3:
			System.out.println("Thanks for playing");
			System.exit(0);
			break;

		case 4:
			System.out.println(
					"Gambling addiction is not a something to play with\n " + "call 855-2CALLGA (855-222-5542");
			System.exit(0);
			break;
		default:
			System.out.println("Hey wiseguy, choose from 1-4!");
			break;
		}
	}
}
