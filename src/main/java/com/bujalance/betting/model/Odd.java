package com.bujalance.betting.model;

public class Odd {

	private Result fResult;
	private double fQuote;

	public Odd(final Result pResult, final double pQuote) {
		fResult = pResult;
		fQuote = pQuote;
	}

	public Result getResult() {
		return fResult;
	}

	public double getQuote() {
		return fQuote;
	}

}
