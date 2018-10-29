package com.ddingcham.lotto.domain;

public class LottoNumber {

	static final int MIN_LOTTO_NUMBER = 1;
	static final int MAX_LOTTO_NUMBER = 45;
	
	private int lottoNumber;

	public LottoNumber(int lottoNumber) {
		// TODO Auto-generated constructor stub
		if(lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER){
			throw new IllegalArgumentException();
		}
		
		this.lottoNumber = lottoNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lottoNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LottoNumber other = (LottoNumber) obj;
		if (lottoNumber != other.lottoNumber)
			return false;
		return true;
	}
	
	

}
