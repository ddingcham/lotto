package com.ddingcham.lotto.domain;

import java.util.HashMap;
import java.util.Map;

import com.ddingcham.lotto.constant.DefaultValue;

public class LottoResults {

	private Map<Rank, Integer> results = new HashMap<Rank, Integer>();

	public LottoResults(){}
	
	public LottoResults(Rank... ranks){
		for(Rank rank : ranks){
			add(rank);
		}
	}
	
	public void add(Rank rank) {
		// TODO Auto-generated method stub
		results.put(rank, count(rank)+1);
	}
	
	public int count(Rank rank){
		return results.getOrDefault(rank, 0);
	}
	
	public double calculateProfitRate(){
		return calculateProfitRate(DefaultValue.DEFAULT_LOTTO_PRICE);
	}
	
	public double calculateProfitRate(Money unitPrice) {
		// TODO Auto-generated method stub
		if(results.isEmpty()){
			return 0;
		}
		double totalPrice = 0;
		int totalCount = 0;
		for(Rank rank:results.keySet()){
			totalPrice += rank.getWinningMoney() * count(rank);
			totalCount += count(rank);
		}
		return totalPrice / totalCount / unitPrice.toInt() * 100;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((results == null) ? 0 : results.hashCode());
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
		LottoResults other = (LottoResults) obj;
		if (results == null) {
			if (other.results != null)
				return false;
		} else if (!results.equals(other.results))
			return false;
		return true;
	}
}
