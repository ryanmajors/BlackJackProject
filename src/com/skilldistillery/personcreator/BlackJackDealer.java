package com.skilldistillery.personcreator;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class BlackJackDealer extends Person {

	private List<Card> dealerHand;

	public BlackJackDealer(String name) {
		super(name);

	}

	public List<Card> getDealerHand() {
		return dealerHand;
	}

	public int dealerTurn(Scanner sc, Deck startingDeck, List<Card> dealerHand, int dealerHandTotal,
			BlackJackPlayer player, int playerBet) {

		dealerHandTotal = calculateHandTotal(dealerHand);
		System.out.println("\n  Dealer will begin their turn now.");
		System.out.println("\n  Dealer's hand: " + dealerHand + " Showing: " + dealerHandTotal);
		int stoodOrBusted = 0;
		boolean dealerTurn = true;
		while (dealerTurn) {

			if (dealerHandTotal < 17) {
				System.out.println("\n  Dealer hits.");
				Card dealerCard = startingDeck.dealCard();
				dealerHandTotal += dealerCard.getValue();
				dealerHand.add(dealerCard);
				System.out.println("\n  Dealer's hand: " + dealerHand + " Showing: " + dealerHandTotal);
			} else if (dealerHandTotal >= 17 && dealerHandTotal <= 21) {
				System.out.println("\n  Dealer Stays.");
				stoodOrBusted = 1;
				dealerTurn = false;
				break;
			} else {
				System.out.println("\n  Dealer busts. " + player + " wins $" + playerBet + ".");
				stoodOrBusted = 2;
				break;
			}
		}
		return stoodOrBusted;

	}

	public int calculateHandTotal(List<Card> dealerHand) {
		int handTotal = 0;
		for (Card card : dealerHand) {
			handTotal += card.getValue();
		}
		return handTotal;
	}

	public void dealCards(Deck startingDeck, List<Card> playerHand, List<Card> dealerHand, BlackJackPlayer player) {
		Scanner sc = new Scanner(System.in);

		System.out.println("\n  Press Enter to deal cards.");
		String buffer = sc.nextLine();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("\n  Dealing cards...");

		int playerHandTotal = 0;
		Card playerCard1 = startingDeck.dealCard();
		playerHandTotal += playerCard1.getValue();
		playerHand.add(playerCard1);

		int dealerHandTotal = 0;
		Card dealerCard1 = startingDeck.dealCard();
		dealerHandTotal += dealerCard1.getValue();
		dealerHand.add(dealerCard1);

		Card playerCard2 = startingDeck.dealCard();
		playerHandTotal += playerCard2.getValue();
		playerHand.add(playerCard2);

		Card dealerCard2 = startingDeck.dealCard();
		dealerHandTotal += dealerCard2.getValue();
		dealerHand.add(dealerCard2);

		System.out.println("\n  " + player + "'s hand: " + playerHand + " showing [" + playerHandTotal + "]");
		System.out.println("\n  Dealer's hand: [Hidden] " + dealerCard2 + " showing [" + dealerCard2.getValue() + "]");

	}

	@Override
	public String toString() {
		return super.toString() + "'s hand " + dealerHand;
	}

}
