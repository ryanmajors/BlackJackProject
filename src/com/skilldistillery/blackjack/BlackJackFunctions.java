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
			int dealerHandTotal, int playerBet) {
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
			} else if (dealerHandTotal == playerHandTotal) {
				System.out.println("This hand is a push. Player gets their " + playerBet + " bet back");
			}
		}
		return blackJack;
	}

	public int checkWinConditions(List<Card> playerHand, List<Card> dealerHand, BlackJackPlayer player,
			BlackJackDealer dealer, int playerBet, int playerMoney) {

		int playerHandTotal = player.calculateHandTotal(playerHand);
		int dealerHandTotal = dealer.calculateHandTotal(dealerHand);
		int newPlayerMoney = playerMoney;
		if (playerHandTotal > dealerHandTotal) {
			System.out.println("\n  " + player + " wins $" + playerBet + "!");
			newPlayerMoney = playerWinsBet(playerMoney, playerBet);
		} else if (playerHandTotal < dealerHandTotal) {
			System.out.println("\n  Dealer wins and takes your $" + playerBet + " bet.");
			newPlayerMoney = playerLosesBet(playerMoney, playerBet);
		} else {
			System.out.println("\n  This hand is a push. " + player + " gets their $" + playerBet + " bet back");
			
		}
		return newPlayerMoney;
	}

	public double blackJackPayoutConversion(int playerBet) {

		return playerBet * 1.5;
	}

	public int checkIfPlayerHas2Aces(int playerHandTotal, List<Card> playerHand) {
		int has2Aces = 0;
		playerHandTotal = 0;
		for (Card card : playerHand) {
			playerHandTotal += card.getValue();
		}

		if (playerHandTotal > 21) {
			has2Aces = 1;
		}
		return has2Aces;
	}

	public int playerWinsBet(int playerMoney, int playerBet) {
		int newPlayerMoney = playerMoney + playerBet;
		return newPlayerMoney;
	}

	public int playerLosesBet(int playerMoney, int playerBet) {
		int newPlayerMoney = playerMoney - playerBet;
		return newPlayerMoney;
	}

	public double playerWinsBlackJackBet(int playerMoney, int playerBet) {
		double newPlayerMoney = playerMoney + (playerBet * 1.5);
		return newPlayerMoney;
	}
}