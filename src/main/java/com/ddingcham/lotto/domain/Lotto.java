package com.ddingcham.lotto.domain;

import java.util.Set;

public class Lotto {
	
	private static final int LOTTO_SIZE = 6;
		
	private Set<LottoNumber> lottoNumbers;
	
	public Lotto(Set<LottoNumber> lottoNumbers){
		if(lottoNumbers.size() != LOTTO_SIZE){
			throw new IllegalArgumentException();
		}
		this.lottoNumbers = lottoNumbers;
	}

	public int matchCount(Lotto targetLotto) {
		// TODO Auto-generated method stub
		int count = 0;
		for(LottoNumber lottoNumber : targetLotto.lottoNumbers){
			if(lottoNumbers.contains(lottoNumber)){
				count++;
			}
		}
		return count;
	}
	
}
