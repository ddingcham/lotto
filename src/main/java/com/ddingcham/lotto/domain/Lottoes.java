package com.ddingcham.lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lottoes {
	
	public static final int DEFAULT_LOTTO_PRICE = 1000;
	
	List<Lotto> lottoes = new ArrayList<Lotto>();
	
	public Lottoes(int size){
		for(int i=0;i<size;i++){
			lottoes.add(Lotto.random());
		}
	}

	public static Lottoes generate(int price) {
		// TODO Auto-generated method stub
		if(price < DEFAULT_LOTTO_PRICE){
			throw new IllegalArgumentException("구입 금액 부족");
		}
		
		return new Lottoes(price / DEFAULT_LOTTO_PRICE);
	}
	
	public Lottoes(Lotto... lottoes){
		this.lottoes.addAll(Arrays.asList(lottoes));
	}
	
	public int size() {
		// TODO Auto-generated method stub
		return lottoes.size();
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(Lotto lotto:lottoes){
			result.append(lotto).append("\n");
		}
		return result.toString();
	}

	public Lotto get(int i) {
		// TODO Auto-generated method stub
		return lottoes.get(i);
	}

	public void add(Lotto addedLotto) {
		// TODO Auto-generated method stub
		lottoes.add(addedLotto);
	}
	
	

}
