package com.bujalance.betting.strategy;

import com.bujalance.betting.model.BettingEvent;
import com.bujalance.betting.model.ExecutableBet;
import com.bujalance.betting.model.Odd;

public interface IStrategy {

	ExecutableBet getBetProposition(final BettingEvent pEvent);
	Odd getChosenOdd(final BettingEvent pEvent);
	double getQuantity(final BettingEvent pEvent);

}
