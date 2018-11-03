package com.ddingcham.lotto;

import java.util.Scanner;

import com.ddingcham.lotto.domain.LottoResults;
import com.ddingcham.lotto.domain.Lottoes;
import com.ddingcham.lotto.domain.Money;
import com.ddingcham.lotto.domain.Rank;
import com.ddingcham.lotto.domain.WinningLotto;

public class LottoGame {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Lottoes boughtLottoes = new Lottoes();
		
		System.out.println("구입금액을 입력해 주세요.");
		LottoFactory lottoFactory = new LottoFactory(new Money(nextLineParsedToInt()));

		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		int numOfNonRandom = nextLineParsedToInt();
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
		for (int i = 0; i < numOfNonRandom; i++) {
			boughtLottoes.add(lottoFactory.generateOfString(scanner.nextLine()));
		}

		boughtLottoes.add(lottoFactory.generateAllRandom());

		System.out.println("수동으로 " + numOfNonRandom + "장, 자동으로 "
				+ (boughtLottoes.size() - numOfNonRandom) + "개를 구매했습니다.");
		System.out.println(boughtLottoes);

		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String answerNumbers = scanner.nextLine().trim();

		System.out.println("보너스 볼을 입력해 주세요.");
		String answerBonus = scanner.nextLine().trim();

		WinningLotto winningLotto = WinningLotto.ofString(answerBonus, answerNumbers);

		System.out.println("당첨 통계");
		System.out.println("-------");

		printResults(winningLotto.calculateResults(boughtLottoes));
	}
	
	private static int nextLineParsedToInt(){
		return Integer.parseInt(scanner.nextLine().trim());
	}
	
	private static void printResults(LottoResults results){
		for(Rank rank : Rank.values()){
			if(rank == Rank.MISS){
				continue;
			}
			System.out.println(rank.getDescription() + " - " + results.count(rank) + "개");
		}
		System.out.printf("총 수익률은 %.1f%%입니다." ,results.calculateProfitRate());
	}
}
