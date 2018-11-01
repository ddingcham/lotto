package com.ddingcham.lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Lotto {
	
	private static final int LOTTO_SIZE = 6;
	private static final List<LottoNumber> LOTTO_NUMBERS;
		
	private List<LottoNumber> lottoNumbers;
	
	static{
		LOTTO_NUMBERS = new LinkedList<LottoNumber>();
		for(int i=LottoNumber.MIN_LOTTO_NUMBER;i<=LottoNumber.MAX_LOTTO_NUMBER;i++){
			LOTTO_NUMBERS.add(LottoNumber.ofInt(i));
		}
	}
	
	public Lotto(Set<LottoNumber> lottoNumbers){
		if(lottoNumbers.size() != LOTTO_SIZE){
			throw new IllegalArgumentException();
		}
		this.lottoNumbers = new LinkedList<LottoNumber>();
		this.lottoNumbers.addAll(lottoNumbers);
		Collections.sort(this.lottoNumbers);
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
			lottoNumbers.add(LottoNumber.ofInt(number));
		}
		return new Lotto(lottoNumbers);
	}
	
	public static Lotto ofString(String numbers){
		return ofInt(tokenizeAnswerNumbers(numbers));
	}
	
	private static Integer[] tokenizeAnswerNumbers(String target){
		String[] splitResult = target.split(",");
		Integer[] result = new Integer[splitResult.length];
		for(int i=0;i<splitResult.length;i++){
			result[i] = Integer.valueOf(splitResult[i].trim());
		}
		return result;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((lottoNumbers == null) ? 0 : lottoNumbers.hashCode());
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
		Lotto other = (Lotto) obj;
		if (lottoNumbers == null) {
			if (other.lottoNumbers != null)
				return false;
		} else if (!lottoNumbers.equals(other.lottoNumbers))
			return false;
		return true;
	}

	public boolean contains(LottoNumber lottoNumber) {
		// TODO Auto-generated method stub
		return this.lottoNumbers.contains(lottoNumber);
	}
	
	
	
	
}
