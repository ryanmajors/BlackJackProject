package com.skilldistillery.personcreator;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class BlackJackPlayer extends Person {

	private List<Card> playerHand;

	public BlackJackPlayer(String name) {
		super(name);

	}

	public List<Card> getPlayerHand() {
		return playerHand;
	}

	public int playerTurn(Scanner sc, Deck startingDeck, List<Card> playerHand, List<Card> dealerHand, 
			int playerHandTotal, BlackJackPlayer player, int playerBet) {
		playerHandTotal = calculateHandTotal(playerHand);
//		dealerHandTotal = calculateHandTotal(dealerHand);
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
					System.out.println("\n  You have busted. The dealer takes your $" + playerBet + " bet.");
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

	public int placeBet(Scanner sc, int playerMoney) {
		System.out.print("\n  How much would you like to bet: $");
		int betValue = sc.nextInt();
		while(betValue > playerMoney) {
			System.out.print("\n  You can't bet more than you have. Please place another bet: $");
			betValue = sc.nextInt();
		}
		return betValue;
	}

}
