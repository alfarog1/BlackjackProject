package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;

public class BlackjackApp {
	Player mav = new Player();
	Dealer bob = new Dealer();
	Scanner sc = new Scanner(System.in);
	Deck d = new Deck();
	boolean dealerGo = true;

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
		// Dealer shows only one card
		System.out.println("\nDealer has " + bob.showFaceUp() + "\n\n");

		// Deal two cards to player
		mav.getHand().addCard(bob.deal());
		mav.getHand().addCard(bob.deal());
		// Show their cards and total sum
		System.out.println(mav.getHand());
		int playerAmount = mav.getHand().getHandValue();
		System.out.println("Player has  " + playerAmount);
		bjCheck();

		hitOrStayMenu();

		// add logic to continue playing or quit

		continueCardBattle();

	}

	public void bjCheck() {
		int playerAmount = mav.getHand().getHandValue();
		if (playerAmount == 21) {
			System.out.println("You Win!!!");
			playAgain();
		}
	}

	public void playerHit() {
		mav.getHand().addCard(bob.deal());
		System.out.println(mav.getHand().getCards().toString());
		System.out.println("Player has  " + mav.getHand().getHandValue());
		continueCardBattle();
	}

	public void continueCardBattle() {
		// if player did not hit blackjack offer choices to hit or stay
		dealerGo = true;

		if ((mav.getHand().getHandValue()) < 21) {
			hitOrStayMenu();
		}
		if ((mav.getHand().getHandValue()) < 21) {

			dealerHit();
		}
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

	public void dealerPlaysAgain() {
		bob.getHand().addCard(bob.deal());
		bob.getHand().addCard(bob.deal());
		System.out.println("Dealer has " + bob.showFaceUp() + "\n\n");

	}

	public void win() {
		int bobH = bob.getHand().getHandValue();
		int mavH = mav.getHand().getHandValue();

		if (mavH <= 21 && mavH > bobH) {
			System.out.println("\nYou win!!\n");
			System.out.println("Player has " + mavH + " and Dealer has " + bobH);
		}
		if (mavH <= 21 && bobH > 21) {
			System.out.println("\nYou win!!\n");
			System.out.println("Player has " + mavH + " and Dealer has " + bobH);
		} else if (mavH == bobH) {
			System.out.println("\nPush!!\n");
			System.out.println("Player has " + mavH + " and Dealer has " + bobH);
		} else if (bobH > mavH && bobH <= 21) {
			dealerGo = false;
			System.out.println("\nYou lose!!!\n");
			System.out.println("Player has " + mavH + " and Dealer has " + bobH);

		} else if (mavH > 21 && bobH <= 21) {
			dealerGo = false;
			System.out.println("\nYou lose!!!\n");
			System.out.println("Player has " + mavH + " and Dealer has " + bobH);

		}
		playAgain();
	}

	public void playAgain() {
		System.out.println("\nWant to play again?\n");
		System.out.println("1. Yes\n" + "2. No\n");
		String choice = sc.nextLine();
		switch (choice) {
		case "1":
			clearHand();
			initialCardBattle();
			break;
		case "2":
			System.out.println("Thanks for playing!");
			System.exit(0);
			break;
		default:
			System.out.println("Hey wiseguy, choose from 1 or 2!");
			break;
		}

	}

	public void clearHand() {
		mav.hand.clearHand();
		bob.hand.clearHand();
	}

	public void hitOrStayMenu() {
		System.out.println("\nDo you want to hit or stay?");
		System.out.println("1. Hit\n" + "2. Stay\n" + "3. Quit Game\n" + "4. Get Help/Print Deck\n\n");

		String choice = sc.nextLine();
		switch (choice) {
		case "1":
			playerHit();
			win();
			System.out.println("Dealer has " + bob.getHand().getHandValue() + "\n\n");
			break;
		case "2":
			dealerHit();
			win();
			System.out.println("Dealer has " + bob.getHand().getHandValue() + "\n\n");
			break;

		case "3":
			System.out.println("Thanks for playing");
			System.exit(0);
			break;

		case "4":
			System.out
					.println("Gambling addiction is not something to play with\n " + "call 855-2CALLGA (855-222-5542)");
			System.out.println(d.toString());
			System.exit(0);
			break;
		default:
			System.out.println("Hey wiseguy, choose from 1-4!");
			break;
		}
	}
}
