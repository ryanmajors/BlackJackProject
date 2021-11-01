package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;
import com.skilldistillery.personcreator.BlackJackDealer;
import com.skilldistillery.personcreator.BlackJackPlayer;

public class BlackJackApp {

	public static void main(String[] args) {

		BlackJackApp bja = new BlackJackApp();

		bja.launch();

	}

	// launch method
	public void launch() {
		BlackJackFunctions bjf = new BlackJackFunctions();
		Scanner sc = new Scanner(System.in);
		bjf.printBanner();
		System.out.println("");
		System.out.println("");
		System.out.println("                  1: [Play]           2: [Help]           3: [Quit]      ");
		boolean mainMenuKeepGoing = true;
		while (mainMenuKeepGoing) {
			System.out.println("");
			System.out.println("");

			// main menu player input
			System.out.print("  Please choose your option: ");
			int menuChoice = sc.nextInt();
			sc.nextLine();

			// switch to process player input
			switch (menuChoice) {
			case 1:
				playBlackJack(sc);
				mainMenuKeepGoing = false;
				break;
			case 2:
				rules();
				break;
			case 3:
				System.out
						.println("\n  Thank you for using my app. Please come back when you would like to play again!");
				mainMenuKeepGoing = false;

			}

		}
	}

	public void playBlackJack(Scanner sc) {
		BlackJackFunctions bjf = new BlackJackFunctions();
		String playerName = bjf.playerNamePromptAndGreeting(sc);
		BlackJackPlayer player = new BlackJackPlayer(playerName);
		BlackJackDealer dealer = new BlackJackDealer("Dealer");
		int playerMoney = bjf.playerbank(sc);
		Deck startingDeck = bjf.unboxDeckOfCards();
		startingDeck.shuffle();
		int playerBet = player.placeBet(sc, playerMoney);
		boolean gameLoop = true;
		while (gameLoop) {
			// shuffle deck of cards
			// empty player hand created
			List<Card> playerHand = new ArrayList<>();
			int playerHandTotal = 0;
			// empty dealer hand created
			int dealerHandTotal = 0;
			List<Card> dealerHand = new ArrayList<>();
			// deal starting hands
			dealer.dealCards(startingDeck, playerHand, dealerHand, player);
			// player turn

			boolean playing = true;
			while (playing) {
				int playerHas2Aces = bjf.checkIfPlayerHas2Aces(playerHandTotal, playerHand);
				if (playerHas2Aces == 1) {
					System.out.println("\n  You have busted. The dealer takes your $" + playerBet + " bet.");
					playerMoney = bjf.playerLosesBet(playerMoney, playerBet);
					playing = false;
					break;
				}

				int playerHasBlackJack = bjf.checkToSeeIfPlayerHasBlackJack(playerHand, dealerHand, playerHandTotal,
						playerBet, dealerHandTotal);
				if (playerHasBlackJack == 1) {
					double blackJackPayout = bjf.blackJackPayoutConversion(playerBet);
					System.out.println("\n  BLACKJACK! You win $" + blackJackPayout);
					playerMoney = bjf.playerWinsBet(playerMoney, playerBet);
					playing = false;
					break;
				}

				int playerStoodOrBusted = player.playerTurn(sc, startingDeck, playerHand, dealerHand, playerHandTotal,
						player, playerBet);
				if (playerStoodOrBusted == 1) {
					playerMoney = bjf.playerLosesBet(playerMoney, playerBet);
					playing = false;
					break;
				}

				int dealerStoodOrBusted = dealer.dealerTurn(sc, startingDeck, dealerHand, dealerHandTotal, player,
						playerBet);

				if (dealerStoodOrBusted == 1) {
					playerMoney = bjf.checkWinConditions(playerHand, dealerHand, player, dealer, playerBet,
							playerMoney);

//			System.out.println(playerHandTotal + " " + dealerHandTotal);

				}
				if (dealerStoodOrBusted == 2) {
					playerMoney = bjf.playerWinsBet(playerMoney, playerBet);
					playing = false;
					break;
				}
				playing = false;
			}
			boolean playAgainLoop = true;
			while (playAgainLoop) {
				System.out.println(
						"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("\n  " + player + " balance: $" + playerMoney);
				if (playerMoney == 0) {
					System.out.print("\n  You are out of money. Would you like to [1]Deposit more money or [2]Quit: ");
					int outOfMoney = sc.nextInt();
					if (outOfMoney == 1) {
						playerMoney = bjf.playerbank(sc);
					} else if (outOfMoney == 2) {
						System.out.println("\n  Have a wonderful day and come back real soon!");
					} else {
						System.out.println("\n  Invalid option. Please try again.");
					}
				}
				System.out.print("\n  Would you like to play again: 1[Yes] 2[No]   ");
				int playAgain = sc.nextInt();
				if (playAgain == 1) {
					playerBet = player.placeBet(sc, playerMoney);
					playAgainLoop = false;

				} else {
					System.out.println("\n  Have a wonderful day and come back real soon!");
					playAgainLoop = false;
					gameLoop = false;

				}
			}
		}
	}

	private static void rules() {
		System.out.println(
				"\n  Welcome to BlackJack. This version uses a 4 - 52 card decks. The player(you) \n  attempts to beat "
						+ "the dealer by getting a count as close to 21 as possible,\n  without going over 21. The game begins with the "
						+ "dealer dealing the player, 1 card \n  face up. Then the dealer deals themself 1 card face down(hidden). Then "
						+ "this \n  repeats 1 more time, except the dealer deals their second card face up.\n\n  If the player shows a "
						+ "natural 21 conisting of an ace and a \"ten-card\"(a picture \n  card or 10) they win. The player goes first and must "
						+ "decide whether to \"Stand\"\n  (not ask for another card) or \"Hit\"(ask for another card in an attempt to "
						+ "get \n  closer to a count of 21, or even hit 21 exactly). The player may hit until they \n  \"Bust\"(cards "
						+ "in hand total is greater than 21. If the player busts, they lose the \n  round and the dealer takes the "
						+ "player's bet.\n\n  Once the player has either been dealt a natural 21, chosen to \"Stand\", or has \n  "
						+ "\"Busted\", the dealer will then flip over their face down card and play in the \n  same manner as the player, "
						+ "by first seeing if they have a natural 21. If this is \n  the case, you will push(tie) and your bet will "
						+ "beturned to you. If the dealer \n  decides to \"Stand\", you will lose if the dealer's card's total to more "
						+ "than yours \n  and they have less than 21. If the dealer's card's total less than yours and \n  neither of you "
						+ "have cards totaling more than 21 or if the dealer \"Busts\", you \n  will win and your bet will be returned "
						+ "to you doubled.\n");
		System.out.println("");
	}

}