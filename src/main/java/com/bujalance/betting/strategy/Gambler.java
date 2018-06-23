package com.bujalance.betting.strategy;

import com.bujalance.betting.model.BettingEvent;
import com.bujalance.betting.model.Odd;
import com.bujalance.betting.model.Wallet;
import com.bujalance.betting.parser.BettingEventProvider;

import java.util.Iterator;

public class Gambler {

	private final IStrategy fStrategy;
	private final Wallet fWallet;
	/** The quantity to bet on each event. */
	private final double fQuantityToBet;

	public Gambler(final IStrategy pStrategy, final double pQuantityToBet) {
		fStrategy = pStrategy;
		fWallet = new Wallet();
		fQuantityToBet = pQuantityToBet;
	}

	public double betOnEvents(final BettingEventProvider pProvider) {
		Iterator<BettingEvent> events = pProvider.iterator();
		while (events.hasNext()) {
			betOnEvent(events.next(), fWallet);
		}
		return fWallet.getFunds();
	}

	private void betOnEvent(final BettingEvent pEvent, final Wallet pWallet) {
		Odd chosenOdd = fStrategy.getChosenOdd(pEvent);
		if (pEvent.getResult().equals(chosenOdd.getResult())) {
			// Winning bet
			pWallet.add(chosenOdd.getQuote() * pWallet.get(fQuantityToBet));
		} else {
			// Loosing bet
			pWallet.remove(fQuantityToBet);
		}
	}

}
