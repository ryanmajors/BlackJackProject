package com.skilldistillery.blackjack;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;
import com.skilldistillery.personcreator.BlackJackDealer;
import com.skilldistillery.personcreator.BlackJackPlayer;

public class BlackJackFunctions {

	// print banner
	public void printBanner() {
		System.out.println("");
		System.out.println("");
		System.out.println("      ██████╗ ██╗      █████╗  ██████╗██╗  ██╗     ██╗ █████╗  ██████╗██╗  ██╗");
		System.out.println("      ██╔══██╗██║     ██╔══██╗██╔════╝██║ ██╔╝     ██║██╔══██╗██╔════╝██║ ██╔╝");
		System.out.println("      ██████╔╝██║     ███████║██║     █████╔╝      ██║███████║██║     █████╔╝");
		System.out.println("      ██╔══██╗██║     ██╔══██║██║     ██╔═██╗ ██   ██║██╔══██║██║     ██╔═██╗");
		System.out.println("      ██████╔╝███████╗██║  ██║╚██████╗██║  ██╗╚█████╔╝██║  ██║╚██████╗██║  ██╗");
		System.out.println("      ╚═════╝ ╚══════╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝ ╚════╝ ╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝");
	}

	public String playerNamePromptAndGreeting(Scanner sc) {

		System.out.println("\n  Welcome to BlackJack! ");
		System.out.print("\n  Enter your name to begin: ");
		String playerName = sc.nextLine();
		BlackJackPlayer player = new BlackJackPlayer(playerName);
		return playerName;

	}

	public int playerbank(Scanner sc) {
		System.out.print("\n  How much would you like to deposit for play: $");
		int moneyDeposited = sc.nextInt();
		System.out.println("\n  You have deposited $" + moneyDeposited);

		return moneyDeposited;

	}

	public Deck unboxDeckOfCards() {

		System.out.println("\n  The dealer has begun unboxing a new deck of cards.");
		Deck startingDeck = new Deck();
		return startingDeck;
	}

	public int checkToSeeIfPlayerHasBlackJack(List<Card> playerHand, List<Card> dealerHand, int playerHandTotal,
			int dealerHandTotal) {
		int blackJack = 0;
		playerHandTotal = 0;
		for (Card card : playerHand) {
			playerHandTotal += card.getValue();
		}
		dealerHandTotal = 0;
		for (Card card : dealerHand) {
			dealerHandTotal += card.getValue();
		}

		if (playerHandTotal == 21) {
			if (dealerHandTotal < playerHandTotal) {

				blackJack = 1;
			}
		}
		return blackJack;
	}

	public void playerBustCheck(int playerHandTotal) {
		if (playerHandTotal > 21) {
			System.out.println("You busted. Hand is over!");
		}
	}

	public void checkWinConditions(List<Card> playerHand, List<Card> dealerHand, BlackJackPlayer player,
			BlackJackDealer dealer) {

		int playerHandTotal = player.calculateHandTotal(playerHand);
		int dealerHandTotal = dealer.calculateHandTotal(dealerHand);

		if (playerHandTotal > dealerHandTotal) {
			System.out.println("\n  " + player + " wins!");
		} else if (playerHandTotal < dealerHandTotal) {
			System.out.println("\n  Dealer wins!");
		} else {
			System.out.println("\n  This hand is a push.");
		}
	}
}