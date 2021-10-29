package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dealing {

	public static void main(String[] args) {
		Dealing deal = new Dealing();
		deal.run();

	}

	public void run() {
		Deck deck = new Deck();
		Scanner sc = new Scanner(System.in);
		deck.shuffle();
		boolean keepGoing = true;
			System.out.println("Welcome to the dealer!");
			while (keepGoing) {
				System.out.println("How many cards would you like: ");

			int numCards = sc.nextInt();
			if (numCards > 52) {
				System.out.println("You must draw less than the size of the Deck(52)");
			}

			List<Card> playerHand = new ArrayList<>(numCards);
			int handTotal = 0;
			for (int i = 0; i < numCards; i++) {
				Card card = deck.dealCard();
				handTotal += card.getValue();
				playerHand.add(card);

			}
			System.out.println("Your hand is: " + playerHand + " and totals: " + handTotal);
			
			System.out.print("Would you like another hand? (y)es or (n)o: ");
			String option = sc.next();
			if(option.equals("y")) {
				continue;
			} else if(option.equals("n")) {
				System.out.println("Have a great day!");
				keepGoing = false;
			}
		}
	}
}
