package com.ddingcham.lotto.domain;

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

	public Rank calculateRank(Lotto lotto) {
		// TODO Auto-generated method stub
		return Rank.valueOf(winningLotto.matchCount(lotto), lotto.contains(bonus));
	}

	public LottoResults calculateResults(Lottoes boughtLottoes) {
		// TODO Auto-generated method stub
		LottoResults lottoResults = new LottoResults();
		for(int i =0;i<boughtLottoes.size();i++){
			lottoResults.add(calculateRank(boughtLottoes.get(i)));
		}
		return lottoResults;
	}
}
