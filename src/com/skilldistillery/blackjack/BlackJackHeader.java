package com.skilldistillery.blackjack;

public class BlackJackHeader {

	public static void main(String[] args) {
		boolean keepGoing = true;
		BlackJackHeader bjh = new BlackJackHeader();
		while(keepGoing) {
			clear();
		bjh.printBanner();
		keepGoing = false;
		
		}
		
	}
	
	public void printBanner() {
		System.out.println("██████╗ ██╗      █████╗  ██████╗██╗  ██╗     ██╗ █████╗  ██████╗██╗  ██╗");
		System.out.println("██╔══██╗██║     ██╔══██╗██╔════╝██║ ██╔╝     ██║██╔══██╗██╔════╝██║ ██╔╝");
		System.out.println("██████╔╝██║     ███████║██║     █████╔╝      ██║███████║██║     █████╔╝");
		System.out.println("██╔══██╗██║     ██╔══██║██║     ██╔═██╗ ██   ██║██╔══██║██║     ██╔═██╗");
		System.out.println("██████╔╝███████╗██║  ██║╚██████╗██║  ██╗╚█████╔╝██║  ██║╚██████╗██║  ██╗");
		System.out.println("╚═════╝ ╚══════╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝ ╚════╝ ╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝");
	}
	
	public static void clear() {
		final String ANSI_CLS = "\u001b";
		final String ANSI_HOME = "\u001b";
		System.out.println(ANSI_CLS+ANSI_HOME);
		System.out.flush();
	}

}
