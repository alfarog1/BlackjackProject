package com.skilldistillery.cards.common;


public class Card {
	private Rank rank;
	private Suit suit;

	public Card(Rank r, Suit s) {
		this.rank = r;
		this.suit = s;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

	@Override
	public String toString() {
		 StringBuilder builder = new StringBuilder();
		    builder.append(rank);
		    builder.append("  ");
		    if ( suit == Suit.CLUBS) {
		    	builder.append(	"♧" );
		    }
		    else if ( suit == Suit.DIAMONDS) {
		    	builder.append(	"♢" );
		    }
		    else if ( suit == Suit.HEARTS) {
		    	builder.append(	"♡" );
		    }
		    else if ( suit == Suit.SPADES) {
		    	builder.append(	"♤" );
		    }
			return builder.toString();
	}

	public int getValue() {
		return rank.getValue();
	}
}
