package com.bujalance.betting.strategy;

import com.bujalance.betting.model.BettingEvent;
import com.bujalance.betting.model.ExecutableBet;
import com.bujalance.betting.model.Odd;

public class MaximumQuoteStrategy extends AbstractStrategy {

	public MaximumQuoteStrategy(final double pQuantity) {
		super(pQuantity);
	}

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

	@Override
	public double getQuantity(final BettingEvent pEvent) {
		return fBaseQuantity;
	}

}
