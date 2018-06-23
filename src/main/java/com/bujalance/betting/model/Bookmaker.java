package com.bujalance.betting.model;

public enum Bookmaker {

	BET_365("B365"),
	WILLIAM_HILL("WH");

	private final String fHeader;

	Bookmaker(final String pHeader) {
		fHeader = pHeader;
	}

	public String getHomeHeader() {
		return fHeader + Result.HOME.getHeader();
	}

	public String getDrawHeader() {
		return fHeader + Result.DRAW.getHeader();
	}

	public String getAwayHeader() {
		return fHeader + Result.AWAY.getHeader();
	}

	public String getHeader() {
		return fHeader;
	}
}
