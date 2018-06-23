package com.bujalance.betting;

import com.bujalance.betting.model.Bookmaker;
import com.bujalance.betting.model.Wallet;
import com.bujalance.betting.parser.BettingEventProvider;
import com.bujalance.betting.strategy.IStrategy;
import com.bujalance.betting.strategy.MaximumQuoteStrategy;
import com.bujalance.betting.strategy.MinimumQuoteStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main {

	private final static Logger fLogger = LogManager.getLogger(Main.class);

	public static void main(String[] args) throws IOException {
		double betPerMatch = 2;
		IStrategy minimumQuoteStrategy = new MinimumQuoteStrategy(betPerMatch);
		MaximumQuoteStrategy maximumQuoteStrategy = new MaximumQuoteStrategy(betPerMatch);

		Bookmaker bookmaker = Bookmaker.WILLIAM_HILL;
		fLogger.info("Start betting € {} per match on {}", betPerMatch, bookmaker.name());
		fLogger.info("Minimum quote strategy: € " + minimumQuoteStrategy.betOnEvents(new Wallet(), new BettingEventProvider(bookmaker)));
		fLogger.info("Maximum quote strategy: € " + maximumQuoteStrategy.betOnEvents(new Wallet(), new BettingEventProvider(bookmaker)));
		fLogger.info("End");
	}

}
