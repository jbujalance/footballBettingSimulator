package com.bujalance.betting.strategy;

import com.bujalance.betting.model.BettingEvent;
import com.bujalance.betting.model.ExecutableBet;

public abstract class AbstractStrategy implements IStrategy {

	final double fBaseQuantity;

	AbstractStrategy(final double pBaseQuantity) {
		fBaseQuantity = pBaseQuantity;
	}

	@Override
	public ExecutableBet getBetProposition(final BettingEvent pEvent) {
		return new ExecutableBet(getChosenOdd(pEvent), pEvent.getResult(), getQuantity(pEvent));
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "[baseQuantity=" + fBaseQuantity + " €]";
	}
}
