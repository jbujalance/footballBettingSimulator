package com.bujalance.betting.model;

public class Wallet {

	private double fFund;

	public Wallet() {
		this(0);
	}

	public Wallet(final double pInitialFund) {
		fFund = pInitialFund;
	}

	public double get(final double pQuantity) {
		fFund -= pQuantity;
		return pQuantity;
	}

	public void add(final double pQuantity) {
		fFund += pQuantity;
	}
}
