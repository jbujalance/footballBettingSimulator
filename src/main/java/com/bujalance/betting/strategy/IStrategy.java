package com.bujalance.betting.strategy;

import com.bujalance.betting.model.Wallet;
import com.bujalance.betting.parser.BettingEventProvider;

public interface IStrategy {

	/**
	 * Applies the betting strategy to all the betting events from the provider, using the funds from the given wallet.
	 * @param pWallet the wallet from which to retrieve the funds to bet.
	 * @param pProvider provider of the betting events
	 * @return the final balance of the wallet after having bet on the events
	 */
	double betOnEvents(final Wallet pWallet, final BettingEventProvider pProvider);

}
