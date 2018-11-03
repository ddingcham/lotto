package com.ddingcham.lotto;

import java.util.Scanner;

import com.ddingcham.lotto.domain.Lotto;
import com.ddingcham.lotto.domain.Lottoes;
import com.ddingcham.lotto.domain.WinningLotto;

public class LottoGame {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("구입금액을 입력해 주세요.");
		int price = Integer.parseInt(scanner.nextLine().trim());

		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		int numOfNonRandom = Integer.parseInt(scanner.nextLine().trim());
		price = price - (1000*numOfNonRandom);

		Lottoes lottoes = Lottoes.generate(price);

		for (int i = 0; i < numOfNonRandom; i++) {
			System.out.println("수동으로 구매할 번호를 입력해 주세요.");
			lottoes.add(Lotto.ofString(scanner.nextLine().trim()));
		}

		System.out.println("수동으로 " + numOfNonRandom + "장, 자동으로 "
				+ lottoes.size() + "개를 구매했습니다.");
		System.out.println(lottoes);

		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String answerNumbers = scanner.nextLine().trim();

		System.out.println("보너스 볼을 입력해 주세요.");
		String answerBonus = scanner.nextLine().trim();

		WinningLotto answer = WinningLotto.ofString(answerBonus, answerNumbers);
		System.out.println(answer);

		System.out.println("당첨 통계");
		System.out.println("-------");

		for (int i = 0; i < lottoes.size(); i++) {
			System.out.println(i + " lotto : " + lottoes.get(i));
			System.out.println(answer.calculateResult(lottoes.get(i)));
		}
	}
}
