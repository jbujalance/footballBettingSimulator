package com.bujalance.betting.strategy;

import com.bujalance.betting.model.BettingEvent;
import com.bujalance.betting.model.Wallet;
import com.bujalance.betting.parser.BettingEventProvider;

import java.util.Iterator;

public class Gambler {

	private final IStrategy fStrategy;
	private final Wallet fWallet;

	public Gambler(final IStrategy pStrategy) {
		this(pStrategy, new Wallet());
	}

	public Gambler(final IStrategy pStrategy, final Wallet pWallet) {
		fStrategy = pStrategy;
		fWallet = pWallet;
	}

	public double betOnEvents(final BettingEventProvider pProvider) {
		Iterator<BettingEvent> events = pProvider.iterator();
		while (events.hasNext()) {
			fStrategy.getBetProposition(events.next()).execute(fWallet);
		}
		return fWallet.getFunds();
	}

}
