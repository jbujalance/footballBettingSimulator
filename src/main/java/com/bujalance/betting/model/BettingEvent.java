package com.bujalance.betting.model;

import java.util.Set;

public class BettingEvent {
	private final Set<Odd> fOdds;
	private final Result fResult;

	public BettingEvent(final Set<Odd> pOdds, final Result pResult) {
		fOdds = pOdds;
		fResult = pResult;
	}

	public Set<Odd> getOdds() {
		return fOdds;
	}

	public Result getResult() {
		return fResult;
	}

	public Odd getMinimumQuoteOdd() {
		double minQuote = Double.MAX_VALUE;
		Odd minQuoteOdd = null;
		for (Odd odd : fOdds) {
			double oddQuote = odd.getQuote();
			if (oddQuote < minQuote) {
				minQuote = oddQuote;
				minQuoteOdd = odd;
			}
		}
		return minQuoteOdd;
	}

	public Odd getMaximumQuoteOdd() {
		double maxQuote = -1;
		Odd maxQuoteOdd = null;
		for (Odd odd : fOdds) {
			double oddQuote = odd.getQuote();
			if (oddQuote > maxQuote) {
				maxQuote = oddQuote;
				maxQuoteOdd = odd;
			}
		}
		return maxQuoteOdd;
	}

	public Odd getMiddleQuoteOdd() {
		Odd minOdd = getMinimumQuoteOdd();
		Odd maxOdd = getMaximumQuoteOdd();
		Odd middleQuoteOdd = null;
		for (Odd odd : fOdds) {
			if (!odd.equals(minOdd) && !odd.equals(maxOdd)) {
				middleQuoteOdd = odd;
			}
		}
		return middleQuoteOdd;
	}
}
