package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck;

	public Deck() {
		deck = create4DeckShoe();
	}

	private List<Card> create4DeckShoe() {

		List<Card> newDeck = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			for (Suit suit : Suit.values()) {
				for (Rank rank : Rank.values()) {
					newDeck.add(new Card(suit, rank));
				}
			}
		}
		return newDeck;
	}

	public int checkDeckSize() {
		return deck.size();
	}

	public Card dealCard() {
		return deck.remove(0);
	}

	public void shuffle() {
		Collections.shuffle(deck);
		System.out.println("\n  The deck is now shuffled.");
	}

}
