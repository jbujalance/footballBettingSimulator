package com.bujalance.betting.strategy;

import com.bujalance.betting.model.BettingEvent;
import com.bujalance.betting.model.Odd;

public class MaximumQuoteStrategy extends AbstractStrategy {

	public MaximumQuoteStrategy(final double pQuantity) {
		super(pQuantity);
	}

	@Override
	public Odd getChosenOdd(final BettingEvent pEvent) {
		return pEvent.getMaximumQuoteOdd();
	}

	@Override
	public double getQuantity(final BettingEvent pEvent) {
		return fBaseQuantity;
	}

}
