package com.skilldistillery.personcreator;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class BlackJackPlayer extends Person {

	public BlackJackPlayer(String name) {
		super(name);

	}

	public int playerTurn(Scanner sc, Deck startingDeck, List<Card> playerHand, List<Card> dealerHand, int playerHandTotal,
			int dealerHandTotal, BlackJackPlayer player) {

		playerHandTotal = calculateHandTotal(playerHand);
		dealerHandTotal = calculateHandTotal(dealerHand);
		int stoodOrBusted = 0;

		boolean stillPlayerTurn = true;
		while (stillPlayerTurn) {
			System.out.println("");
			System.out.println("                          1: [Hit]           2: [Stand]                 ");
			System.out.println("");
			System.out.print("  Player choice: ");
			int hitOrStand = sc.nextInt();

			if (hitOrStand == 1) {
				System.out.println("\n  " + player + " hits.");
				Card playerCard = startingDeck.dealCard();
				playerHandTotal += playerCard.getValue();
				playerHand.add(playerCard);
				System.out.println("\n  " + player + "'s hand: " + playerHand + " Showing: " + playerHandTotal);
				// check to see if player busts after drawing
				if (playerHandTotal > 21) {

					stoodOrBusted = 1;

					stillPlayerTurn = false;
					break;

				}

			} else if (hitOrStand == 2) {
				System.out.println("\n  You have chosen to stand.");
				stoodOrBusted = 2;
				stillPlayerTurn = false;
				break;
			}
		}
		return stoodOrBusted;
	}

	public int calculateHandTotal(List<Card> playerHand) {
		int handTotal = 0;
		for (Card card : playerHand) {
			handTotal += card.getValue();
		}
		return handTotal;
	}

	public int placeBet(Scanner sc) {
		System.out.print("\n  How much would you like to bet: $");
		int betValue = sc.nextInt();
		return betValue;
	}

}
