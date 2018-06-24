package com.bujalance.betting.strategy;

import com.bujalance.betting.model.BettingEvent;
import com.bujalance.betting.model.Odd;

public class MinimumQuoteStrategy extends AbstractStrategy {

	public MinimumQuoteStrategy(final double pBaseQuantity) {
		super(pBaseQuantity);
	}

	@Override
	public Odd getChosenOdd(final BettingEvent pEvent) {
		return pEvent.getMinimumQuoteOdd();
	}

	@Override
	public double getQuantity(final BettingEvent pEvent) {
		return fBaseQuantity;
	}

}
