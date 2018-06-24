package com.bujalance.betting.model;

public class ExecutableBet {

	private final Odd fChosenOdd;
	private final Result fEventResult;
	private final double fQuantity;

	public ExecutableBet(final Odd pChosenOdd, final Result pEventResult, final double pQuantity) {
		fChosenOdd = pChosenOdd;
		fEventResult = pEventResult;
		fQuantity = pQuantity;
	}

	public void execute(final Wallet pWallet) {
		if (fQuantity == 0) {
			return;
		}

		if (fEventResult.equals(fChosenOdd.getResult())) {
			// Winning bet
			pWallet.add(fChosenOdd.getQuote() * pWallet.get(fQuantity));
		} else {
			// Loosing bet
			pWallet.remove(fQuantity);
		}
	}
}
