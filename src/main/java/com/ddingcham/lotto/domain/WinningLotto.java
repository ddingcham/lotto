package com.ddingcham.lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningLotto {

	private Lotto winningLotto;
	private LottoNumber bonus;

	public WinningLotto(Lotto winningLotto, LottoNumber bonus) {
		if(winningLotto.contains(bonus)){
			throw new IllegalArgumentException();
		}
		this.winningLotto = winningLotto;
		this.bonus = bonus;
	}

	public static WinningLotto ofInt(Integer bonus, Integer... numbers) {
		// TODO Auto-generated method stub
		return new WinningLotto(Lotto.ofInt(numbers), LottoNumber.ofInt(bonus));
	}
	
	public static WinningLotto ofString(String bonus, String numbers){		
		return new WinningLotto(Lotto.ofString(numbers), LottoNumber.ofString(bonus));
	}

	public Rank calculateResult(Lotto lotto) {
		// TODO Auto-generated method stub
		return Rank.valueOf(winningLotto.matchCount(lotto), lotto.contains(bonus));
	}

	public enum Rank {

		FIRST(6, 2000000000), SECOND(51, 30000000), THIRD(5, 1500000), FOURTH(4,
				50000), FIFTH(3, 5000), MISS(0, 0);

		private static final Map<Integer, Rank> RANK_MAP;

		static {
			RANK_MAP = new HashMap<Integer, Rank>();
			for (Rank rank : Rank.values()) {
				RANK_MAP.put(rank.countOfMatch, rank);
			}
		}

		private int countOfMatch;
		private int winningMoney;

		private Rank(int countOfMatch, int winningMoney) {
			this.countOfMatch = countOfMatch;
			this.winningMoney = winningMoney;
		}

		public int getCountOfMatch() {
			return countOfMatch;
		}

		public int getWinningMoney() {
			return winningMoney;
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
}
