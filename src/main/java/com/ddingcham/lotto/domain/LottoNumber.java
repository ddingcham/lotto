package com.ddingcham.lotto.domain;

public class LottoNumber {

	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;
	
	private int lottoNumber;

	public LottoNumber(int lottoNumber) {
		// TODO Auto-generated constructor stub
		if(lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER){
			throw new IllegalArgumentException();
		}
		
		this.lottoNumber = lottoNumber;
	}

}
