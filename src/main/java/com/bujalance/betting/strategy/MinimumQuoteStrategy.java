package com.bujalance.betting.strategy;

import com.bujalance.betting.model.BettingEvent;
import com.bujalance.betting.model.Odd;

public class MinimumQuoteStrategy implements IStrategy {

	@Override
	public Odd getChosenOdd(final BettingEvent pEvent) {
		double minQuote = Double.MAX_VALUE;
		Odd minQuoteOdd = null;
		for (Odd odd : pEvent.getOdds()) {
			double oddQuote = odd.getQuote();
			if (oddQuote < minQuote) {
				minQuote = oddQuote;
				minQuoteOdd = odd;
			}
		}
		return minQuoteOdd;
	}

}
