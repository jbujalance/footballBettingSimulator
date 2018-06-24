package com.bujalance.betting.strategy;

import com.bujalance.betting.model.BettingEvent;
import com.bujalance.betting.model.Wallet;
import com.bujalance.betting.parser.BettingEventProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;

public class Gambler {

	private final static Logger fLogger = LogManager.getLogger(Gambler.class);

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

		double finalFunds = fWallet.getFunds();
		fLogger.info("Final funds following strategy " + fStrategy + ": € " + finalFunds);
		return finalFunds;
	}

}
