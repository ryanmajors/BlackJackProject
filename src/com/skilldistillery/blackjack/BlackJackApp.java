package com.skilldistillery.blackjack;

import java.util.Scanner;

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
				bjf.playBlackJack(sc);
				mainMenuKeepGoing = false;
				break;
			case 2:
				bjf.rules();
				break;
			case 3:
				System.out
						.println("\n  Thank you for using my app. Please come back when you would like to play again!");
				mainMenuKeepGoing = false;

			}

		}
	}

	

	

}