package com.ddingcham.lotto;

import com.ddingcham.lotto.domain.Lottoes;

public class LottoGenerator {
	
	public static final int DEFAULT_LOTTO_PRICE = 1000;

	public static Lottoes generate(int price) {
		// TODO Auto-generated method stub
		if(price < DEFAULT_LOTTO_PRICE){
			throw new IllegalArgumentException("구입 금액 부족");
		}
		
		return new Lottoes(price / DEFAULT_LOTTO_PRICE);
	}

}
