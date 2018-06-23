package com.bujalance.betting.strategy;

import com.bujalance.betting.model.BettingEvent;
import com.bujalance.betting.model.Odd;

public interface IStrategy {

	Odd getChosenOdd(final BettingEvent pEvent);

}
