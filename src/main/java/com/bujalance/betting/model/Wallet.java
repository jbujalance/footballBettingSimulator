package com.bujalance.betting.model;

public class Wallet {

	private double fFunds;

	public Wallet() {
		this(0);
	}

	public Wallet(final double pInitialFund) {
		fFunds = pInitialFund;
	}

	public void remove(final double pQuantity) {
		fFunds -= pQuantity;
	}

	public void add(final double pQuantity) {
		fFunds += pQuantity;
	}

	public double get(final double pQuantity) {
		remove(pQuantity);
		return pQuantity;
	}

	public double getFunds() {
		return fFunds;
	}
}
