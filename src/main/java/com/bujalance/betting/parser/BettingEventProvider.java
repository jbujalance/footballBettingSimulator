package com.bujalance.betting.parser;

import com.bujalance.betting.model.BettingEvent;
import com.bujalance.betting.model.Odd;
import com.bujalance.betting.model.Result;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BettingEventProvider implements Iterable<BettingEvent> {

	private final static String DEFAULT_FILENAME = "LaLiga_17-18.csv";

	private final CSVParser fParser;

	public BettingEventProvider() throws IOException {
		this(DEFAULT_FILENAME);
	}

	public BettingEventProvider(final String pFilename) throws IOException {
		InputStream is = getClass().getClassLoader().getResourceAsStream(pFilename);
		Reader reader = new InputStreamReader(is);
		fParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
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
			odds.add(new Odd(Result.HOME, Double.parseDouble(pRecord.get("B365H"))));
			// Draw
			odds.add(new Odd(Result.DRAW, Double.parseDouble(pRecord.get("B365D"))));
			// Away winner
			odds.add(new Odd(Result.AWAY, Double.parseDouble(pRecord.get("B365A"))));
			return odds;
		}
	}
}
