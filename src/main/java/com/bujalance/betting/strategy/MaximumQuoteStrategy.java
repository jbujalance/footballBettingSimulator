package com.bujalance.betting.strategy;

import com.bujalance.betting.model.BettingEvent;
import com.bujalance.betting.model.Odd;

public class MaximumQuoteStrategy extends AbstractStrategy {

	public MaximumQuoteStrategy(final double pQuantityToBet) {
		super(pQuantityToBet);
	}

	@Override
	Odd getChosenOdd(final BettingEvent pEvent) {
		return getMaximumQuoteOdd(pEvent);
	}

	private Odd getMaximumQuoteOdd(final BettingEvent pEvent) {
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
