package com.bujalance.betting;

import com.bujalance.betting.model.Bookmaker;
import com.bujalance.betting.model.Wallet;
import com.bujalance.betting.parser.BettingEventProvider;
import com.bujalance.betting.strategy.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main {

	private final static Logger fLogger = LogManager.getLogger(Main.class);

	public static void main(String[] args) throws IOException {
		double betPerMatch = 2;
		Gambler minimumQuoteGambler = new Gambler(new MinimumQuoteStrategy(betPerMatch));
		Gambler maximumQuoteGambler = new Gambler(new MaximumQuoteStrategy(betPerMatch));
		Gambler middleQuoteGambler = new Gambler(new MiddleQuoteStrategy(betPerMatch));

		Bookmaker bookmaker = Bookmaker.WILLIAM_HILL;
		fLogger.info("Start betting € {} per match on {}", betPerMatch, bookmaker.name());
		fLogger.info("Minimum quote strategy: € " + minimumQuoteGambler.betOnEvents(new BettingEventProvider(bookmaker)));
		fLogger.info("Maximum quote strategy: € " + maximumQuoteGambler.betOnEvents(new BettingEventProvider(bookmaker)));
		fLogger.info("Middle quote strategy: € " + middleQuoteGambler.betOnEvents(new BettingEventProvider(bookmaker)));
		fLogger.info("End");
	}

}
