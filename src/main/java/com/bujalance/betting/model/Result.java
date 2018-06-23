package com.bujalance.betting.model;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Result {
	HOME("H"),
	DRAW("D"),
	AWAY("A");

	private static final Map<String, Result> fLookup = new HashMap<>();

	static {
		for (Result result : EnumSet.allOf(Result.class))
			fLookup.put(result.getHeader(), result);
	}

	private final String fHeader;

	Result(final String pHeader) {
		fHeader = pHeader;
	}

	public String getHeader() {
		return fHeader;
	}

	public static Result get(final String pHeader) {
		return fLookup.get(pHeader);
	}
}
