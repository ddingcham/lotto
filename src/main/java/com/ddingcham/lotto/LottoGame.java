package com.ddingcham.lotto;

import java.util.Scanner;

import com.ddingcham.lotto.domain.Lotto;
import com.ddingcham.lotto.domain.Lottoes;

public class LottoGame {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args){
		System.out.println("구입금액을 입력해 주세요.");
		String price = scanner.nextLine().trim();
		
		Lottoes lottoes = Lottoes.generate(Integer.parseInt(price));
		
		System.out.println(lottoes.size() + "개를 구매했습니다.");
		System.out.println(lottoes);

		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String answerInput = scanner.nextLine().trim();
		
		Lotto answer = Lotto.ofString(answerInput);
		System.out.println(answer);
		
		System.out.println("당첨 통계");
		System.out.println("-------");
		
		for(int i=0;i<lottoes.size();i++){
			System.out.println(i + " lotto : " + lottoes.get(i));
			System.out.println(answer.matchCount(lottoes.get(i)));
		}
	}
	

}
