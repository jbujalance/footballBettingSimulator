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
			fLookup.put(result.getValue(), result);
	}

	private final String fValue;

	Result(final String pValue) {
		fValue = pValue;
	}

	private String getValue() {
		return fValue;
	}

	public static Result get(final String pValue) {
		return fLookup.get(pValue);
	}
}
