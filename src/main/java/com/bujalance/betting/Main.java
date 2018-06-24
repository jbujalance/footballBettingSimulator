package com.bujalance.betting;

import com.bujalance.betting.model.Bookmaker;
import com.bujalance.betting.parser.BettingEventProvider;
import com.bujalance.betting.strategy.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main {

	private final static Logger fLogger = LogManager.getLogger(Main.class);

	public static void main(String[] args) throws IOException {
		double baseQuantity = 2;
		Gambler minimumQuoteGambler = new Gambler(new MinimumQuoteStrategy(baseQuantity));
		Gambler maximumQuoteGambler = new Gambler(new MaximumQuoteStrategy(baseQuantity));
		Gambler middleQuoteGambler = new Gambler(new MiddleQuoteStrategy(baseQuantity));
		Gambler proportionalMinToMaxGambler = new Gambler(new ProportionalMinToMaxQuoteStrategy(baseQuantity));

		Bookmaker bookmaker = Bookmaker.WILLIAM_HILL;
		fLogger.info("Start betting € {} as base quantity on {}", baseQuantity, bookmaker.name());
		fLogger.info("Minimum quote strategy: € " + minimumQuoteGambler.betOnEvents(new BettingEventProvider(bookmaker)));
		fLogger.info("Maximum quote strategy: € " + maximumQuoteGambler.betOnEvents(new BettingEventProvider(bookmaker)));
		fLogger.info("Middle quote strategy: € " + middleQuoteGambler.betOnEvents(new BettingEventProvider(bookmaker)));
		fLogger.info("Proportional min to max quote strategy: € " + proportionalMinToMaxGambler.betOnEvents(new BettingEventProvider(bookmaker)));
		fLogger.info("End");
	}

}
