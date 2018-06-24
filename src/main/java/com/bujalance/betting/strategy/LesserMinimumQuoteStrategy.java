package com.bujalance.betting.strategy;

import com.bujalance.betting.model.BettingEvent;
import com.bujalance.betting.model.Odd;

/**
 * Only bets on quotes lesser than the given limit
 */
public class LesserMinimumQuoteStrategy extends AbstractStrategy {

	private final double fQuoteLimit;

	public LesserMinimumQuoteStrategy(final double pBaseQuantity, final double pQuoteLimit) {
		super(pBaseQuantity);
		fQuoteLimit = pQuoteLimit;
	}

	@Override
	public Odd getChosenOdd(final BettingEvent pEvent) {
		return pEvent.getMinimumQuoteOdd();
	}

	@Override
	public double getQuantity(final BettingEvent pEvent) {
		return getChosenOdd(pEvent).getQuote() <= fQuoteLimit ? fBaseQuantity : 0;
	}

	@Override
	public String toString() {
		String superString = super.toString();
		return superString.substring(0, superString.length() - 1) + ", quoteLimit=" + fQuoteLimit + "]";
	}
}
