package com.ddingcham.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottoes {
	
	List<Lotto> lottoes = new ArrayList<Lotto>();
	
	public Lottoes(int size){
		for(int i=0;i<size;i++){
			lottoes.add(new Lotto());
		}
	}
	
	public int size() {
		// TODO Auto-generated method stub
		return lottoes.size();
	}

}
