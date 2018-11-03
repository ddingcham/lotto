package com.ddingcham.lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum Rank {

	FIRST(6, 2000000000, "6개 일치 (2000000000원)"),
	SECOND(51, 30000000, "5개 일치, 보너스 볼 일치(30000000원)"),
	THIRD(5, 1500000, "5개 일치 (1500000원)"),
	FOURTH(4, 50000, "4개 일치 (50000원)"),
	FIFTH(3, 5000, "3개 일치 (5000원)"),
	MISS(0, 0, "꽝");

	private static final Map<Integer, Rank> RANK_MAP;

	static {
		RANK_MAP = new HashMap<Integer, Rank>();
		for (Rank rank : Rank.values()) {
			RANK_MAP.put(rank.countOfMatch, rank);
		}
	}

	private int countOfMatch;
	private int winningMoney;
	private String description;

	private Rank(int countOfMatch, int winningMoney, String description) {
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
		this.description = description;
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public int getWinningMoney() {
		return winningMoney;
	}
	
	public String getDescription(){
		return description;
	}

	public static Rank valueOf(int countOfMatch, boolean matchedBonus) {
		if(countOfMatch < 3){
			countOfMatch = 0;
		}
		if(countOfMatch == 5 && matchedBonus){
			return SECOND;
		}
		return RANK_MAP.get(countOfMatch);
	}
}
