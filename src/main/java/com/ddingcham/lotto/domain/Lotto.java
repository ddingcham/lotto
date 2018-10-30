package com.ddingcham.lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Lotto {
	
	private static final int LOTTO_SIZE = 6;
	private static final List<LottoNumber> LOTTO_NUMBERS;
		
	private LinkedHashSet<LottoNumber> lottoNumbers;
	
	static{
		LOTTO_NUMBERS = new LinkedList<LottoNumber>();
		for(int i=LottoNumber.MIN_LOTTO_NUMBER;i<=LottoNumber.MAX_LOTTO_NUMBER;i++){
			LOTTO_NUMBERS.add(new LottoNumber(i));
		}
	}
	
	public Lotto(Set<LottoNumber> lottoNumbers){
		if(lottoNumbers.size() != LOTTO_SIZE){
			throw new IllegalArgumentException();
		}
		LottoNumber[] arrayLottoNumbers = new LottoNumber[lottoNumbers.size()];
		lottoNumbers.toArray(arrayLottoNumbers);
		Arrays.sort(arrayLottoNumbers);
		this.lottoNumbers = new LinkedHashSet<LottoNumber>(Arrays.asList(arrayLottoNumbers));
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
	
	public static Lotto ofInt(Integer... numbers){
		Set<LottoNumber> lottoNumbers = new HashSet<LottoNumber>();
		for(int number : numbers){
			lottoNumbers.add(new LottoNumber(number));
		}
		return new Lotto(lottoNumbers);
	}

	public static Lotto random() {
		// TODO Auto-generated method stub		
		Set<LottoNumber> lottoNumbers = new HashSet<LottoNumber>(generateRandomNumbers());
		return new Lotto(lottoNumbers);
	}
	
	private static List<LottoNumber> generateRandomNumbers(){
		Collections.shuffle(LOTTO_NUMBERS);
		List<LottoNumber> result = LOTTO_NUMBERS.subList(0, LOTTO_SIZE);
		return result;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(LottoNumber lottoNumber : lottoNumbers){
			result.append(lottoNumber).append(" /");
		}
		return result.toString();
	}
	
	
}
