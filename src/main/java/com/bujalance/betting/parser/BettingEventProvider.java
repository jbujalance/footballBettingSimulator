package com.bujalance.betting.parser;

import com.bujalance.betting.model.BettingEvent;
import com.bujalance.betting.model.Bookmaker;
import com.bujalance.betting.model.Odd;
import com.bujalance.betting.model.Result;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BettingEventProvider implements Iterable<BettingEvent> {

	private final static String RELATIVE_PATH = "data/";
	private final static String DEFAULT_FILENAME = RELATIVE_PATH + "spain/LaLiga_17-18.csv";

	private final CSVParser fParser;
	private final Bookmaker fBookmaker;

	public BettingEventProvider(final Bookmaker pBookmaker) throws IOException {
		this(DEFAULT_FILENAME, pBookmaker);
	}

	public BettingEventProvider(final String pFilename, final Bookmaker pBookmaker) throws IOException {
		InputStream is = getClass().getClassLoader().getResourceAsStream(RELATIVE_PATH + pFilename);
		Reader reader = new InputStreamReader(is);
		fParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
		fBookmaker = pBookmaker;
	}

	@Override
	public Iterator<BettingEvent> iterator() {
		return new BettingEventIterator(fParser);
	}

	private class BettingEventIterator implements Iterator<BettingEvent> {

		private final Iterator<CSVRecord> fCsvIterator;

		public BettingEventIterator(final CSVParser pParser) {
			fCsvIterator = pParser.iterator();
		}

		@Override
		public boolean hasNext() {
			return fCsvIterator.hasNext();
		}

		@Override
		public BettingEvent next() {
			return parseBettingEvent(fCsvIterator.next());
		}

		private BettingEvent parseBettingEvent(final CSVRecord pRecord) {
			return new BettingEvent(parseOdds(pRecord), Result.get(pRecord.get("FTR")));
		}

		private Set<Odd> parseOdds(final CSVRecord pRecord) {
			Set<Odd> odds = new HashSet<>();
			// Home winner
			odds.add(new Odd(Result.HOME, Double.parseDouble(pRecord.get(fBookmaker.getHomeHeader()))));
			// Draw
			odds.add(new Odd(Result.DRAW, Double.parseDouble(pRecord.get(fBookmaker.getDrawHeader()))));
			// Away winner
			odds.add(new Odd(Result.AWAY, Double.parseDouble(pRecord.get(fBookmaker.getAwayHeader()))));
			return odds;
		}
	}
}
