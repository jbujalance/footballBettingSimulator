package com.bujalance.betting.strategy;

import com.bujalance.betting.model.BettingEvent;
import com.bujalance.betting.model.Odd;

public class MaximumQuoteStrategy implements IStrategy {

	@Override
	public Odd getChosenOdd(final BettingEvent pEvent) {
		double maxQuote = -1;
		Odd maxQuoteOdd = null;
		for (Odd odd : pEvent.getOdds()) {
			double oddQuote = odd.getQuote();
			if (oddQuote > maxQuote) {
				maxQuote = oddQuote;
				maxQuoteOdd = odd;
			}
		}
		return maxQuoteOdd;
	}

}
