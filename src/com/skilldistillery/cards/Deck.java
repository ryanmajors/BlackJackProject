package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck;

	public Deck() {
		deck = createDeck();
	}

	private List<Card> createDeck() {
		List<Card> newDeck = new ArrayList<>();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				newDeck.add(new Card(suit, rank));
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
	}

}
