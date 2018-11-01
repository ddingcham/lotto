package com.ddingcham.lotto.domain;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import com.ddingcham.lotto.domain.WinningLotto.Rank;

public class WinningLottoTest {

	@Test
	public void 결과_테스트() {
		WinningLotto answer = WinningLotto.ofInt(42, 1, 2, 3, 4, 5, 6);
		SoftAssertions softly = new SoftAssertions();

		softly.assertThat(generateLottoResult(answer, 1, 2, 3, 4, 5, 6))
				.as("1등 케이스").isEqualTo(Rank.FIRST);
		softly.assertThat(generateLottoResult(answer, 1, 2, 3, 4, 5, 42))
				.as("2등 케이스").isEqualTo(Rank.SECOND);
		softly.assertThat(generateLottoResult(answer, 1, 2, 3, 4, 5, 7))
				.as("3등 케이스").isEqualTo(Rank.THIRD);
		softly.assertThat(generateLottoResult(answer, 1, 2, 3, 4, 8, 7))
				.as("4등 케이스").isEqualTo(Rank.FOURTH);
		softly.assertThat(generateLottoResult(answer, 1, 2, 3, 9, 8, 7))
				.as("5등 케이스").isEqualTo(Rank.FIFTH);
		softly.assertThat(generateLottoResult(answer, 1, 2, 45, 9, 8, 7))
				.as("꽝 케이스").isEqualTo(Rank.MISS);

		softly.assertAll();

	}

	private static Rank generateLottoResult(WinningLotto answer,
			Integer... numbers) {
		return answer.calculateResult(Lotto.ofInt(numbers));
	}

}
