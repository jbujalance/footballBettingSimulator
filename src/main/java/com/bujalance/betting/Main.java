package com.bujalance.betting;

import com.bujalance.betting.model.Bookmaker;
import com.bujalance.betting.parser.BettingEventProvider;
import com.bujalance.betting.strategy.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

	private final static Logger fLogger = LogManager.getLogger(Main.class);

	public static void main(String[] args) throws IOException {
		double baseQuantity = 2;
		Set<IStrategy> strategies = new HashSet<>(Arrays.asList(
				new MinimumQuoteStrategy(baseQuantity),
				new MaximumQuoteStrategy(baseQuantity),
				new MiddleQuoteStrategy(baseQuantity),
				new ProportionalMinToMaxQuoteStrategy(baseQuantity),
				new ProportionalMinToMiddleStrategy(baseQuantity),
				new LesserMinimumQuoteStrategy(baseQuantity, 1.3)
		));

		Bookmaker bookmaker = Bookmaker.WILLIAM_HILL;
		fLogger.info("Start betting on {}", bookmaker.name());
		for (IStrategy strategy : strategies) {
			new Gambler(strategy).betOnEvents(new BettingEventProvider(bookmaker));
		}
		fLogger.info("End");
	}

}
