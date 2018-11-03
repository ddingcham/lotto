package com.ddingcham.lotto.domain;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;

public class WinningLottoTest {

	WinningLotto winningLotto;
	Lottoes lottoes;

	@Before
	public void setUp() {
		winningLotto = WinningLotto.ofInt(42, 1, 2, 3, 4, 5, 6);
		lottoes = new Lottoes();

		lottoes.add(Lotto.ofInt(1, 2, 3, 4, 5, 6));
		lottoes.add(Lotto.ofInt(1, 2, 3, 4, 5, 42));
		lottoes.add(Lotto.ofInt(1, 2, 3, 4, 5, 7));
		lottoes.add(Lotto.ofInt(1, 2, 3, 4, 8, 7));
		lottoes.add(Lotto.ofInt(1, 2, 3, 9, 8, 7));
		lottoes.add(Lotto.ofInt(1, 2, 45, 9, 8, 7));
	}

	@Test
	public void calculateResults() {
		LottoResults expectedLottoResults = new LottoResults();
		for(Rank rank : Rank.values()){
			expectedLottoResults.add(rank);
		}
		
		Assertions.assertThat(winningLotto.calculateResults(lottoes))
				.isEqualTo(expectedLottoResults);
	}

	@Test
	public void calculateRank() {
		SoftAssertions softly = new SoftAssertions();

		softly.assertThat(calculateRank(lottoes.get(0))).as("1등 케이스")
				.isEqualTo(Rank.FIRST);
		softly.assertThat(calculateRank(lottoes.get(1))).as("2등 케이스")
				.isEqualTo(Rank.SECOND);
		softly.assertThat(calculateRank(lottoes.get(2))).as("3등 케이스")
				.isEqualTo(Rank.THIRD);
		softly.assertThat(calculateRank(lottoes.get(3))).as("4등 케이스")
				.isEqualTo(Rank.FOURTH);
		softly.assertThat(calculateRank(lottoes.get(4))).as("5등 케이스")
				.isEqualTo(Rank.FIFTH);
		softly.assertThat(calculateRank(lottoes.get(5))).as("꽝 케이스")
				.isEqualTo(Rank.MISS);

		softly.assertAll();

	}

	private Rank calculateRank(Lotto lotto) {
		return winningLotto.calculateRank(lotto);
	}

}
