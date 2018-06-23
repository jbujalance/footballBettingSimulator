package com.bujalance.betting.strategy;

import com.bujalance.betting.model.BettingEvent;
import com.bujalance.betting.model.Odd;
import com.bujalance.betting.model.Wallet;
import com.bujalance.betting.parser.BettingEventProvider;

import java.util.Iterator;

public abstract class AbstractStrategy implements IStrategy {

	/** The quantity to bet on each event. */
	private final double fQuantityToBet;

	public AbstractStrategy(final double pQuantityToBet) {
		fQuantityToBet = pQuantityToBet;
	}

	@Override
	public double betOnEvents(final Wallet pWallet, final BettingEventProvider pProvider) {
		Iterator<BettingEvent> events = pProvider.iterator();
		while (events.hasNext()) {
			betOnEvent(events.next(), pWallet);
		}
		return pWallet.getFunds();
	}

	private void betOnEvent(final BettingEvent pEvent, final Wallet pWallet) {
		Odd chosenOdd = getChosenOdd(pEvent);
		if (pEvent.getResult().equals(chosenOdd.getResult())) {
			// Winning bet
			pWallet.add(chosenOdd.getQuote() * pWallet.get(fQuantityToBet));
		} else {
			// Loosing bet
			pWallet.remove(fQuantityToBet);
		}
	}

	abstract Odd getChosenOdd(final BettingEvent pEvent);

}
