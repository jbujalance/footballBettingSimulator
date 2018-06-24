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
}
