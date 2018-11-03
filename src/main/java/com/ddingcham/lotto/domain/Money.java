package com.ddingcham.lotto.domain;

public class Money {

	private int money;
	
	public Money(int money){
		if(money < 1){
			throw new IllegalArgumentException();
		}
		this.money = money;
	}

	public int divide(Money divider) {
		// TODO Auto-generated method stub
		if(this.money < divider.money){
			throw new UnsupportedOperationException();
		}
		return this.money / divider.money;
	}

	public int toInt() {
		// TODO Auto-generated method stub
		return money;
	}
	
}
