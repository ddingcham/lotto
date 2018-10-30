package com.ddingcham.lotto;

import com.ddingcham.lotto.domain.Lotto;
import com.ddingcham.lotto.domain.Lottoes;

public class LottoGame {
	
	public static void main(String[] args){
		Lotto answer = Lotto.random();
		Lottoes lottoes = Lottoes.generate(5000);
		
		System.out.println("answer : " + answer);
		for(int i=0;i<lottoes.size();i++){
			System.out.println(i + " lotto : " + lottoes.get(i));
			System.out.println(answer.matchCount(lottoes.get(i)));
		}
	}	
}
