package com.ddingcham.lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber implements Comparable<LottoNumber> {

	static final int MIN_LOTTO_NUMBER = 1;
	static final int MAX_LOTTO_NUMBER = 45;
	static final Map<Integer, LottoNumber> LOTTO_NUMBERS;

	private int lottoNumber;

	static {
		LOTTO_NUMBERS = new HashMap<Integer, LottoNumber>();
		for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
			LOTTO_NUMBERS.put(i, new LottoNumber(i));
		}
	}

	private LottoNumber(int lottoNumber) {
		// TODO Auto-generated constructor stub
		this.lottoNumber = lottoNumber;
	}

	public static LottoNumber ofInt(int lottoNumber) {
		if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
			throw new IllegalArgumentException();
		}
		return LOTTO_NUMBERS.get(lottoNumber);
	}

	public static LottoNumber ofString(String lottoNumber) {
		return ofInt(Integer.parseInt(lottoNumber.trim()));
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

	@Override
	public int compareTo(LottoNumber other) {
		// TODO Auto-generated method stub
		return Integer.compare(this.lottoNumber, other.lottoNumber);
	}

	@Override
	public String toString() {
		return String.valueOf(lottoNumber);
	}

}
