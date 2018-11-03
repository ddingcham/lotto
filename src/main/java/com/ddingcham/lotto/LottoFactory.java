package com.ddingcham.lotto;

import com.ddingcham.lotto.domain.Lotto;
import com.ddingcham.lotto.domain.Lottoes;
import com.ddingcham.lotto.domain.Money;

public class LottoFactory {
	
	public static final Money DEFAULT_PRICE = new Money(1000);
	
	private int constructable;
	
	public LottoFactory(Money totalBudget){
		this(totalBudget, DEFAULT_PRICE);
	}

	public LottoFactory(Money totalBudget, Money unitPrice) {
		// TODO Auto-generated constructor stub
		this.constructable = totalBudget.divide(unitPrice);
	}
	
	public Lottoes generateAllRandom(){
		Lottoes lottoes = new Lottoes(constructable);
		updateConstructable(constructable);
		return lottoes;
	}

	public Lottoes generateRandom(int amounts) {
		// TODO Auto-generated method stub
		updateConstructable(amounts);
		return new Lottoes(amounts);
	}
	
	public Lotto generateRandom() {
		// TODO Auto-generated method stub
		updateConstructable(1);
		return Lotto.random();
	}
	
	public Lotto generateOfInt(Integer... numbers){
		updateConstructable(1);
		return Lotto.ofInt(numbers);
	}
	
	public Lotto generateOfString(String numbers){
		updateConstructable(1);
		return Lotto.ofString(numbers);
	}
	
	private void updateConstructable(int amounts){
		if(constructable < amounts){
			throw new RuntimeException();
		}
		constructable -= amounts;
	}

	
}
