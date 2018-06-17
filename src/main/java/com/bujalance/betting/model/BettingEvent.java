package com.bujalance.betting.model;

import java.util.Set;

public class BettingEvent {
	Set<Odd> fOdds;
	Result fResult;

	public BettingEvent(final Set<Odd> pOdds, final Result pResult) {
		fOdds = pOdds;
		fResult = pResult;
	}

	public double bet(final double pQuantity, final Odd pOdd) {
		return fResult.equals(pOdd.getResult()) ? pQuantity * pOdd.getQuote() : 0;
	}

	public Set<Odd> getOdds() {
		return fOdds;
	}

	public Result getResult() {
		return fResult;
	}
}
